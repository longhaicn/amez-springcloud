package com.union.aimei.app.api.order.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.order.OrderConstant;
import com.union.aimei.common.constant.order.OrderNumericalConstant;
import com.union.aimei.common.feign.app.product.ProductPhysicalBeauticianRefFeign;
import com.union.aimei.common.feign.app.product.ProductPhysicalFeign;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryVo;
import com.union.aimei.app.api.order.bussiness.GenerateOrderGoodsBase;
import com.union.aimei.app.api.order.bussiness.OrderGoodsBaseVerify;
import com.union.aimei.app.api.order.mapper.OrderGoodsBaseMapper;
import com.union.aimei.app.api.order.mapper.OrderGoodsInfoMapper;
import com.union.aimei.app.api.order.okhttp.ExpressUrl;
import com.union.aimei.app.api.order.okhttp.RequestUtil;
import com.union.aimei.app.api.order.service.OrderGoodsBaseService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.create.CreateOrderNo;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.*;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午1:54
  * @description
  */
@Service("orderGoodsBaseService")
public class OrderGoodsBaseServiceImpl implements OrderGoodsBaseService {
       @Resource
       private OrderGoodsBaseMapper orderGoodsBaseMapper;
       @Resource
       private OrderGoodsInfoMapper orderGoodsInfoMapper;
       @Resource
       private OrderGoodsBaseVerify orderGoodsBaseVerify;
       @Resource
       private GenerateOrderGoodsBase generateOrderGoodsBase;
       @Resource
       private ProductPhysicalFeign productPhysicalFeign;
       @Resource
       private ProductPhysicalBeauticianRefFeign productPhysicalBeauticianRefFeign;

       /**
        * 前端分页查询实物订单表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderGoodsBase 查询条件
        * @return 
        */
       @Override
       public PageInfo<OrderGoodsBase> findByPageForFront(Integer pageNo, Integer pageSize, OrderGoodsBase orderGoodsBase) {
              PageHelper.startPage(pageNo,pageSize);
              List<OrderGoodsBase> list = this.orderGoodsBaseMapper.selectListByConditions(orderGoodsBase);
              PageInfo<OrderGoodsBase> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加实物订单表
        * @param
        * @return
        */
       @Override
       public int addObj(OrderGoodsBase t) {
              return this.orderGoodsBaseMapper.insertSelective(t);
       }

       /**
        * 删除实物订单表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.orderGoodsBaseMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改实物订单表
        * @param
        * @return
        */
       @Override
       @TxTransaction
       @Transactional(rollbackFor = Exception.class)
       public int modifyObj(OrderGoodsBase t) {
              return this.orderGoodsBaseMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnorderGoodsBase
        */
       @Override
       public OrderGoodsBase queryObjById(int id) {
              OrderGoodsBase model=this.orderGoodsBaseMapper.selectByPrimaryKey(id);
              return model;
       }

       @Override
       public ResponseMessage<OrderGoodsBase> queryByOrderNo(String orderNo) {
              ResponseMessage<OrderGoodsBase> res=new ResponseMessage();
              OrderGoodsBase orderGoodsBase=orderGoodsBaseMapper.queryByOrderNo(orderNo);
              if(orderGoodsBase!=null){
                     res.setData(orderGoodsBase);
              }else{
                     res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
                     res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
              }
              return res;
       }

    @Override
    public ResponseMessage updateOrderGoodsBaseInfoAfterPay(String orderNo, Integer payType, String tradeNo, Integer amountPay) {
          Map<String,Object> map=new HashMap<>(4);
          map.put("orderNo",orderNo);
          map.put("payType",payType);
          map.put("tradeNo",tradeNo);
          map.put("amountPay",amountPay);
          int result=orderGoodsBaseMapper.updateAfterPay(map);
          ResponseMessage res=new ResponseMessage();
          res.setData(result);
          return res;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<HashMap<String, Object>> submitGoodsOrderBase(SubmitProductGoodsVo submitProductGoodsVo) {
        ResponseMessage response = new ResponseMessage();
        //验证购买者是否有购买资格
        ResponseMessage<HashMap<String, Object>> res = orderGoodsBaseVerify.verifyIsAllowBuyProductGoods(submitProductGoodsVo.getBeauticianPhone(), submitProductGoodsVo.getPhysicalInventoryList());
        if (HttpStatusConstant.OK.getStatus() != res.getCode()) {
            response.setCode(res.getCode());
            response.setMessage(res.getMessage());
        } else {
            HashMap<String, Object> map = res.getData();
            StoreBeautician storeBeautician = null;
            List<ProductPhysical> physicalList = null;
            Object obj = map.get("storeBeautician");
            Object obj1 = map.get("physicalList");
            if (obj != null) {
                storeBeautician = (StoreBeautician) map.get("storeBeautician");
            }
            if (obj1 != null) {
                physicalList = (List<ProductPhysical>) map.get("physicalList");
            }
            //库存检查
            PhysicalByInventoryForBeauticianVo vo=new PhysicalByInventoryForBeauticianVo();
            vo.setBeauticianId(submitProductGoodsVo.getBeauticianId());
            vo.setInventoryList(submitProductGoodsVo.getPhysicalInventoryList());
            ResponseMessage voMsg=productPhysicalFeign.inventoryPurchaseCheckV111(vo);
            AssertUtil.isRemoteInvokeSuccess(voMsg);
            //构建实物订单基础对象及实物订单产品对象
            OrderGoodsBase orderGoodsBase = generateOrderGoodsBase.getOrderGoodsBase(submitProductGoodsVo, storeBeautician, physicalList);
            //构建实物订单实物产品对象
            List<OrderGoodsInfo> orderGoodsInfoList = generateOrderGoodsBase.getOrderGoodsInfoList(submitProductGoodsVo.getPhysicalInventoryList(), physicalList);
            response = this.submit(orderGoodsBase,orderGoodsInfoList);
            if(HttpStatusConstant.OK.getStatus()==response.getCode()){
                //预约实物订单库存
                ResponseMessage resMsg=productPhysicalFeign.inventoryPurchaseReservationV111(vo);
                if(HttpStatusConstant.OK.getStatus()!=resMsg.getCode()){
                    throw new ServerException(HttpStatusConstant.ERROR.getStatus(),resMsg.getMessage());
                }
            }else{
                throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"提交订单信息失败");
            }
        }
        return response;
    }


    public ResponseMessage<HashMap<String, Object>> submit(OrderGoodsBase orderGoodsBase,List<OrderGoodsInfo> list){
        ResponseMessage<HashMap<String, Object>> responseMessage=new ResponseMessage<>();
        HashMap<String, Object> hashMap=new HashMap<>(16);
        String orderNo= CreateOrderNo.getInstance().GenerateOrder();
        if(!StringUtils.isBlank(orderNo)&&orderNo.length()==OrderNumericalConstant.MAX_ORDER_LEN.getValue()){
            orderGoodsBase.setOrderNo(orderNo);
        }
        int res=orderGoodsBaseMapper.insertSelective(orderGoodsBase);
        if(res<0){
            responseMessage.setCode(OrderConstant.Insert.ORDER_BASE_FAIL);
            responseMessage.setMessage(OrderConstant.Insert.ORDER_BASE_FAIL_MSG);
        }else{
            //获取美容师最新添加订单信息
            int id=orderGoodsBase.getId();
            hashMap.put("goodsOrderId",id);
            hashMap.put("goodsOrderNo",orderNo);
            for(OrderGoodsInfo info:list){
                info.setOrderGoodsBaseId(id);
            }
            //批量添加实物商品订单信息
            orderGoodsInfoMapper.batchInsert(list);
            responseMessage.setData(hashMap);
        }
        return responseMessage;
    }

    @Override
    public PageInfo<OrderGoodsDetailVo> queryByPage(Integer pageNo, Integer pageSize, OrderGoodsQueryVo orderGoodsQueryVo) {
        PageHelper.startPage(pageNo,pageSize);
        PageHelper.orderBy("add_time DESC");
        List<OrderGoodsDetailVo> allList=new ArrayList<>(10);
        if(orderGoodsQueryVo!=null){
            String startTime=orderGoodsQueryVo.getStartAddTime();
            String endTime=orderGoodsQueryVo.getEndAddTime();
            if(!StringUtils.isBlank(startTime)){
                orderGoodsQueryVo.setStartAddTime(orderGoodsQueryVo.getStartAddTime()+" 00:00:00");
            }
            if(!StringUtils.isBlank(endTime)){
                orderGoodsQueryVo.setEndAddTime(orderGoodsQueryVo.getEndAddTime()+" 23:59:59");
            }
        }
        List<OrderGoodsBase> orderGoodsList=orderGoodsBaseMapper.queryByConditions(orderGoodsQueryVo);
        if(!CollectionUtils.isEmpty(orderGoodsList)){
            orderGoodsList.forEach(x->{
                OrderGoodsDetailVo vo=new OrderGoodsDetailVo();
                vo.setOrderGoodsBase(x);
                List<OrderGoodsInfo> list=orderGoodsInfoMapper.queryByOrderGoodsId(x.getId());
                vo.setGoodsInfoList(list);
                allList.add(vo);
            });
        }
        PageInfo<OrderGoodsDetailVo> page = new PageInfo<>(allList);
        return page;
    }


    @Override
    public ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(String orderNo) {
        ResponseMessage<LogisticsInfoVo> responseMessage=new ResponseMessage<>();
        OrderGoodsBase orderGoodsBase=orderGoodsBaseMapper.queryForOrderNo(orderNo);
        if(orderGoodsBase==null){
            responseMessage.setCode(OrderConstant.QUERY_ORDER_IS_NOT_EXSIT);
            responseMessage.setMessage(OrderConstant.QUERY_ORDER_IS_NOT_EXSIT_MSG);
        }else{
            try {
                JsonObject json= getKuaiOneHundredInfo(orderGoodsBase);
                if(json!=null){
                    String status=json.get("status").getAsString();
                    String msg=json.get("message").getAsString();
                    String state=json.get("state").getAsString();
                    if(String.valueOf(HttpStatusConstant.OK.getStatus()).equals(status)){
                        JsonArray data=json.get("data").getAsJsonArray();
                        LogisticsInfoVo logisticsInfoVo=new LogisticsInfoVo();
                        String companyName=orderGoodsBase.getExpressCompanyName();
                        logisticsInfoVo.setLogisticsName(companyName);
                        String deliveryOrderNo=orderGoodsBase.getDeliveryOrderNo();
                        logisticsInfoVo.setDeliveryNo(deliveryOrderNo);
                        logisticsInfoVo.setState(Integer.parseInt(state));
                        Gson gson=new Gson();
                        LinkedList<SendInfoVo> sendInfoVos=new LinkedList<>();
                        for(JsonElement js:data){
                            SendInfoVo sendInfoVo=gson.fromJson(js,SendInfoVo.class);
                            sendInfoVos.add(sendInfoVo);
                        }
                        logisticsInfoVo.setLinkedList(sendInfoVos);
                        responseMessage.setData(logisticsInfoVo);
                    }else{
                        responseMessage.setCode(Integer.parseInt(status));
                        responseMessage.setMessage(msg);
                    }
                }else{
                    responseMessage.setCode(OrderConstant.INVOKE_KD100_FAIL);
                    responseMessage.setMessage(OrderConstant.INVOKE_KD100_FAIL_MSG);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return responseMessage;
    }


    private JsonObject getKuaiOneHundredInfo(OrderGoodsBase orderGoodsBase)throws Exception{
        String companyCode=orderGoodsBase.getExpressCompanyCode();
        String deliveryOrderNo=orderGoodsBase.getDeliveryOrderNo();
        JsonObject parm=new JsonObject();
        parm.addProperty("com",companyCode);
        parm.addProperty("num",deliveryOrderNo);
        StringBuilder sb=new StringBuilder();
        sb.append(parm.toString());
        sb.append(ExpressUrl.KEY);
        sb.append(ExpressUrl.CUSTOMER);
        String sign = md5Encrypt(sb.toString());
        JsonObject json= RequestUtil.doPost(ExpressUrl.QUERY_INTERFACE_ADDRESS,ExpressUrl.CUSTOMER,ExpressUrl.KEY,sign,parm.toString());
        return json;
    }


    private static String  md5Encrypt(String str)throws Exception{
        String result="";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((str).getBytes("UTF-8"));
        byte[] b = md5.digest();

        int i;
        StringBuffer buf = new StringBuffer("");

        for(int offset=0; offset<b.length; offset++){
            i = b[offset];
            if(i<0){
                i+=256;
            }
            if(i<16){
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }

        result = buf.toString().toUpperCase();
        return result;
    }


    @Override
    @TxTransaction(isStart = true,rollbackFor = Exception.class)
    public ResponseMessage cancelOrderGoodsBase(Integer id) {
        ResponseMessage responseMessage= ResponseMessageFactory.newInstance();
        PhysicalByInventoryForBeauticianVo vo=new PhysicalByInventoryForBeauticianVo();
        OrderGoodsBase orderGoodsBase=orderGoodsBaseMapper.selectByPrimaryKey(id);
        if(orderGoodsBase==null){
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        boolean isEnabled=orderGoodsBase.getIsEnabled();
        if(!isEnabled){
            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"请勿重复取消订单");
        }
        orderGoodsBase.setIsEnabled(false);
        int result=orderGoodsBaseMapper.updateByPrimaryKeySelective(orderGoodsBase);
        if(1!=result){
            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"取消订单失败，请稍后重试");
        }
        List<OrderGoodsInfo> goodsList=orderGoodsInfoMapper.queryByOrderGoodsId(id);
        List<PhysicalByInventoryVo> list=null;
        if(!CollectionUtils.isEmpty(goodsList)){
            list=new ArrayList<>(10);
            for(OrderGoodsInfo goods:goodsList){
                PhysicalByInventoryVo voObj=new PhysicalByInventoryVo();
                voObj.setProductPhysicalId(goods.getProductPhysicalId());
                voObj.setPhysicalNumber(goods.getNums());
                list.add(voObj);
            }
        }
        vo.setBeauticianId(orderGoodsBase.getBeauticianId());
        vo.setInventoryList(list);
        ResponseMessage res=productPhysicalFeign.inventoryCancelPurchaseReservationV111(vo);
        if(HttpStatusConstant.OK.getStatus()!=res.getCode()){
            throw new ServerException(res.getCode(),res.getMessage());
        }
        return responseMessage;
    }




    @Override
    public ResponseMessage confirmReceiveGoods(Integer orderGoodsId){
        ResponseMessage res=ResponseMessageFactory.newInstance();
        OrderGoodsBase orderGoodsBase=orderGoodsBaseMapper.selectByPrimaryKey(orderGoodsId);
        if(orderGoodsBase!=null){
            int status=orderGoodsBase.getStatus();
            if(OrderBase.OrderStatus.WAIT_SERVER ==status){
                orderGoodsBase.setStatus(3);
                orderGoodsBase.setReceiveTime(new Date());
                orderGoodsBaseMapper.updateByPrimaryKeySelective(orderGoodsBase);
            }else{
                throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"订单未付款或者已收货");
            }
        }else{
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }
}