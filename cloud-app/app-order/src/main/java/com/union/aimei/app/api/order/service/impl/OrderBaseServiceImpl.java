package com.union.aimei.app.api.order.service.impl;

import com.alipay.api.response.AlipayTradeRefundResponse;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.order.OrderConstant;
import com.union.aimei.common.constant.order.OrderNumericalConstant;
import com.union.aimei.common.constant.pay.PayTypeEnum;
import com.union.aimei.common.feign.app.financial.BeauticianTradeDetailFeign;
import com.union.aimei.common.feign.app.financial.PlatformTradeDetailFeign;
import com.union.aimei.common.feign.app.financial.StoreTradeDetailFeign;
import com.union.aimei.common.feign.app.member.MemberFeign;
import com.union.aimei.common.feign.app.order.OrderProductConsumeGoodsRecordFeign;
import com.union.aimei.common.feign.app.pay.PayReFundFeign;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.common.model.order.*;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.aimei.common.vo.pay.RefundParamVo;
import com.union.aimei.app.api.order.async.AgreeRefundTask;
import com.union.aimei.app.api.order.async.CustomerApplyRefundTask;
import com.union.aimei.app.api.order.async.CustomerCancelRefundTask;
import com.union.aimei.app.api.order.async.RefuseRefundTask;
import com.union.aimei.app.api.order.bussiness.GenerateOrderBase;
import com.union.aimei.app.api.order.bussiness.OrderBaseVerify;
import com.union.aimei.app.api.order.mapper.*;
import com.union.aimei.app.api.order.service.OrderBaseService;
import com.union.aimei.common.vo.product.app.ProductPhysicalByInventoryVo;
import com.union.common.utils.*;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.create.CreateOrderNo;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/11,17:52
*/
@Service("orderBaseService")
public class OrderBaseServiceImpl implements OrderBaseService {


    private static final Logger log= LoggerFactory.getLogger(OrderBaseServiceImpl.class);

    @Resource
    private OrderBaseMapper orderBaseMapper;
    @Resource
    private OrderProductMapper orderProductMapper;
    @Resource
    private OrderBeauticianMapper orderBeauticianMapper;
    @Resource
    private OrderReturnMapper orderReturnMapper;
    @Resource
    private OrderCommentMapper orderCommentMapper;
    @Resource
    private OrderProductConsumeGoodsRecordMapper orderProductConsumeGoodsRecordMapper;
    @Resource
    private OrderRefundsConsultRecordMapper orderRefundsConsultRecordMapper;
    @Resource
    private OrderBaseVerify orderBaseVerify;
    @Resource
    private GenerateOrderBase generateOrderBase;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;
    @Resource
    private MemberFeign memberFeign;
    @Resource
    private StoreTradeDetailFeign storeTradeDetailFeign;
    @Resource
    private BeauticianTradeDetailFeign beauticianTradeDetailFeign;
    @Resource
    private CustomerApplyRefundTask customerApplyRefundTask;
    @Resource
    private CustomerCancelRefundTask customerCancelRefundTask;
    @Resource
    private AgreeRefundTask agreeRefundTask;
    @Resource
    private RefuseRefundTask refuseRefundTask;
    @Resource
    private PayReFundFeign payReFundFeign;
    @Resource
    private PlatformTradeDetailFeign platformTradeDetailFeign;
    @Resource
    private OrderProductConsumeGoodsRecordFeign orderProductConsumeGoodsRecordFeign;
    @Resource
    private ProductFeign productFeign;


    /**
     * 前端分页查询订单
     *
     * @param pageNo    分页索引
     * @param pageSize  每页显示数量
     * @param orderBase 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<HashMap<String,Object>>> findByPageForFront(Integer pageNo, Integer pageSize, OrderBase orderBase) {
        PageHelper.startPage(pageNo, pageSize);
        if(orderBase!=null){
            Integer returnStatus=orderBase.getReturnStatus();
            if(returnStatus!=null){
                if(returnStatus==OrderBase.QUERY_ALL_RETURN_ORDER) {
                    PageHelper.orderBy("return_status ASC,add_time desc");
                }else{
                    PageHelper.orderBy("add_time desc");
                }
            }else{
                PageHelper.orderBy("add_time desc");
            }
        }else{
            PageHelper.orderBy("add_time desc");
        }
        List<HashMap<String,Object>> list=new ArrayList<>(0);
        //判断请求条件(不允许返回待付款状态订单，除非前段传递订单状态为-1)
        if(orderBase!=null){
                Integer status=orderBase.getStatus();
                list=this.orderBaseMapper.selectOrderInfo(orderBase);
        }
        PageInfo<HashMap<String,Object>> page = new PageInfo<>(list);
        ResponseMessage<PageInfo<HashMap<String,Object>>> res=new ResponseMessage<>();
        res.setData(page);
        return res;
    }

    /**
     * 添加订单
     *
     * @param
     * @return
     */
    @Override
    @Deprecated
    public int addObj(OrderBase t) {
        //添加22位的订单编号
        t.setOrderNo(CreateOrderNo.getInstance().GenerateOrder());
        int result=this.orderBaseMapper.insertSelective(t);
        return result;
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Override
    @Deprecated
    public int deleteObjById(int id) {
        return this.orderBaseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改订单
     *
     * @param
     * @return
     */
    @Override
    public int modifyObj(OrderBase t) {
        return this.orderBaseMapper.updateByPrimaryKeySelective(t);
    }



    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderBase
     */
    @Override
    public OrderBase queryObjById(int id) {
        OrderBase model = this.orderBaseMapper.selectByPrimaryKey(id);
        return model;
    }

    /**
     * 提交订单
     * @param submitOrderVo 订单信息
     * @return
     */
    @Override
    @TxTransaction(isStart = true,rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<HashMap<String,Object>> submitProductOrder(SubmitOrderVo submitOrderVo) {
        log.info("请求数据为:"+submitOrderVo.toString());
        boolean isToDoorOr = OrderBase.TO_DOOR == submitOrderVo.getType();
        ResponseMessage<HashMap<String, Object>> response = orderBaseVerify.verifySubmitInfo(isToDoorOr, submitOrderVo);
        //验证数据正常
        if (response.getCode() == HttpStatusConstant.OK.getStatus()) {
            Map<String, Object> map = response.getData();
            Member member = (Member) map.get("member");
            Store store = (Store) map.get("store");
            Product product = (Product) map.get("product");
            StoreBeautician storeBeautician = (StoreBeautician) map.get("storeBeautician");
            List<OrderProductConsumeGoodsRecord> physicalList = null;
            Object obj = map.get("physicalList");
            if (obj != null) {
                physicalList = (List<OrderProductConsumeGoodsRecord>) map.get("physicalList");
            }
            Integer storedId = submitOrderVo.getStoreId()==null?0:submitOrderVo.getStoreId();
            Integer beauticianId = submitOrderVo.getBeauticianId();
            Integer productId = submitOrderVo.getProductId();
            Integer formlaCom=product.getFormalBeauticianCommission();
            Integer partTimecome=product.getParttimeBeauticianCommission();
            Integer nums = submitOrderVo.getNum();
            Integer serverNeedTime = submitOrderVo.getServerNeedTime();
            MemberCardRef memberCardRef = (MemberCardRef) map.get("memberCardRef");
            //获取订单基础对象
            ResponseMessage res = generateOrderBase.generateOrderBase(isToDoorOr, submitOrderVo, member, store, product,memberCardRef);
            if (HttpStatusConstant.OK.getStatus() == res.getCode()) {
                OrderBase orderBase = (OrderBase) res.getData();
                //获取订单美容师对象
                OrderBeautician orderBeautician = generateOrderBase.generateOrderBeautician(storedId,formlaCom,partTimecome,store,beauticianId, storeBeautician);
               //获取订单商品对象
                OrderProduct orderProduct = generateOrderBase.generateOrderProduct(storedId, productId, nums, product, serverNeedTime);
                response = this.submit(orderBase,orderBeautician,orderProduct,physicalList);
            } else {
                response.setCode(res.getCode());
                response.setMessage(res.getMessage());
            }
        }
        return response;

    }


    public ResponseMessage submit(OrderBase orderBase,OrderBeautician orderBeautician,OrderProduct orderProduct,List<OrderProductConsumeGoodsRecord> consumeList){
        ResponseMessage<HashMap<String,Object>> responseMessage=new ResponseMessage<>();
        String orderNo= CreateOrderNo.getInstance().GenerateOrder();
        //判断生成的订单编号是否为空，并且订单编号必须为24位
        boolean isOrderNo=!StringUtils.isBlank(orderNo)&&orderNo.length()== OrderNumericalConstant.MAX_ORDER_LEN.getValue();
        if(isOrderNo){
            //添加订单基础数据
            orderBase.setOrderNo(orderNo);
            int res=orderBaseMapper.insertSelective(orderBase);
            if(res<=0){
                throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"添加订单信息失败");
            }else{
                int id=orderBase.getId();
                //获取添加的订单基础数据ID
                OrderBase orderBase1=orderBaseMapper.selectByPrimaryKey(id);
                if(orderBase1!=null){
                    Integer storeId=orderBase.getStoreId();
                    //添加订单商品
                    orderProduct.setStoreId(storeId);
                    orderProduct.setOrderId(id);
                    int addProduct=this.orderProductMapper.insertSelective(orderProduct);
                    if(addProduct<=0){
                        throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"添加订单产品信息失败");
                    }else{
                        if(consumeList!=null){
                            for(OrderProductConsumeGoodsRecord o:consumeList){
                                o.setOrderId(id);
                            }
                            //批量插入订单实物产品消耗记录
                            orderProductConsumeGoodsRecordMapper.batchInsertRecord(consumeList);
                        }
                        //添加订单美容师
                        orderBeautician.setStoreId(storeId);
                        orderBeautician.setOrderId(id);
                        int addBeautician=this.orderBeauticianMapper.insertSelective(orderBeautician);
                        log.info("添加订单美容师信息："+res);
                        if(addBeautician<=0){
                            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"添加订单美容师失败");
                        }
                    }
                    //添加订单基础信息，订单美容师以及订单商品信息，返回订单ID和编号
                    HashMap<String,Object> map=new HashMap<>(16);
                    map.put("orderId",id);
                    map.put("orderNo",orderNo);
                    responseMessage.setData(map);
                }
            }
        }else{
            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage verificationByCode(Integer isStoreOwner, String mobile, Integer storeId, Integer beauticianId, String orderNo, String verificationCode) {
        ResponseMessage responseMessage = new ResponseMessage();
        ResponseMessage sbm = storeBeauticianFeign.findByPhoneForStore(mobile);
        log.info("查询店铺美容师信息："+sbm.toString());
        if (HttpStatusConstant.OK.getStatus() == sbm.getCode()) {
            log.info("查询成功");
            StoreBeauticianByPhoneResultVo sbvo = (StoreBeauticianByPhoneResultVo) sbm.getData();
            StoreBeautician sb = sbvo.getStoreBeautician();
            //判断是否为员工而且在职
            Integer stoId = sb.getMemberId();
            log.info("美容师的会员ID："+stoId);
            Integer beauId = sb.getId();
            //员工类型
            Integer beauticianType = sb.getBeauticianType();
            //是否在职
            Integer beauticianStatus = sb.getBeauticianStatus();
            //是否审核通过
            Integer auditStatus=sb.getRealNameStatus();

            OrderProduct orderProduct1 = orderProductMapper.queryByOrderNo(orderNo);
            Product product = orderBaseVerify.getProduct(orderProduct1.getStoreId(), orderProduct1.getProductId());
            if (product != null) {
                int productType=product.getProductType();
                log.info("项目类型："+productType);
                ResponseMessage resMsg=new ResponseMessage();
                OrderBeautician orderBeautician=orderBeauticianMapper.queryByOrderNo(orderNo);
                Optional.ofNullable(orderBeautician).filter(x->x!=null).orElseThrow(()->new ServerException(HttpStatusConstant.ERROR.getStatus(),"查询订单美容师异常"));
                //门店自营
                if(productType==Product.ProductType.STORE_SELF||productType==Product.ProductType.BRAND){
                    resMsg=isStoreSellOrder(isStoreOwner,stoId,beauticianType,beauticianStatus,auditStatus,orderNo,orderBeautician.getBeauticianId(),beauId,orderBeautician.getStoreSellerMemberId());
                }//平台自营
                 else if(productType==Product.ProductType.PLATFORM_SELF){
                    boolean isTrue=isStoreOwner==1;
                    resMsg=isPlatformOrder(isTrue,orderBeautician.getBeauticianId(),beauticianId);
                }
                if(resMsg.getCode()!=HttpStatusConstant.OK.getStatus()){
                    responseMessage.setCode(resMsg.getCode());
                    responseMessage.setMessage(resMsg.getMessage());
                    return responseMessage;
                }
                responseMessage = this.verification(orderNo, verificationCode, product.getServerNeedTime());
                if(HttpStatusConstant.OK.getStatus()==responseMessage.getCode()){
                    //消耗库存
                    consumeGoodsRecord(orderBeautician.getBeauticianId(),product.getId());
                }
            } else {
                return HystrixResponse.invokeFail();
            }
        } else {
            responseMessage.setCode(com.union.aimei.common.constant.order.OrderConstant.RemoteInvoke.INVOKE_STOREBEAUTICIAN_FAIL);
            responseMessage.setMessage(com.union.aimei.common.constant.order.OrderConstant.RemoteInvoke.INVOKE_STOREBEAUTICIAN_FAIL_MESSAGE);
        }
        return responseMessage;
    }

    public void consumeGoodsRecord(int beauticianId,int productId){
        ResponseMessage<OrderProductConsumeGoodsRecord> phyMsg=orderProductConsumeGoodsRecordFeign.queryByProductId(productId);
        if(HttpStatusConstant.OK.getStatus()==phyMsg.getCode()){
            OrderProductConsumeGoodsRecord ref=phyMsg.getData();
            ProductPhysicalByInventoryVo vo=new ProductPhysicalByInventoryVo();
            vo.setBeauticianId(beauticianId);
            vo.setPhysicalNumber(ref.getConsumeNum());
            vo.setProductPhysicalId(ref.getProductPhysicalId());
            ResponseMessage resMsg=productFeign.inventoryConsumptionV111(vo);
            AssertUtil.isRemoteInvokeSuccess(resMsg);
        }else{
            log.info("查询该项目实物产品为空");
        }
    }



    /**
     * 平台订单验证
     * @param beauticianId 美容师ID
     * @param beauId 订单美容师
     * @return
     */
    private ResponseMessage isPlatformOrder(boolean isStoreSeller,int beauticianId,int beauId){
        ResponseMessage res=new ResponseMessage();
        //判端美容师ID是否与平台订单一致
        boolean isTrue=beauticianId==beauId;
        String msg=isStoreSeller?"验证失败,不是该订单美容师":"店长无法验证上门服务";
        if(!isTrue){
            res.setCode(HttpStatusConstant.ERROR.getStatus());
            res.setMessage(msg);
        }
        return res;
    }

    /**
     * 门店自营项目验证
     * @param isStoreOwner 是否店长0:店长，1：美容师
     * @param stoId 店铺ID
     * @param beauticianType 美容师类型
     * @param beauticianStatus 美容师状态
     * @param auditStatus  审核状态
     * @param orderNo 订单编号
     * @param beauticianId 美容师ID
     * @param beauId 订单美容师ID
     * @return
     */
    private ResponseMessage isStoreSellOrder(Integer isStoreOwner,Integer stoId,
                                             int beauticianType,int beauticianStatus,int auditStatus,String orderNo,
    Integer beauticianId,int beauId,Integer storeSellerMemberId){
        ResponseMessage responseMessage=new ResponseMessage();
        log.info("是否店长"+isStoreOwner);
        log.info("店长会员ID"+stoId);
        log.info("美容师类型"+beauticianType);
        log.info("美容师状态"+beauticianStatus);
        log.info("审核状态"+auditStatus);
        log.info("传递的美容师ID"+beauticianId);
        log.info("订单美容师ID"+beauId);
        if (isStoreOwner == 0) {
            //美容师类型为1（店长）&&审核状态为通过
            boolean isOwner =1 == beauticianType && 2==auditStatus;
            log.info("店长类型确认"+isStoreOwner);
            if (!isOwner) {
                responseMessage.setCode(com.union.aimei.common.constant.order.OrderConstant.Base.IS_NOT_STORE_OWNER);
                responseMessage.setMessage(com.union.aimei.common.constant.order.OrderConstant.Base.IS_NOT_STORE_OWNER_MSG);
                return responseMessage;
            }
            boolean isOrderOwner=stoId.equals(storeSellerMemberId);
            log.info("是否该店店长"+isOrderOwner);
            if(!isOrderOwner){
                responseMessage.setCode(com.union.aimei.common.constant.order.OrderConstant.Base.IS_NOT_ORDER_OSTORE_OWNER);
                responseMessage.setMessage(com.union.aimei.common.constant.order.OrderConstant.Base.IS_NOT_ORDER_OSTORE_OWNER_MSG);
                return responseMessage;
            }
        } else if (isStoreOwner == 1) {
            //美容师ID等于订单美容师ID，美容师类型为全职或者兼职，美容师为在职并且审核状态为通过
            boolean isBeautician = beauticianId == beauId && (2 == beauticianType || 3 == beauticianType)&&2==auditStatus;
            log.info("是否为订单美容师"+isBeautician);
            if (!isBeautician) {
                responseMessage.setCode(com.union.aimei.common.constant.order.OrderConstant.Base.IS_NOT_ORDER_BEAUTICIN);
                responseMessage.setMessage(com.union.aimei.common.constant.order.OrderConstant.Base.IS_NOT_ORDER_BEAUTICIN_MSG);
                return responseMessage;
            }

        } else {
            responseMessage.setCode(com.union.aimei.common.constant.order.OrderConstant.Check.TYPE_LOST);
            responseMessage.setMessage(com.union.aimei.common.constant.order.OrderConstant.Check.TYPE_LOST_MSG);
            return responseMessage;
        }
        return responseMessage;
    }

    private  Date getActualServerEndTime(Date date,Integer serverNeedTime)throws ParseException {
        Long startTime= DateUtil.dateToLong(date);
        Long needTime=60*serverNeedTime*1000L;
        Date finalDate=DateUtil.longToDate(startTime+needTime,"yyyy-MM-dd HH:mm:ss");
        return finalDate;
    }

    public ResponseMessage verification(String orderNo,String verificationCode,int serverNeedTime){
        ResponseMessage responseMessage=new ResponseMessage();
        OrderBase order=orderBaseMapper.getByOrderNo(orderNo);
        boolean isTrue=order==null;
        if(isTrue){
            responseMessage.setCode(OrderConstant.Query.EMPTY);
            responseMessage.setMessage(OrderConstant.Query.EMPTY_MSG);
            return responseMessage;
        }
        Integer status=order.getStatus();
        Integer returnStatus=order.getReturnStatus();
        if (status.equals(OrderConstant.Status.PENDING_PAYMENT) ||
                status.equals(OrderConstant.Status.TRANSACTION_CLOSED) ||
                returnStatus.equals(OrderConstant.Return.REFUNDING) ||
                returnStatus.equals(OrderConstant.Return.REFUND_COMPLETED)) {
            responseMessage.setCode(OrderConstant.Query.CAN_NOT_VERIFY);
            responseMessage.setMessage(OrderConstant.Query.CAN_NOT_VERIFY_MSG);
            return responseMessage;
        } else if (order.getStatus().equals(OrderConstant.Status.PENDING_SERVICE)) {
            if (!order.getVerificationCode().equals(verificationCode)) {
                responseMessage.setCode(OrderConstant.Query.VERIFY_CODE_ERROR);
                responseMessage.setMessage(OrderConstant.Query.VERIFY_CODE_ERROR_MSG);
                return responseMessage;
            }else {
                log.info("验证成功，修改订单");
                //验证成功修改订单状态为服务中
                order.setStatus(OrderConstant.Status.IN_SERVICE);
                Date startDate = new Date();
                //添加服务实际开始时间
                order.setActualStartTime(startDate);
                try {
                    //添加服务实际结束时间
                    order.setActualEndTime(getActualServerEndTime(startDate, serverNeedTime));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                log.info("执行修改订单信息");
                orderBaseMapper.updateByPrimaryKeySelective(order);
            }
        } else {
            responseMessage.setCode(OrderConstant.Query.REPEAT_VERIFY_CODE_ERROR);
            responseMessage.setMessage(OrderConstant.Query.REPEAT_VERIFY_CODE_ERROR_MSG);
        }
        return  responseMessage;
    }

    /**
     *  申请退款
     * @param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @TxTransaction(isStart = true,rollbackFor = Exception.class)
    public ResponseMessage refund(String orderNo,String reason,String remark) {
        ResponseMessage res = ResponseMessageFactory.newInstance();
        OrderBase orderBase = orderBaseMapper.getByOrderNo(orderNo);
        if (orderBase != null) {
            UpdateRefundApplyVo applyVo = new UpdateRefundApplyVo();
            applyVo.setOrderNo(orderNo);
            applyVo.setReason(reason);
            applyVo.setRemark(remark);
            OrderRefundsConsultRecord record = new OrderRefundsConsultRecord();
            Member member = memberFeign.queryById(orderBase.getMemberId());
            if (member != null) {
                record.setApplyMemberId(member.getId());
                record.setApplyMemberHeadImg(member.getMemberImgUrl());
                record.setApplyMemberNickname(member.getMemberNickname());
                record.setApplyReason(reason);
                record.setApplyTime(new Date());
            }else{
               throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"查询会员异常");
            }
            record.setOperContent("买家申请退款");
            applyVo.setOrderRefundsConsultRecord(record);
            //查询是否已经存在退款记录
            OrderReturn orderReturn = orderReturnMapper.selectByOrderNo(orderNo);
            if (orderReturn!=null) {
                throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"请勿重复申请退款");
            } else {
                res=this.applyRefund(orderBase,applyVo);
            }
        } else {
            res.setCode(OrderConstant.Base.ORDER_ISNOT_EXSIT);
            res.setMessage(OrderConstant.Base.ORDER_ISNOT_EXSIT_MSG);
        }
        if(HttpStatusConstant.OK.getStatus()==res.getCode()){
            OrderSendAppVo vo=orderBaseMapper.queryById(orderBase.getId());
            if(vo!=null){
                //异步发送短信及推送APP消息
                customerApplyRefundTask.sendMsg(vo.getBeauticianPhone(),vo.getStoreSellerPhone(),vo.getOrderNo(),vo.getProductType(),null);
                customerApplyRefundTask.pushMsg(vo);
            }
        }
        return res;
    }


    /**
     *
     * @param updateRefundApplyVo
     * @return
     */
    public ResponseMessage applyRefund(OrderBase orderBase,UpdateRefundApplyVo updateRefundApplyVo){
        return getResponseMessage(orderBase, updateRefundApplyVo);
    }

    private ResponseMessage getResponseMessage(OrderBase order, UpdateRefundApplyVo updateRefundApplyVo) {
        ResponseMessage responseMessage=check(order);
        //订单状态设置为退款中
        //订单退款状态设置为退款
        order.setReturnStatus(OrderConstant.Return.REFUNDING);
        order.setReturnTime(new Date());
        orderBaseMapper.updateByPrimaryKeySelective(order);
        Integer orReturnId;
        String str;
        //新增一条订单退款记录
        OrderReturn orderReturn = new OrderReturn();
        orderReturn.setStoreId(order.getStoreId());
        orderReturn.setOrderId(order.getId());
        orderReturn.setOrderNo(order.getOrderNo());
        orderReturn.setRefundOrderNo(CreateOrderNo.getInstance().GenerateOrder());
        orderReturn.setMemberId(order.getMemberId());
        orderReturn.setMemberName(order.getMemberRealName());
        orderReturn.setReturnType((byte)2);
        orderReturn.setReason(updateRefundApplyVo.getReason());
        orderReturn.setFee(order.getAmountPay());
        orderReturn.setApplyTime(new Date());
        orderReturn.setRemark(updateRefundApplyVo.getRemark());
        orderReturnMapper.insertSelective(orderReturn);
        orReturnId=orderReturn.getId();
        str="买家申请退款";
        //新增一条协商记录表
        OrderRefundsConsultRecord record=updateRefundApplyVo.getOrderRefundsConsultRecord();
        OrderReturn orReturn=orderReturnMapper.selectByPrimaryKey(orReturnId);
        record.setOperContent(str);
        record.setOrderReturnId(orReturn.getId());
        orderRefundsConsultRecordMapper.insertSelective(record);
        return responseMessage;
    }

    private ResponseMessage check(OrderBase order){
        ResponseMessage responseMessage=new ResponseMessage();
        if(order==null){
            responseMessage.setCode(OrderConstant.Query.EMPTY);
            responseMessage.setMessage(OrderConstant.Query.EMPTY_MSG);
            return responseMessage;
        }
        Integer status=order.getStatus();
        //未付款请求下不允许退款
        boolean isPay=OrderConstant.Status.PENDING_PAYMENT.equals(status);
        if(isPay){
            responseMessage.setCode(OrderConstant.Query.IS_NOT_PAY);
            responseMessage.setMessage(OrderConstant.Query.IS_NOT_PAY_MSG);
            return responseMessage;
        }
        //如果订单在服务中，待评价以及评价完成状态下，说明已经消费，不支持退款
        boolean isConsume=OrderConstant.Status.IN_SERVICE.equals(status)||
                OrderConstant.Status.IN_SERVICE.equals(status)||
                OrderConstant.Status.PENDING_EVALUATION.equals(status);
        if (isConsume) {
            responseMessage.setCode(OrderConstant.Query.IS_SEVICE);
            responseMessage.setMessage(OrderConstant.Query.IS_SEVICE_MSG);
            return responseMessage;
        }
        Integer returnStatus=order.getReturnStatus();
        //正在退款中不允许重复退款
        boolean isRefunding=returnStatus.equals(OrderConstant.Return.REFUNDING);
        if(isRefunding){
            responseMessage.setCode(OrderConstant.Query.REPEAT_REFUND_ORDER);
            responseMessage.setMessage(OrderConstant.Query.REPEAT_REFUND_ORDER_MSG);
            return responseMessage;
        }
        //已退款不允许再次申请
        boolean hasRefund=returnStatus.equals(OrderConstant.Return.REFUND_COMPLETED);
        if(hasRefund){
            responseMessage.setCode(OrderConstant.Query.HAS_REFUENED);
            responseMessage.setMessage(OrderConstant.Query.HAS_REFUENED_MSG);
            return responseMessage;
        }
        return responseMessage;
    }


    @Override
    @TxTransaction(isStart = true,rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage updateRefundApplication(String orderNo,String reason,String remark) {
        ResponseMessage res = ResponseMessageFactory.newInstance();
        OrderBase orderBase = orderBaseMapper.getByOrderNo(orderNo);
        if (orderBase != null) {
            UpdateRefundApplyVo applyVo = new UpdateRefundApplyVo();
            applyVo.setOrderNo(orderNo);
            applyVo.setReason(reason);
            applyVo.setRemark(remark);
            OrderRefundsConsultRecord record = new OrderRefundsConsultRecord();
            Member member = memberFeign.queryById(orderBase.getMemberId());
            if (member != null) {
                record.setApplyMemberId(member.getId());
                record.setApplyMemberHeadImg(member.getMemberImgUrl());
                record.setApplyMemberNickname(member.getMemberNickname());
                record.setApplyReason(reason);
            }
            record.setOperContent("买家修改退款申请");
            applyVo.setOrderRefundsConsultRecord(record);
            ResponseMessage uptMsg=this.modifyApplyRefund(applyVo);
            if(HttpStatusConstant.OK.getStatus()!=uptMsg.getCode()){
                res.setCode(uptMsg.getCode());
                res.setMessage(uptMsg.getMessage());
            }
        } else {
            res.setCode(com.union.aimei.common.constant.order.OrderConstant.Base.ORDER_ISNOT_EXSIT);
            res.setMessage(com.union.aimei.common.constant.order.OrderConstant.Base.ORDER_ISNOT_EXSIT_MSG);
        }
        return res;
    }



    public ResponseMessage modifyApplyRefund(UpdateRefundApplyVo updateRefundApplyVo){
        ResponseMessage res=ResponseMessageFactory.newInstance();
        OrderBase order=orderBaseMapper.getByOrderNo(updateRefundApplyVo.getOrderNo());
        if(order==null){
            res.setCode(OrderConstant.Query.EMPTY);
            res.setMessage(OrderConstant.Query.EMPTY_MSG);
        }else{
            //判断是否在退款状态
            Integer status=order.getStatus();
            Integer runStatus=order.getReturnStatus();
            boolean isInRefund=status==2&&(runStatus==1||runStatus==3);
            if(isInRefund){
                //修改退款记录
                OrderReturn orderReturn = orderReturnMapper.selectByOrderNo(updateRefundApplyVo.getOrderNo());
                if(orderReturn!=null){
                    Integer updateCount=orderReturn.getUpdateCount();
                    //超过4次则不允许再次修改
                    if(updateCount<OrderNumericalConstant.MAX_REFUND_COUNT.getValue()){
                        int count=updateCount+1;
                        orderReturn.setUpdateCount(count);
                        orderReturn.setReason(updateRefundApplyVo.getReason());
                        orderReturn.setRemark(updateRefundApplyVo.getRemark()==null?"":updateRefundApplyVo.getRemark());
                        Byte returnStatus=1;
                        orderReturn.setReturnStatus(returnStatus);
                        orderReturnMapper.updateByPrimaryKeySelective(orderReturn);
                        OrderRefundsConsultRecord record=updateRefundApplyVo.getOrderRefundsConsultRecord();
                        record.setOrderReturnId(orderReturn.getId());
                        //修改订单记录表中退款状态为退款中
                        order.setReturnStatus(1);
                        orderBaseMapper.updateByPrimaryKeySelective(order);
                        //添加协商记录
                        orderRefundsConsultRecordMapper.insertSelective(record);
                        //推送消息
                        if(HttpStatusConstant.OK.getStatus()==res.getCode()){
                            OrderSendAppVo vo=orderBaseMapper.queryById(order.getId());
                            if(vo!=null){
                                //异步发送短信及推送APP消息
                                customerApplyRefundTask.sendMsg(vo.getBeauticianPhone(),vo.getStoreSellerPhone(),vo.getOrderNo(),vo.getProductType(),null);
                                customerApplyRefundTask.pushMsg(vo);
                            }
                        }
                    }else{
                        res.setCode(OrderConstant.BEYOND_UPDATE_COUNT);
                        res.setMessage(OrderConstant.BEYOND_UPDATE_COUNT_MSG);

                    }
                }else{
                    res.setCode(OrderConstant.Query.IS_NOT_IN_REFUND);
                    res.setMessage(OrderConstant.Query.IS_NOT_IN_REFUND_MSG);
                }
            }else{
                res.setCode(OrderConstant.Query.IS_NOT_IN_REFUND);
                res.setMessage(OrderConstant.Query.IS_NOT_IN_REFUND_MSG);
            }
        }
        return res;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage cancelRefundApply(Integer orderId) {
        ResponseMessage res=this.cancelApplyRefund(orderId);
        if(HttpStatusConstant.OK.getStatus()==res.getCode()){
            OrderSendAppVo vo=orderBaseMapper.queryById(orderId);
            log.info("发送对象："+vo.toString());
            if(vo!=null){
                customerCancelRefundTask.sendMsg(vo.getBeauticianPhone(),vo.getStoreSellerPhone(),vo.getOrderNo(),vo.getProductType(),null);
                customerCancelRefundTask.pushMsg(vo);
            }
        }
        return res;
    }

    public ResponseMessage cancelApplyRefund(Integer orderId){
        ResponseMessage responseMessage=new ResponseMessage();
        OrderBase order=orderBaseMapper.selectByPrimaryKey(orderId);
        if(order==null){
            responseMessage.setCode(OrderConstant.QUERY_ORDER_IS_NOT_EXSIT);
            responseMessage.setMessage(OrderConstant.QUERY_ORDER_IS_NOT_EXSIT_MSG);
            return responseMessage;
        }else{
            //判断是否在退款状态
            Integer rurStatus=order.getReturnStatus();
            Integer status=order.getStatus();
            boolean isInRefund=status==2&&(rurStatus==1||rurStatus==3);
            if(isInRefund){
                //更改订单状态
                order.setReturnStatus(0);
                order.setReturnTime(null);
                orderBaseMapper.updateByPrimaryKeySelective(order);
                OrderReturn  orderReturn=orderReturnMapper.selectByOrderNo(order.getOrderNo());
                //更改订单退款记录为无效
                orderReturn.setIsEnabled(false);
                orderReturnMapper.updateByPrimaryKeySelective(orderReturn);
                //添加撤销退款协商记录
                OrderRefundsConsultRecord record=new OrderRefundsConsultRecord();
                record.setOrderReturnId(orderReturn.getId());
                record.setApplyTime(orderReturn.getApplyTime());
                record.setAddTime(new Date());
                record.setApplyMemberId(order.getMemberId());
                record.setApplyMemberNickname(order.getMemberNickName());
                record.setApplyRemark("用户已撤销退款");
                orderRefundsConsultRecordMapper.insertSelective(record);
            }else{
                responseMessage.setCode(OrderConstant.Query.IS_NOT_IN_REFUND);
                responseMessage.setMessage(OrderConstant.Query.IS_NOT_IN_REFUND_MSG);
            }
        }
        return responseMessage;
    }

    /**
     * 审核退款
     * @param auditRefundVo
     * @return
     */
    @Override
    @TxTransaction(isStart = true,rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage auditRefundApply(AuditRefundVo auditRefundVo) {
       //判断美容师身份，只有店长及订单美容师允许操作退款
       ResponseMessage res = new ResponseMessage();
        Integer beauticianId = auditRefundVo.getBeauticianId();
        //已通过审核的不允许重复审核
       OrderReturn orderReturn=orderReturnMapper.selectByOrderNo(auditRefundVo.getOrderNo());
        if(orderReturn==null){
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return res;
        }
        Byte returnType=orderReturn.getReturnType();
        Byte returnStatus=orderReturn.getReturnStatus();
        //判断是否为退款，并且已经退款不允许重复审核
        boolean noAudit=returnType==2&&(returnStatus==2);
        if(noAudit){
            res.setCode(com.union.aimei.common.constant.order.OrderConstant.Check.REPEAT_AUDIT);
            res.setMessage(com.union.aimei.common.constant.order.OrderConstant.Check.REPEAT_AUDIT_MSG);
            return res;
        }
        ResponseMessage<SubmitOrder> resMsg = this.queryOrderAllInfoByOrderNo(auditRefundVo.getOrderNo());
        if (HttpStatusConstant.OK.getStatus() == resMsg.getCode()) {
            SubmitOrder submitOrder = resMsg.getData();
            OrderBeautician orderBeautician = submitOrder.getOrderBeautician();
            OrderBase orderBase = submitOrder.getOrderBase();
            OrderProduct orderProduct=submitOrder.getOrderProduct();
            Integer orderBeauticianId = orderBeautician.getBeauticianId();
            Integer storeOwnerMemberId=null;
            boolean isBeautician=false;
            boolean isStoreOwner=false;
            if(beauticianId!=null){
                //判断美容师ID是否跟订单美容师ID一致
                isBeautician=beauticianId.equals(orderBeauticianId);
            }else{
                if(auditRefundVo.getStoreOwnerBeauticianId()!=null){
                    ResponseMessage<StoreBeautician> storeOwnMsg=storeBeauticianFeign.findById(auditRefundVo.getStoreOwnerBeauticianId());
                    AssertUtil.isRemoteInvokeSuccess(storeOwnMsg);
                    StoreBeautician storeBeautician=storeOwnMsg.getData();
                    storeOwnerMemberId=storeBeautician.getMemberId();
                }else {
                    throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"店长的美容师ID不能为");
                }
                //判断店长的会员ID是否与订单的店长会员一致
                Integer orderStoreMemberId=orderBeautician.getStoreSellerMemberId();
                isStoreOwner=storeOwnerMemberId.equals(orderStoreMemberId);
            }
            boolean isTrue = isBeautician||isStoreOwner;
            if (isTrue) {
                boolean isAgree = auditRefundVo.isAgree();
                OrderSendAppVo orderSendAppVo=orderBaseMapper.queryById(orderBase.getId());
                if (isAgree) {
                    ResponseMessage msg=agreeRefund(orderBase, orderBeautician,orderProduct);
                    if(msg.getCode()!=HttpStatusConstant.OK.getStatus()){
                        res.setCode(msg.getCode());
                        res.setMessage(msg.getMessage());
                        return res;
                    }
                    agreeRefundTask.sendMsg(orderSendAppVo.getMemberPhone(),orderSendAppVo.getProductName(),15);
                    agreeRefundTask.pushAppInfo(orderSendAppVo);
                } else {
                    refuseRefund(orderBase, auditRefundVo.getBeauticianId()==null?auditRefundVo.getStoreOwnerBeauticianId():auditRefundVo.getBeauticianId(), auditRefundVo.getRefuseReason(), auditRefundVo.getRefuseVoucher());
                    refuseRefundTask.sendMsg(orderSendAppVo.getMemberPhone(),orderSendAppVo.getProductName());
                    refuseRefundTask.pushtoApp(orderSendAppVo);
                }
            }else{
                throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"没有资格审核");
            }
        } else {
            res.setCode(com.union.aimei.common.constant.order.OrderConstant.RemoteInvoke.INVOKE_FAIL);
            res.setMessage(com.union.aimei.common.constant.order.OrderConstant.RemoteInvoke.INVOKE_FAIL_MESSAGE);
        }
        return res;
    }

    private ResponseMessage agreeRefund(OrderBase orderBase, OrderBeautician orderBeautician,OrderProduct orderProduct) {
        ResponseMessage res=new ResponseMessage();
        //更改订单的退款状态为已完成,更改订单退款记录表为审核通过
        this.operationRefund(true, orderBase.getId());
        //添加交易流水记录
        addTradeRecord(orderBase,orderBeautician,orderProduct);
        //添加协商记录
        OrderRefundsConsultRecord record = new OrderRefundsConsultRecord();
        Member member = memberFeign.queryById(orderBase.getMemberId());
        if (member != null) {
            record.setApplyMemberId(member.getId());
            record.setApplyMemberHeadImg(member.getMemberImgUrl());
            record.setApplyMemberNickname(member.getMemberNickname());
        }
        OrderReturn orderReturn = orderReturnMapper.selectByOrderNo(orderBase.getOrderNo());
        log.info("订单退款信息："+orderReturn.toString());
        if (orderReturn!=null) {
            record.setOrderReturnId(orderReturn.getId());
            record.setApplyReason(orderReturn.getReason());
            record.setApplyRemark(orderReturn.getRemark());
        }
        String content="卖家同意退款，退款成功";
        record.setOperContent(content);
        Byte type=1;
        record.setOperType(type);
        orderRefundsConsultRecordMapper.insertSelective(record);
        log.info("开始执行原路退款业务逻辑"+orderBase.getOrderNo());
        //释放订单库存
        log.info("开始释放订单库存");
        releaseInventor(orderBeautician.getBeauticianId(),orderProduct.getProductId(),orderBase.getId());
        //原路退款
        String payType=orderBase.getPayType();
        if(PayTypeEnum.ALI_PAY.getName().equals(payType)){
            log.info("开始执行支付宝退款业务逻辑");
            ResponseMessage<AlipayTradeRefundResponse> aliRefundMsg=payReFundFeign.tradeRefund(orderBase.getOrderNo());
            if(aliRefundMsg.getCode()!=HttpStatusConstant.OK.getStatus()){
                res.setCode(aliRefundMsg.getCode());
                res.setMessage(aliRefundMsg.getMessage());
            }
        }else if(PayTypeEnum.WX_PAY.getName().equals(payType)){
            log.info("开始执行微信退款业务逻辑");
            ResponseMessage<WxPayRefundResult> wxRefundMsg=payReFundFeign.refund(0,orderBase.getOrderNo());
            if(wxRefundMsg.getCode()!=HttpStatusConstant.OK.getStatus()){
                res.setCode(wxRefundMsg.getCode());
                res.setMessage(wxRefundMsg.getMessage());
            }
        }else if(PayTypeEnum.BALANCE_PAY.getName().equals(payType)){
            log.info("开始执行余额退款业务逻辑");
            RefundParamVo paramVo=getRefundParamVo(0,orderReturn.getRefundOrderNo(),orderReturn.getReason(),orderBase);
            if(paramVo==null){
                throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"退款失败");
            }
            ResponseMessage balanMsg=payReFundFeign.refund(paramVo);
            if(balanMsg.getCode()!=HttpStatusConstant.OK.getStatus()){
                res.setCode(balanMsg.getCode());
                res.setMessage(balanMsg.getMessage());
            }
        }else if(PayTypeEnum.ONE_CARD_PAY.getName().equals(payType)){
            log.info("开始执行一卡通退款业务逻辑");
            RefundParamVo paramVo=getRefundParamVo(1,orderReturn.getRefundOrderNo(),orderReturn.getReason(),orderBase);
            if(paramVo==null){
                throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"退款失败");
            }
            ResponseMessage oneCardMsg= payReFundFeign.refund(paramVo);
            if(oneCardMsg.getCode()!=HttpStatusConstant.OK.getStatus()){
                res.setCode(oneCardMsg.getCode());
                res.setMessage(oneCardMsg.getMessage());
            }
        }
        return res;

    }

    /**
     *  释放项目库存
     * @param beauticianId
     * @param productId
     */
    private void releaseInventor(int beauticianId,int productId,int orderId){
        ProductPhysicalByInventoryVo vo=new ProductPhysicalByInventoryVo();
        OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord=new OrderProductConsumeGoodsRecord();
        orderProductConsumeGoodsRecord.setOrderId(orderId);
        List<OrderProductConsumeGoodsRecord> list=orderProductConsumeGoodsRecordMapper.selectListByConditions(orderProductConsumeGoodsRecord);
        if(!CollectionUtils.isEmpty(list)){
            OrderProductConsumeGoodsRecord record=list.get(0);
            int  goodsId=record.getProductPhysicalId();
            vo.setProductPhysicalId(goodsId);
            vo.setBeauticianId(beauticianId);
            vo.setPhysicalNumber(1);
            ResponseMessage res=productFeign.inventoryCancelOrderReservationV111(vo);
            log.info("返回数据："+res);
        }

    }

    private void addTradeRecord(OrderBase orderBase, OrderBeautician orderBeautician,OrderProduct orderProduct){
        ResponseMessage<BeauticianTradeDetail> res=beauticianTradeDetailFeign.queryByOrderNoAndType(orderBase.getOrderNo(),1);
        AssertUtil.isRemoteInvokeSuccess(res);
        BeauticianTradeDetail beauticianTradeDetail=res.getData();
        Integer beauticianCom=beauticianTradeDetail.getIncome();
        Integer platForm=beauticianTradeDetail.getPlatformAmount();
        Integer storeCom=beauticianTradeDetail.getStoreAmoun();
        if(orderBase.getStoreId()!=null){
            //添加店铺交易流水记录
            StoreTradeDetail storeTradeDetail = new StoreTradeDetail();
            storeTradeDetail.setStoreId(orderBase.getStoreId());
            storeTradeDetail.setBeauticianId(orderBeautician.getBeauticianId());
            storeTradeDetail.setStoreName(orderBase.getStoreName());
            storeTradeDetail.setBeauticianName(orderBeautician.getBeauticianName());
            storeTradeDetail.setOrderNo(orderBase.getOrderNo());
            storeTradeDetail.setTradeType(3);
            storeTradeDetail.setNetAmount((-1)*storeCom);
            storeTradeDetail.setPayTime(orderBase.getPayTime());
            storeTradeDetail.setTradeStatus(1);
            storeTradeDetail.setStorePhone(orderBeautician.getStoreSellerPhone());
            storeTradeDetail.setProductName(orderProduct.getProductName());
            storeTradeDetail.setTotalAmount(orderBase.getAmountTotal());
            storeTradeDetail.setActualPay(orderBase.getAmountPay());
            storeTradeDetail.setPayMethod(changePayTypeToInt(orderBase.getPayType()));
            storeTradeDetail.setReimburseAmount(orderBase.getAmountPay());
            storeTradeDetail.setReimburseTime(orderBase.getReturnTime());
            storeTradeDetailFeign.insertSelectiveV110(storeTradeDetail);
        }
        //添加美容师交易流水
        BeauticianTradeDetail beauDetail=new BeauticianTradeDetail();
        beauDetail.setStoreId(orderBase.getStoreId()==null?orderBase.getAnchoredStoreId():orderBase.getStoreId());
        beauDetail.setBeauticianId(orderBeautician.getBeauticianId());
        beauDetail.setStoreName(orderBase.getStoreName());
        beauDetail.setBeauticianName(orderBeautician.getBeauticianName());
        beauDetail.setProductNumber(orderProduct.getNums());
        beauDetail.setProductPrice(orderProduct.getProductPrice());
        beauDetail.setOrderNo(orderBase.getOrderNo());
        beauDetail.setTradeType(3);
        beauDetail.setReimburseTime(orderBase.getReturnTime());
        beauDetail.setIncome((-1)*beauticianCom);
        beauDetail.setNetIncome((-1)*beauticianTradeDetail.getNetIncome());
        beauDetail.setBeauticianType(orderBeautician.getType().intValue()==2?1:(orderBeautician.getType().intValue()==3?0:1));
        beauDetail.setPayTime(orderBase.getPayTime());
        beauDetail.setProductName(orderProduct.getProductName());
        beauDetail.setTradeStatus(0);
        beauDetail.setReimburseAmount(orderBase.getAmountPay());
        Integer freight=orderBase.getFreight();
        beauDetail.setVisitAmount(freight);
        log.info("支付方式为:"+orderBase.getPayType());
        if(orderBase.getPayType()!=null){
            beauDetail.setPayMethod(changePayTypeToInt(orderBase.getPayType()));
        }
        beauticianTradeDetailFeign.insertSelectiveV110(beauDetail);
        //添加平台流水
        PlatformTradeDetail platDetail=new PlatformTradeDetail();
        platDetail.setOrderNumber(orderBase.getOrderNo());
        platDetail.setTransactionSerialNumber(orderBase.getTradeNo());
        platDetail.setPayTime(orderBase.getPayTime());
        platDetail.setTradeType(4);
        platDetail.setTradeStatus(orderBase.getStatus());
        platDetail.setOrderAmount(orderBase.getAmountTotal());
        platDetail.setActuallyAmount(orderBase.getAmountPay());
        platDetail.setPlatformCommission((-1)*platForm);
        if(orderBase.getPayType()!=null){
            platDetail.setPayMethod(changePayTypeToInt(orderBase.getPayType()));
        }
        platDetail.setStoreId(orderBase.getStoreId());
        platDetail.setStoreName(orderBase.getStoreName());
        platDetail.setBeauticianPhone(orderBeautician.getMobile());
        platDetail.setBeauticianId(orderBeautician.getBeauticianId());
        platDetail.setBeauticianName(orderBeautician.getBeauticianName());
        platDetail.setBuyersNickname(orderBase.getMemberRealName());
        platDetail.setBuyersPhone(orderBase.getMemberPhone());
        platDetail.setServiceName(orderProduct.getProductName());
        platDetail.setUnitPrice(orderProduct.getProductPrice());
        platDetail.setCoupons(orderBase.getCouponReduce());
        platDetail.setMembershipCardDiscount(orderBase.getMemberCardReduce());
        platDetail.setTotalPrice(orderBase.getAmountTotal());
        platformTradeDetailFeign.insertSelectiveV110(platDetail);
    }



    private RefundParamVo getRefundParamVo(int type,String refundNo,String reason,OrderBase orderBase){
        RefundParamVo paramVo=new RefundParamVo();
        Member member=memberFeign.queryById(orderBase.getMemberId());
        if(member==null){
            return null;
        }
        paramVo.setUuid(member.getAmezUuid());
        paramVo.setOrderNo(orderBase.getOrderNo());
        paramVo.setRefundNo(refundNo);
        BigDecimal refundFee=new BigDecimal((double)orderBase.getAmountPay()/100);
        paramVo.setRefundFee(refundFee.setScale(2,BigDecimal.ROUND_FLOOR));
        paramVo.setRefundReason(reason);
        paramVo.setAppSystem(HttpStatusConstant.OK.getStatus());
        paramVo.setMemberId(member.getAmezUserId().longValue());
        //余额
        if(type==0){
            paramVo.setRefundPayType(4);
        }else if(type==1){
          //一卡通
            paramVo.setRefundPayType(3);
            paramVo.setOneCardId(orderBase.getCardId().longValue());
        }
        return paramVo;
    }



    private void insertRefundRecord(OrderBase orderBase, Integer beauticianId, String refuseReason, String refuseVoucher,String content){
        //添加协商记录
        OrderRefundsConsultRecord record = new OrderRefundsConsultRecord();
        record.setRefuseRemark(refuseReason);
        record.setRefuseVoucher(refuseVoucher);
        Member member = memberFeign.queryById(orderBase.getMemberId());
        if (member != null) {
            record.setApplyMemberId(member.getId());
            record.setApplyMemberHeadImg(member.getMemberImgUrl());
            record.setApplyMemberNickname(member.getMemberNickname());
        }
       OrderReturn orderReturn = orderReturnMapper.selectByOrderNo(orderBase.getOrderNo());
        if (orderReturn!=null) {
            record.setOrderReturnId(orderReturn.getId());
            record.setApplyReason(orderReturn.getReason());
            record.setApplyRemark(orderReturn.getRemark());
        }
        ResponseMessage<StoreBeautician> beauticianRes = storeBeauticianFeign.findById(beauticianId);
        if (HttpStatusConstant.OK.getStatus() == beauticianRes.getCode()) {
            StoreBeautician beautician = beauticianRes.getData();
            record.setRefusePersonId(beautician.getId());
            record.setRefusePersonNickname(beautician.getBeauticianNickName());
            record.setRefusePersonHeadImg(beautician.getHeadImgUrl());
            record.setRefuseTime(new Date());
        }
        record.setOperContent(content);
        orderRefundsConsultRecordMapper.insertSelective(record);
    }

    private void refuseRefund(OrderBase orderBase, Integer beauticianId, String refuseReason, String refuseVoucher) {
        //更改订单退款状态为未退款完成，更改订单退款记录审核状态为未通过
        this.operationRefund(false, orderBase.getId());
        String content="卖家拒绝退款";
        insertRefundRecord(orderBase,beauticianId,refuseReason,refuseVoucher,content);
    }


    private Integer changePayTypeToInt(String payType) {
        if(StringUtils.isBlank(payType)){
            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"支付类型为空");
        }
        Integer payMethod = 0;
        switch (payType) {
            case "alipay":
                payMethod = 1
                ;
                break;
            case "wxpay":
                payMethod = 2
                ;
                break;
            case "cardpay":
                payMethod = 3
                ;
                break;
            case "oneCardPay":
                payMethod = 4;
                break;
            case "balancePay":
                payMethod = 5;
                break;
            default:
                payMethod = 1;
                break;
        }
        return payMethod;
    }

    /**
     * 根据订单编号查询订单信息
     * @param orderNo
     * @return
     */
    @Override
    public OrderBase queryByOrderNo(String orderNo) {
        return orderBaseMapper.getByOrderNo(orderNo);
    }

    /**
     * 根据订单编号更新订单支付方式
     * @param
     * @return
     */
    @Override
    @TxTransaction
    public ResponseMessage updateStateAfterPay(PayReturnVo vo) {
        log.info("请求参数：："+vo.toString());
        Map<String,Object> map=new HashMap<>(16);
        map.put("orderNo",vo.getOrderNo());
        map.put("payType",vo.getPayType());
        if(!StringUtils.isBlank(vo.getTradeNo())){
            map.put("tradeNo",vo.getTradeNo());
        }
        map.put("amountPay",vo.getAmountPay());
        map.put("oneCardDiscount",vo.getOneCardDiscount());
        map.put("oneCardReduce",vo.getReduceAmount());
        String verificationCode = RandomUtil.verificationCode();
        map.put("verificationCode",verificationCode);
        //一卡通支付则要累计优惠总金额
        OrderBase orderBase=orderBaseMapper.getByOrderNo(vo.getOrderNo());
        int orderAmountReduce=orderBase.getAmountReduce();
        int amountTotal=orderAmountReduce+vo.getReduceAmount();
        map.put("amountReduce",amountTotal);
        log.info("更改map："+map.toString());
        orderBaseMapper.updateStateAfterPay(map);
        return ResponseMessageFactory.newInstance();
    }




    /**
     * 根据订单ID查询订单详情，包括订单基础信息，订单美容师，订单商品信息以及订单评论信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage<HashMap<String,Object>> getOrderDetailsInfo(Integer id) {
        ResponseMessage responseMessage=new ResponseMessage();
        HashMap<String, Object> map=new HashMap<>(16);
        OrderBase orderBase=orderBaseMapper.selectByPrimaryKey(id);
        OrderBeautician orderBeautician=orderBeauticianMapper.queryByOrderId(id);
        OrderProduct orderProduct=orderProductMapper.queryByOrderId(id);
        if(orderBase!=null&&orderBeautician!=null&&orderProduct!=null){
            map.put("orderBase",orderBase);
            map.put("orderBeautician",orderBeautician);
            map.put("orderProduct",orderProduct);
            //查询是否存在订单评论信息(根据订单ID和订单评论类型)
            Map<String,Object> map1=new HashMap<>(2);
            map1.put("orderId",id);
            map1.put("operType",1);
            OrderComment comment=orderCommentMapper.queryByOrderIdAndOperType(map1);
            if(comment!=null){
                Date date= comment.getCreateTime();
                map.put("orderCommentTime",date);
            }
            responseMessage.setData(map);
        }else{
            responseMessage.setCode(ResponseContants.QUERY_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage queryMemberHasConsumer(Integer storeId,Integer memberId) {
        ResponseMessage res=ResponseMessageFactory.newInstance();
        Map<String,Object> map=new HashMap<>(16);
        map.put("storeId",storeId);
        map.put("memberId",memberId);
        Map<String,Object> result=orderBaseMapper.queryMemberHasConsumer(map);
        if(result==null){
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }else{
            res.setData(result);
        }
        return res;
    }

    @Override
    public ResponseMessage<SubmitOrder> queryOrderAllInfoByOrderNo(String orderNo) {
        ResponseMessage<SubmitOrder> res=new ResponseMessage<>();
        OrderBase orderBase=orderBaseMapper.getByOrderNo(orderNo);
        if(orderBase==null){
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }else{
            SubmitOrder submitOrder=new SubmitOrder();
            submitOrder.setOrderBase(orderBase);
            Integer orderId=orderBase.getId();
            OrderBeautician orderBeautician=orderBeauticianMapper.queryByOrderId(orderId);
            submitOrder.setOrderBeautician(orderBeautician);
            OrderProduct orderProduct=orderProductMapper.queryByOrderId(orderId);
            submitOrder.setOrderProduct(orderProduct);
            OrderProductConsumeGoodsRecord record=new OrderProductConsumeGoodsRecord();
            record.setOrderId(orderId);
            List<OrderProductConsumeGoodsRecord> list=orderProductConsumeGoodsRecordMapper.selectListByConditions(record);
            if(!CollectionUtils.isEmpty(list)){
                submitOrder.setConsumeGoodsRecordList(list);
            }
            res.setData(submitOrder);
        }
        return res;
    }


    /**
     * 操作退款
     * @param isAgree
     * @param orderId
     */
    public void operationRefund(boolean isAgree, Integer orderId) {
        OrderBase orderBase=orderBaseMapper.selectByPrimaryKey(orderId);
        if(orderBase!=null){
            OrderReturn orderReturn=orderReturnMapper.selectByOrderNo(orderBase.getOrderNo());
            Byte reStatus;
            if(isAgree){
                orderBase.setReturnStatus(2);
                orderBase.setReturnTime(new Date());
                reStatus=2;
                orderReturn.setReturnStatus(reStatus);
                orderReturn.setAuditTime(new Date());
                OrderBeautician orderBeautician=orderBeauticianMapper.queryByOrderId(orderId);
                orderBeautician.setIsEnabled(false);
                orderBeauticianMapper.updateByPrimaryKeySelective(orderBeautician);
            }else{
                orderBase.setReturnStatus(3);
                reStatus=3;
                orderReturn.setAuditTime(new Date());
                orderReturn.setReturnStatus(reStatus);
            }
            orderBaseMapper.updateByPrimaryKeySelective(orderBase);
            orderReturnMapper.updateByPrimaryKeySelective(orderReturn);
        }

    }

    @Override
    public ResponseMessage<RefundDetailsVo> queryRefundDetails(String orderNo) {
        ResponseMessage<RefundDetailsVo> res=new ResponseMessage<>();
        RefundDetailsVo vo=new RefundDetailsVo();
        OrderReturn orderReturn=orderReturnMapper.selectByOrderNo(orderNo);
        if(orderReturn!=null){
            Byte returnStatus=orderReturn.getReturnStatus();
            vo.setApplyTime(orderReturn.getApplyTime());
            vo.setReason(orderReturn.getReason());
            vo.setRemark(orderReturn.getRemark());
            vo.setReturnAmount(orderReturn.getFee());
            vo.setReturnNo(orderReturn.getOrderNo());
            vo.setReturnStatus((int)orderReturn.getReturnStatus());
            OrderRefundsConsultRecord orderRefundsConsultRecord=orderRefundsConsultRecordMapper.queryNewestRecord(orderNo);
            if(orderRefundsConsultRecord!=null){
                if(returnStatus==OrderReturn.IN_RETURN) {
                    Date applyTime=orderRefundsConsultRecord.getApplyTime();
                    if(applyTime!=null){
                        vo.setOperationTime(DateUtil.dateTimeFormatStr(applyTime,"yyyy-MM-dd HH:mm:ss"));
                    }
                }else if(returnStatus==OrderReturn.RETURN_SUCCESS){
                    Date auditTime=orderReturn.getAuditTime();
                    if(auditTime!=null){
                        vo.setOperationTime(DateUtil.dateTimeFormatStr(auditTime,"yyyy-MM-dd HH:mm:ss"));
                    }
                }else if(returnStatus==OrderReturn.RETURN_FAIL){
                    Date refuseTime=orderRefundsConsultRecord.getRefuseTime();
                    if(refuseTime!=null){
                        vo.setOperationTime(DateUtil.dateTimeFormatStr(orderRefundsConsultRecord.getRefuseTime(),"yyyy-MM-dd HH:mm:ss"));
                    }
                    vo.setRefuseReason(orderRefundsConsultRecord.getRefuseRemark());
                    String vochour=orderRefundsConsultRecord.getRefuseVoucher();
                    if(!StringUtils.isBlank(vochour)){
                        String []str=vochour.split(";");
                        List<String> list= Arrays.stream(str).collect(Collectors.toList());
                        vo.setRefuseVoucher(list);
                    }
                }
            }
            res.setData(vo);
        }else{
            res.setCode(OrderConstant.Query.IS_NOT_IN_REFUND);
            res.setMessage(OrderConstant.Query.IS_NOT_IN_REFUND_MSG);
    }
        return res;
    }


    @Override
    public PageInfo<HashMap<String, Object>> queryByCondition(Integer pageNo, Integer pageSize, BeauticianQueryVo beauticianQueryVo) {
        PageHelper.startPage(pageNo, pageSize);
        PageHelper.orderBy("add_time desc");
        List<HashMap<String,Object>> list=orderBaseMapper.selectBeauticianOrderInfo(beauticianQueryVo);
        PageInfo<HashMap<String,Object>> page = new PageInfo<>(list);
        return page;
    }


    @Override
    public ResponseMessage<OrderSendAppVo> querySendToAppVoByOrderId(Integer orderId) {
        ResponseMessage<OrderSendAppVo> res=new ResponseMessage<>();
        OrderSendAppVo vo=orderBaseMapper.queryById(orderId);
        if(vo!=null){
            res.setData(vo);
        }else{
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }


    @Override
    public ResponseMessage<HashMap<String, Object>> queryOrderRefundFailInfo(Integer orderId) {
        ResponseMessage<HashMap<String, Object>> res=new ResponseMessage<>();
        HashMap<String, Object> map=orderBaseMapper.queryRefundFail(orderId);
        if(map!=null){
            res.setData(map);
        }else{
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }


    @Override
    public ResponseMessage<Integer> countBeauticianPreIncome(Integer beauticianId) {
        ResponseMessage<Integer> res=new ResponseMessage<>();
        List<CountBeauticianIncomeVo> list=orderBaseMapper.countBeauticianPreIncome(beauticianId);
        int sum=0;
        if(!CollectionUtils.isEmpty(list)){
            for (CountBeauticianIncomeVo vo:list){
                Integer freight=vo.getFreight();
                Integer beauCommision=vo.getBeauticianCommission();
                sum+=Math.addExact(freight,beauCommision);
            }
        }
        res.setData(sum);
        return res;
    }




    @Override
    public ResponseMessage<List<StoreTodayOrderCount>> queryOrderNumByStoreId(int storeId) {
        ResponseMessage<List<StoreTodayOrderCount>> res=new ResponseMessage<>();
        List<StoreTodayOrderCount> list=orderBaseMapper.queryOrderNumByStoreId(storeId);
        res.setData(list);
        return res;
    }

    @Override
    public ResponseMessage<List<BeauticianTodayOrderCount>> queryOrderNumByBeauticianId(int beauticianId) {
        ResponseMessage<List<BeauticianTodayOrderCount>> res=new ResponseMessage<>();
        List<BeauticianTodayOrderCount> list=orderBaseMapper.queryOrderNoByBeauticianId(beauticianId);
        res.setData(list);
        return res;
    }

    @Override
    public ResponseMessage<Integer> sumOrderAmountByStoreIdAndDays(StatisticsOrderVo statisticsOrderVo) {
        ResponseMessage<Integer> res=new ResponseMessage<>();
        Map<String,Object> map=new HashMap<>(16);
        map.put("startTime",statisticsOrderVo.getStartTime());
        map.put("endTime",statisticsOrderVo.getEndTime());
        int type=statisticsOrderVo.getType();
        Integer tonver=0;
        if(type==0){
            tonver=orderBaseMapper.countPlatformTurnoverByDays(map);
        }else if(type==1){
            map.put("storeId",statisticsOrderVo.getStoreId());
            tonver=orderBaseMapper.countStoreTurnoverByDays(map);
        }
        res.setData(tonver);
        return res;
    }
}