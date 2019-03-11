package com.union.aimei.pay.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.pay.HasPayEnum;
import com.union.aimei.common.feign.app.learn.LearnTradeRecodeFeign;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.feign.app.order.OrderGoodsInfoFeign;
import com.union.aimei.common.feign.app.order.OrderProductConsumeGoodsRecordFeign;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.feign.app.product.ProductPhysicalFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.app.store.StoreCouponsReceivedFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.feign.app.system.SendSmsFeign;
import com.union.aimei.common.feign.app.umeng.BasePushTemplateFeign;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.model.order.*;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.learn.app.TradeRecodeCallBackVo;
import com.union.aimei.common.vo.order.SubmitOrder;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.aimei.common.vo.pay.SettlementVo;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.store.app.StoreByStoreSalesVo;
import com.union.aimei.common.vo.store.app.StoreCouponsReceivedByUsedVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.common.vo.umeng.SendMsgParamVo;
import com.union.aimei.common.vo.umeng.templatecode.ServicePushCodeEnum;
import com.union.aimei.pay.service.AfterPayService;
import com.union.aimei.pay.settle.SettleUtil;
import com.union.aimei.pay.settle.rule.SettlementRule;
import com.union.aimei.pay.settle.settlement.BeauticianSettlement;
import com.union.aimei.pay.settle.settlement.PlatformSettlement;
import com.union.aimei.pay.settle.settlement.StoreSettlement;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import com.union.redis.RedisService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
  * @author GaoWei
  * @Date 18-8-13 下午2:48
  * @description
  */
@Service
@CommonsLog
public class AfterPayServiceImpl implements AfterPayService {

    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private ProductFeign productFeign;
    @Resource
    private StoreFeign storeFeign;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;
    @Resource
    private ProductPhysicalFeign productPhysicalFeign;
    @Resource
    private OrderGoodsInfoFeign orderGoodsInfoFeign;
    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;
    @Resource
    private LearnTradeRecodeFeign learnTradeRecodeFeign;
    @Resource
    private SendSmsFeign sendSmsFeign;
    @Resource
    private BasePushTemplateFeign basePushTemplateFeign;
    @Resource
    private SettlementRule settlementRule;
    @Resource
    private  BeauticianSettlement beauticianSettlement;
    @Resource
    private PlatformSettlement platformSettlement;
    @Resource
    private StoreSettlement storeSettlement;
    @Resource
    private RedisService redisService;
    @Resource
    private OrderProductConsumeGoodsRecordFeign orderProductConsumeGoodsRecordFeign;
    @Resource
    private StoreCouponsReceivedFeign storeCouponsReceivedFeign;



    @Override
    @TxTransaction(isStart = true,rollbackFor = Exception.class)
    public ResponseMessage hasPaySuccess(PayReturnVo payReturnVo) {
        int payUseType=payReturnVo.getPayUseType();
        try{
            switch (payUseType){
                case 0:
                    log.info("开始执行项目购买业务");
                    hasPayProductSuccess(payReturnVo);
                    log.info("执行项目购买业务成功");
                    break;
                case 1:
                    log.info("开始执行实物商品购买成功业务");
                    hasPayGoods(payReturnVo);
                    log.info("执行实物商品购买成功业务");
                    break;
                case 2:
                    log.info("开始执行课程购买业务");
                    hasPayLearnRecord(payReturnVo);
                    log.info("执行课程购买业务成功");
                    break;
                case 3:
                    log.info("开始执行活动购买业务");
                    hasPayLearnRecord(payReturnVo);
                    log.info("执行活动购买业务成功");
                    break;
                default:;break;
            }
        }catch (Exception e){
            log.warn("支付回调业务异常：");
            log.warn("需要补偿的订单号："+payReturnVo.getOrderNo());
            //将需要补偿的订单信息存入redis
            StringBuilder sb=new StringBuilder();
            sb.append(HasPayEnum.PAY_COMPENSATE_HASH_KEY.getValue());
            sb.append(payReturnVo.getOrderNo());
            redisService.hmSet(HasPayEnum.PAY_COMPENSATE_KEY.getValue(),sb.toString(),new Gson().toJson(payReturnVo,PayReturnVo.class));
            log.warn("填入redis完成");
            e.printStackTrace();
        }
        return new ResponseMessage();
    }


    /**
     * 购买项目成功处理
     * @param  payReturnVo
     */
    public void hasPayProductSuccess(PayReturnVo payReturnVo)throws Exception{
        ResponseMessage<SubmitOrder> res=orderBaseFeign.queryOrderAllInfoByOrderNo(payReturnVo.getOrderNo());
        AssertUtil.isRemoteInvokeSuccess(res);
        SubmitOrder submitOrder=res.getData();
        OrderBase orderBase=submitOrder.getOrderBase();
        OrderBeautician orderBeautician=submitOrder.getOrderBeautician();
        OrderProduct orderProduct=submitOrder.getOrderProduct();
        ResponseMessage<StoreBeautician> message=storeBeauticianFeign.findById(orderBeautician.getBeauticianId());
        AssertUtil.isRemoteInvokeSuccess(message);
        StoreBeautician storeBeautician=message.getData();
        int beauticianRelation=storeBeautician.getAffiliatedStatus();
        ResponseMessage<Product> productMsg=productFeign.findById(orderProduct.getProductId());
        AssertUtil.isRemoteInvokeSuccess(productMsg);
        Product product=productMsg.getData();
        Integer storeId=orderBase.getStoreId();
        Store store=null;
        if(storeId!=null&&storeId!=0){
            store=storeFeign.queryById(orderBase.getStoreId());
            Optional.ofNullable(store).filter(store1 -> store1!=null).orElseThrow(()->new ServerException(500,"查询店铺信息失败"));
        }
        //0:锁定项目包含的实物产品库存
        log.info("锁定实物产品库存");
        inventoryOrderReservation(orderProduct.getProductId(),orderBeautician.getBeauticianId());
        log.info("判断是否使用优惠券"+orderBase.getCouponReduce()==null?"true":"false");
        //1:判断是否有使用优惠券，消耗优惠券
        useCoupon(orderBase.getCouponReduce(),orderBase,orderProduct);
        log.info("订单美容师服务时间已锁定，产品库存已消耗");
        //2:平台，店铺及美容师结算
        computationalExtraction(beauticianRelation,product,store,orderBase,orderProduct,orderBeautician);
        log.info("三方结算已处理");
        //3:更新项目销售记录及预约人数
        updateProudct(orderBase.getStoreId(),product.getId());
        log.info("项目信息已更新");
        //4:更新店铺销售量
        addStoreSellRecord(orderBase.getStoreId());
        log.info("店铺销量已增加");
        //5:发送短信
        sendMsg(orderBase,orderBeautician,orderProduct);
        log.info("短信已发送");
        //6:推送APP消息(重新修改)
        pushToApp(orderBase,orderBeautician,orderProduct,product.getServerNeedTime());
        log.info("app消息已推送");
    }

    private void useCoupon(Integer couponReduce,OrderBase orderBase,OrderProduct orderProduct){
        if(couponReduce!=null&&couponReduce>0){
            StoreCouponsReceivedByUsedVo couponVo=new StoreCouponsReceivedByUsedVo();
            couponVo.setMemberId(orderBase.getMemberId());
            couponVo.setOrderNo(orderBase.getOrderNo());
            couponVo.setProductId(orderProduct.getProductId());
            couponVo.setProductName(orderProduct.getProductName());
            couponVo.setStoreCouponsId(orderBase.getCouponId());
            log.info("使用优惠券信息："+couponVo.toString());
            storeCouponsReceivedFeign.used(couponVo);
        }
    }

    /**
     * 预约项目中包含的产品库存
     * @param productId
     * @param beauticianId
     */
    private void inventoryOrderReservation(int productId,int beauticianId){
        ResponseMessage reMsg= productFeign.inventoryOrderReservationV111(productId,beauticianId);
        if(HttpStatusConstant.OK.getStatus() !=reMsg.getCode()){
            throw new ServerException(500,reMsg.getMessage());
        }

    }
    /**
     * 计算平台、店铺、美容师提成，生成各自的交易流水
     * 特殊情况生成业绩考核记录
     * @param beauticianRelation
     * @param product
     * @param store
     * @param orderBase
     * @param orderProduct
     * @param orderBeautician
     */
    public void computationalExtraction(int beauticianRelation,Product product,Store store, OrderBase orderBase, OrderProduct orderProduct, OrderBeautician orderBeautician)throws Exception{
        int productType= product.getProductType();
        int orderType=orderBase.getType();
        SettlementVo vo=new SettlementVo();
        vo.setAmountPay(orderBase.getAmountPay());
        vo.setBeauticianId(orderBeautician.getBeauticianId());
        vo.setPayType(SettleUtil.changePayTypeToInt(orderBase.getPayType()));
        vo.setProductId(orderProduct.getProductId());
        vo.setProductType(productType);
        vo.setOneCardDiscount(orderBase.getOneCardDiscount()==null?0:orderBase.getOneCardDiscount().doubleValue());
        vo.setBeauticianType(orderBeautician.getType());
        vo.setFrieht(orderBase.getFreight()==null?0:orderBase.getFreight());
        Map<String,Integer> map=settlementRule.calculateCommission(vo);
        int beauticianCommission=map.get("beauticianCommission");
        int platformCommission=map.get("platformCommission");
        int storeCommission=map.get("storeCommission");
        log.info("添加美容师流水表");
        //添加美容师流水表
        beauticianSettlement.executeSettlement(beauticianCommission,platformCommission,storeCommission,orderBase,orderBeautician,orderProduct,product);
        log.info("美容师流水记录已添加");
        //添加平台流水表
        platformSettlement.executeSettlement(beauticianCommission,storeCommission,platformCommission,orderBase,orderBeautician,orderProduct,store);
        log.info("平台流水记录已添加");
        //添加店铺流水/特殊情况生成业绩考核记录
        String storePhone="";
        if(store!=null){
            storePhone=store.getSellerPhone();
        }
        if(orderBase.getStoreId()!=null){
            storeSettlement.executeSettlement(productType,orderType,beauticianRelation,beauticianCommission,storeCommission,orderBase,orderBeautician,orderProduct,storePhone);
            log.info("店铺流水已添加");
        }
    }



    /**
     * 更新项目
     * @param storeId
     * @param productId
     */
    private void updateProudct(Integer storeId,Integer productId)throws ServerException{
        ProductUpdateOrderPayVo vo=new ProductUpdateOrderPayVo();
        vo.setStoreId(storeId);
        vo.setProductId(productId);
        productFeign.updateOrderPayV111(vo);
        log.info("更新项目信息");
    }



    /**
     * 添加店铺销量
     * @param storeId
     */
    private void addStoreSellRecord(Integer storeId)throws ServerException{
        StoreByStoreSalesVo vo=new StoreByStoreSalesVo();
        vo.setId(storeId);
        vo.setStoreSales(1);
        ResponseMessage res=storeFeign.accumulateByStoreSales(vo);
        log.info("添加店铺销量："+res);
    }



    /**
     * 实物商品已支付
     * @param payReturnVo
     */
    public void hasPayGoods(PayReturnVo payReturnVo) throws ServerException{
        ResponseMessage<OrderGoodsBase> res = orderGoodsBaseFeign.queryByOrderNo(payReturnVo.getOrderNo());
        OrderGoodsBase orderGoodsBase = res.getData();
        Integer status = orderGoodsBase.getStatus();
        if (0 == status) {
            ResponseMessage<List<OrderGoodsInfo>> respon = orderGoodsInfoFeign.queryByOrderId(orderGoodsBase.getId());
            AssertUtil.isRemoteInvokeSuccess(respon);
            List<OrderGoodsInfo> list = respon.getData();
            List<PhysicalByInventoryVo> voList=new ArrayList<>(10);
            for (OrderGoodsInfo info :list){
                PhysicalByInventoryVo pyVo=new PhysicalByInventoryVo();
                pyVo.setPhysicalNumber(info.getNums());
                pyVo.setProductPhysicalId(info.getProductPhysicalId());
                voList.add(pyVo);
            }
            PhysicalByInventoryForBeauticianVo vo=new PhysicalByInventoryForBeauticianVo();
            vo.setBeauticianId(orderGoodsBase.getBeauticianId());
            vo.setInventoryList(voList);
            ResponseMessage resMsg= productPhysicalFeign.inventroyPurchaseStorageV111(vo);
            log.info("实物产品库存释放："+res.toString());
            AssertUtil.isRemoteInvokeSuccess(resMsg);
            ResponseMessage upMsgResponseMessage=orderGoodsBaseFeign.updateOrderGoodsBaseInfoAfterPay(payReturnVo);
            log.info("实物订单状态修改："+upMsgResponseMessage.toString());
            AssertUtil.isRemoteInvokeSuccess(resMsg);
        }
    }


    /**
     * 活动/课程支付成功
     * @param payReturnVo
     */
    private void hasPayLearnRecord(PayReturnVo payReturnVo)throws ServerException {
        ResponseMessage<LearnTradeRecode> res=learnTradeRecodeFeign.queryTradeRecodeByOrderNo(payReturnVo.getOrderNo());
        AssertUtil.isRemoteInvokeSuccess(res);
        TradeRecodeCallBackVo vo=new TradeRecodeCallBackVo();
        vo.setOrderNo(payReturnVo.getOrderNo());
        vo.setPayType(payReturnVo.getPayType().byteValue());
        vo.setTradeNo(payReturnVo.getTradeNo());
        vo.setTradeAmount(payReturnVo.getAmountPay());
        ResponseMessage responseMessage = learnTradeRecodeFeign.tradeRecodeCallBack(vo);
        log.info("修改活动/课程订单状态："+responseMessage.toString());
        AssertUtil.isRemoteInvokeSuccess(responseMessage);
    }




    /**
     * @author GaoWei
     * @describe  推送短信
     * @time 2018/3/26,10:49
     */
    public void sendMsg(OrderBase orderBase,OrderBeautician orderBeautician,OrderProduct orderProduct){
        List<SmsMessageVo> list=getSendMsgList(orderBase,orderBeautician,orderProduct);
        if(!CollectionUtils.isEmpty(list)){
            log.info("开始发送短信：");
            int result=sendSmsFeign.sendSmsCodeList(list);
            log.info("发送短信结果：："+result);
        }
    }

    /**
     * 推送APP消息给美容师和店长
     * @param orderBase
     * @param orderBeautician
     */
    public void pushToApp(OrderBase orderBase,OrderBeautician orderBeautician,OrderProduct orderProduct,int serverNeedTime){
        List<SendMsgParamVo> list=new ArrayList<>(10);
        SendMsgParamVo beauticianVo=new SendMsgParamVo();
        beauticianVo.setMemberId(orderBeautician.getBeauticianMemberId());
        beauticianVo.setTemplateCode(ServicePushCodeEnum.PAY_SUCCESS_TO_BEAUTICIAN.getValue());
        beauticianVo.setOrderNo(orderBase.getOrderNo());
        Map<String,Object> map=new HashMap<>(16);
        map.put("type",SendMsgParamVo.ORDER_TYPE);
        map.put("id",orderBase.getId());
        map.put("productName",orderProduct.getProductName());
        map.put("productImg",orderProduct.getProductImg());
        map.put("serverNeedTime",serverNeedTime);
        map.put("orderType",orderBase.getType());
        map.put("appointTime",orderBase.getServerStartTime());
        beauticianVo.setCustoms(map);
        list.add(beauticianVo);
        SendMsgParamVo storeVo=new SendMsgParamVo();
        storeVo.setMemberId(orderBeautician.getStoreSellerMemberId());
        storeVo.setTemplateCode(ServicePushCodeEnum.PAY_SUCCESS_TO_STORE.getValue());
        storeVo.setCustoms(map);
        storeVo.setOrderNo(orderBase.getOrderNo());
        list.add(storeVo);
        basePushTemplateFeign.sendMessage(list);
    }

    private List<SmsMessageVo> getSendMsgList(OrderBase orderBase, OrderBeautician orderBeautician, OrderProduct orderProduct){
        Integer orderType=orderBase.getType();
        String memberPhone=orderBase.getMemberPhone();
        String customerPhone=orderBase.getCustomerPhone();
        List<SmsMessageVo> list=new ArrayList<>(16);
        SmsMessageVo memberMsg=new SmsMessageVo();
        String phone=orderType==0?memberPhone:customerPhone;
        memberMsg.setPhone(phone);
        memberMsg.setSmsCode(SmsConstant.PAY_SUCCESS.getSmsCode());
        JsonObject json=new JsonObject();
        String productName=orderProduct.getProductName();
        json.addProperty("code",productName);
        memberMsg.setSmsContent(json.toString());
        list.add(memberMsg);
        JsonObject json1=new JsonObject();
        String orderNo=orderBase.getOrderNo();
        int length=orderNo.length();
        json1.addProperty("code",orderNo.substring(length-5,length));
        SmsMessageVo storeOwnerMsg;
        //门店自营项目则发送
        if(orderBase.getType()==0){
            storeOwnerMsg=new SmsMessageVo();
            String storeOwnerPhone=orderBeautician.getStoreSellerPhone();
            storeOwnerMsg.setPhone(storeOwnerPhone);
            storeOwnerMsg.setSmsCode(SmsConstant.PAY_SUCCESS_NOTIFY_STORE_FOR_STORE_SELL.getSmsCode());
            json.addProperty("code",productName);
            storeOwnerMsg.setSmsContent(json1.toString());
            list.add(storeOwnerMsg);
        }
        SmsMessageVo beauticianMsg=new SmsMessageVo();
        String beauticianPhone=orderBeautician.getMobile();
        beauticianMsg.setPhone(beauticianPhone);
        beauticianMsg.setSmsCode(SmsConstant.PAY_SUCCESS_NOTIFY_BEAUTICIAN.getSmsCode());
        beauticianMsg.setSmsContent(json1.toString());
        list.add(beauticianMsg);
        log.info("需要发送的list集合为："+list.toString());
        return list;
    }




}
