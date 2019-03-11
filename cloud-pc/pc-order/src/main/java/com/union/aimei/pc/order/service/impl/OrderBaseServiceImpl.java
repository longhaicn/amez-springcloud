package com.union.aimei.pc.order.service.impl;

import com.alipay.api.response.AlipayTradeRefundResponse;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.pay.PayTypeEnum;
import com.union.aimei.common.feign.app.pay.PayReFundFeign;
import com.union.aimei.common.feign.pc.financial.BeauticianTradeDetailFeign;
import com.union.aimei.common.feign.pc.financial.FinancialCommonFeign;
import com.union.aimei.common.feign.pc.financial.PlatformTradeDetailFeign;
import com.union.aimei.common.feign.pc.financial.StoreTradeDetailFeign;
import com.union.aimei.common.feign.pc.member.MemberFeign;
import com.union.aimei.common.feign.pc.store.StoreFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.order.*;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.common.vo.pay.RefundParamVo;
import com.union.aimei.pc.order.async.CompleteOrder;
import com.union.aimei.pc.order.async.HalfHourNotifyTask;
import com.union.aimei.pc.order.mapper.*;
import com.union.aimei.pc.order.service.OrderBaseService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.StringUtil;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import com.union.redis.RedisService;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author GaoWei
 * @Date 18-8-13 下午2:57
 * @description
 */
@Service("orderBaseService")
@CommonsLog
public class OrderBaseServiceImpl implements OrderBaseService {
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
    private OrderRefundsConsultRecordMapper orderRefundsConsultRecordMapper;
    @Resource
    private FinancialCommonFeign financialCommonFeign;
    @Resource
    private HalfHourNotifyTask halfHourNotifyTask;
    @Resource
    private StoreTradeDetailFeign storeTradeDetailFeign;
    @Resource
    private CompleteOrder completeOrder;
    @Resource
    private PlatformTradeDetailFeign platformTradeDetailFeign;
    @Resource
    private BeauticianTradeDetailFeign beauticianTradeDetailFeign;
    @Resource
    private RedisService redisService;
    @Resource
    private StoreFeign storeFeign;
    @Resource
    private MemberFeign memberFeign;
    @Resource
    private PayReFundFeign payReFundFeign;

    /**
     * 添加订单
     *
     * @param
     * @return
     */
    @Override
    public int addObj(OrderBase t) {
        return this.orderBaseMapper.insertSelective(t);
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Override
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
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
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
     * 根据订单ID查询订单详情，包括订单基础信息，订单美容师，订单商品信息以及订单评论信息
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage<HashMap<String, Object>> getOrderDetailsInfo(Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();
        HashMap<String, Object> map = new HashMap<>(16);
        OrderBase orderBase = orderBaseMapper.selectByPrimaryKey(id);
        OrderBeautician orderBeautician = orderBeauticianMapper.queryByOrderId(id);
        OrderProduct orderProduct = orderProductMapper.queryByOrderId(id);
        if (orderBase != null && orderBeautician != null && orderProduct != null) {
            map.put("orderBase", orderBase);
            map.put("orderBeautician", orderBeautician);
            map.put("orderProduct", orderProduct);
            Date date = orderCommentMapper.queryOrderCommentTime(id);
            if (date != null) {
                map.put("orderCommentTime", date);
            }
            responseMessage.setData(map);
        } else {
            responseMessage.setCode(ResponseContants.QUERY_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<OrderInfoVo> queryOrderAllInfo(Integer orderId) {
        ResponseMessage<OrderInfoVo> res = new ResponseMessage<>();
        OrderBase orderBase = orderBaseMapper.selectByPrimaryKey(orderId);
        OrderBeautician orderBeautician = orderBeauticianMapper.queryByOrderId(orderId);
        OrderProduct orderProduct = orderProductMapper.queryByOrderId(orderId);
        if (orderBase != null && orderBeautician != null && orderProduct != null) {
            OrderInfoVo vo = new OrderInfoVo();
            vo.setOrderBase(orderBase);
            vo.setOrderBeautician(orderBeautician);
            vo.setOrderProduct(orderProduct);
            res.setData(vo);
        } else {
            res.setCode(ResponseContants.QUERY_EMPTY);
            res.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return res;
    }

    /**
     * 查询订单列表
     *
     * @param pageNo
     * @param pageSize
     * @param orderListQueryVo
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<OrderListVo>> queryOrderList(Integer pageNo, Integer pageSize, OrderListQueryVo orderListQueryVo) {

        ResponseMessage<PageInfo<OrderListVo>> res = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<OrderListVo> list = orderBaseMapper.queryOrderList(orderListQueryVo);
        PageInfo<OrderListVo> page = new PageInfo<>(list);
        res.setData(page);
        return res;
    }


    /**
     * 获取时间范围(从00:00:00到23:59:59)
     *
     * @param timeStr
     * @param suffix
     * @return
     */
    private static String getFormatTime(String timeStr, String suffix) {
        StringBuilder sb = new StringBuilder();
        sb.append(timeStr);
        sb.append(" ");
        sb.append(suffix);
        return sb.toString();
    }

    /**
     * 订单管理查询
     *
     * @param orderId
     * @return
     */
    @Override
    public ResponseMessage queryOrderDetailById(Integer orderId) {
        ResponseMessage res = new ResponseMessage();
        Map<String, Object> map = orderBaseMapper.queryOrderDetailById(orderId);
        if (map != null) {
            Integer storeId = Integer.valueOf(map.get("storeId").toString());
            //查询店铺相关信息
            Store store = storeFeign.queryById(storeId);
            if (store != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(StringUtil.trimNull(store.getProvinceName()));
                sb.append(StringUtil.trimNull(store.getCityName()));
                sb.append(StringUtil.trimNull(store.getAreaName()));
                sb.append(StringUtil.trimNull(store.getStoreAddress()));
                map.put("storeAddress", sb.toString());
                map.put("storeTel", store.getStoreTel());
                map.put("storeOwnerName", store.getBossName());
            }
        } else {
            throw new ServerException(500, "查询为空");
        }
        res.setData(map);
        return res;
    }


    @Override
    public ResponseMessage<OrderRefundDetailVo> queryOrderRefundDetails(Integer orderId) {
        ResponseMessage<OrderRefundDetailVo> res = new ResponseMessage<>();
        OrderBase order = orderBaseMapper.selectByPrimaryKey(orderId);
        OrderRefundDetailVo vo = new OrderRefundDetailVo();
        vo.setOrderNo(order.getOrderNo());
        vo.setSuccessRefundTime(order.getReturnTime());
        vo.setAmountTotal(order.getAmountTotal());
        vo.setStoreName(order.getStoreName());
        Integer type = order.getType();
        vo.setOrderType(type);
        vo.setActualPay(order.getAmountPay());
        vo.setCouponReduce(order.getCouponReduce());
        vo.setMemberCardReduce(order.getMemberCardReduce());
        String memebrName = "";
        if (type == 0) {
            memebrName = order.getMemberRealName();
        } else {
            memebrName = order.getCustomerName();
        }
        vo.setMemberName(memebrName);
        vo.setMemberPhone(order.getMemberPhone());
        OrderProduct orderProduct = orderProductMapper.queryByOrderId(orderId);
        vo.setProductName(orderProduct.getProductName());
        vo.setProductImg(orderProduct.getProductImg());
        vo.setProductPrice(orderProduct.getProductPrice());
        OrderBeautician orderBeautician = orderBeauticianMapper.queryByOrderId(orderId);
        vo.setServerBeauticianName(orderBeautician.getBeauticianName());
        Store store = storeFeign.queryById(order.getStoreId());
        if (store != null) {
            vo.setStoreBossName(store.getSellerName());
            vo.setStoreBossPhone(store.getSellerPhone());
            vo.setStoreAddress(store.getStoreAddress());
        }
        //查询订单退款信息
        OrderReturn orderReturn = orderReturnMapper.queryByOrderId(orderId);
        vo.setApplyRefundTime(orderReturn.getApplyTime());
        vo.setAuditTime(orderReturn.getAuditTime());
        vo.setReturnStatus(orderReturn.getReturnStatus());
        vo.setReason(orderReturn.getReason());
        vo.setRefundAmount(orderReturn.getFee());
        List<OrderRefundsConsultRecord> list = orderRefundsConsultRecordMapper.queryByOrderId(orderId);
        if (!CollectionUtils.isEmpty(list)) {
            vo.setList(list);
        }
        res.setData(vo);
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHasCompleteOrder() {
        //修改订单状态为已完成
        orderBaseMapper.batchUpdateOrderStatus();
    }


    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public void refundOrderTask() {
        List<OrderBase> list = orderBaseMapper.queryAutoRefundHasOver();
        if (!CollectionUtils.isEmpty(list)) {
            List<Integer> intList = list.stream().map(OrderBase::getId).collect(Collectors.toList());
            //更改相关订单数据
            this.updateRefundTask(list, intList);
            for (Integer id : intList) {
                //添加信息到交易流水
                ResponseMessage<OrderInfoVo> orderAllInfo = this.queryOrderAllInfo(id);
                if (HttpStatusConstant.OK.getStatus() == orderAllInfo.getCode()) {
                    OrderInfoVo orderInfoVo = orderAllInfo.getData();
                    OrderBase orderBase = orderInfoVo.getOrderBase();
                    OrderBeautician orderBeautician = orderInfoVo.getOrderBeautician();
                    OrderProduct orderProduct = orderInfoVo.getOrderProduct();
                    //更改订单的退款状态为已完成,更改订单退款记录表为审核通过
                    this.auditOrderRefund(orderBase);
                    //添加交易流水记录
                    addTradeRecord(orderBase, orderBeautician, orderProduct);

                } else {
                    throw new ServerException(500, "执行添加交易流水失败");
                }
            }
        } else {
            throw new ServerException(500, "查询不到订单信息");
        }
    }


    private void addTradeRecord(OrderBase orderBase, OrderBeautician orderBeautician, OrderProduct orderProduct) {
        ResponseMessage<BeauticianTradeDetail> res = beauticianTradeDetailFeign.queryByOrderNoAndType(orderBase.getOrderNo(), 1);
        AssertUtil.isRemoteInvokeSuccess(res);
        BeauticianTradeDetail beauticianTradeDetail = res.getData();
        int beauticianCom = beauticianTradeDetail.getIncome();
        int platForm = beauticianTradeDetail.getPlatformAmount();
        int storeCom = beauticianTradeDetail.getStoreAmoun();
        if (orderBase.getStoreId() != null) {
            //添加店铺交易流水记录
            StoreTradeDetail storeTradeDetail = new StoreTradeDetail();
            storeTradeDetail.setStoreId(orderBase.getStoreId());
            storeTradeDetail.setBeauticianId(orderBeautician.getBeauticianId());
            storeTradeDetail.setStoreName(orderBase.getStoreName());
            storeTradeDetail.setBeauticianName(orderBeautician.getBeauticianName());
            storeTradeDetail.setOrderNo(orderBase.getOrderNo());
            storeTradeDetail.setTradeType(3);
            storeTradeDetail.setNetAmount((-1) * storeCom);
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
        BeauticianTradeDetail beauDetail = new BeauticianTradeDetail();
        beauDetail.setStoreId(orderBase.getStoreId() == null ? orderBase.getAnchoredStoreId() : orderBase.getStoreId());
        beauDetail.setBeauticianId(orderBeautician.getBeauticianId());
        beauDetail.setStoreName(orderBase.getStoreName());
        beauDetail.setBeauticianName(orderBeautician.getBeauticianName());
        beauDetail.setProductNumber(orderProduct.getNums());
        beauDetail.setProductPrice(orderProduct.getProductPrice());
        beauDetail.setOrderNo(orderBase.getOrderNo());
        beauDetail.setTradeType(3);
        beauDetail.setReimburseTime(orderBase.getReturnTime());
        beauDetail.setIncome((-1) * beauticianCom);
        beauDetail.setNetIncome((-1) * beauticianTradeDetail.getNetIncome());
        beauDetail.setBeauticianType(orderBeautician.getType().intValue() == 2 ? 1 : (orderBeautician.getType().intValue() == 3 ? 0 : 1));
        beauDetail.setPayTime(orderBase.getPayTime());
        beauDetail.setProductName(orderProduct.getProductName());
        beauDetail.setTradeStatus(0);
        beauDetail.setReimburseAmount(orderBase.getAmountPay());
        int freight = orderBase.getFreight();
        beauDetail.setVisitAmount(freight);
        log.info("支付方式为:" + orderBase.getPayType());
        if (orderBase.getPayType() != null) {
            beauDetail.setPayMethod(changePayTypeToInt(orderBase.getPayType()));
        }
        beauticianTradeDetailFeign.insertSelectiveV110(beauDetail);
        //添加平台流水
        PlatformTradeDetail platDetail = new PlatformTradeDetail();
        platDetail.setOrderNumber(orderBase.getOrderNo());
        platDetail.setTransactionSerialNumber(orderBase.getTradeNo());
        platDetail.setPayTime(orderBase.getPayTime());
        platDetail.setTradeType(4);
        platDetail.setTradeStatus(orderBase.getStatus());
        platDetail.setOrderAmount(orderBase.getAmountTotal());
        platDetail.setActuallyAmount(orderBase.getAmountPay());
        platDetail.setPlatformCommission((-1) * platForm);
        if (orderBase.getPayType() != null) {
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


    public void updateRefundTask(List<OrderBase> orderList, List<Integer> inList) {
        List<OrderReturn> returnList = new ArrayList<>(10);
        for (Integer id : inList) {
            OrderReturn or = orderReturnMapper.queryByOrderId(id);
            if (or != null) {
                returnList.add(or);
            } else {
                throw new ServerException(500, "数据异常，请检查数据");
            }
        }
        if (!CollectionUtils.isEmpty(returnList)) {
            //修改订单退款记录状态
            orderReturnMapper.batchUpdateStatus();
            //修改订单状态
            for (OrderBase orderBase : orderList) {
                orderBase.setReturnStatus(2);
                orderBase.setReturnTime(new Date());
                orderBaseMapper.updateByPrimaryKeySelective(orderBase);
            }
            List<OrderRefundsConsultRecord> list = new ArrayList<>(10);
            for (OrderReturn orderReturn : returnList) {
                OrderRefundsConsultRecord record = new OrderRefundsConsultRecord();
                record.setOrderReturnId(orderReturn.getId());
                record.setApplyRemark("卖家未及时处理，系统自动退款");
                list.add(record);
            }
            orderRefundsConsultRecordMapper.batchInsert(list);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void autoGoodCommentTask() {
        //查询没有评价的订单
        List<OrderBase> list = orderBaseMapper.queryHasNoCommentOrderBase();
        if (!CollectionUtils.isEmpty(list)) {
            for (OrderBase order : list) {
                autoOperationOrderComment(order);
            }
        }
    }

    private void autoOperationOrderComment(OrderBase orderBase) {
        OrderComment orderComment = new OrderComment();
        OrderProduct orderProduct = orderProductMapper.queryByOrderId(orderBase.getId());
        Integer servicecredit = 5;
        orderComment.setServicecredit(servicecredit);
        Integer storeEnvironment = 5;
        orderComment.setStoreEnvironment(storeEnvironment);
        Integer beauticianServerQuality = 5;
        orderComment.setBeauticianServerQuality(beauticianServerQuality);
        String content = "";
        orderComment.setContent(content);
        Byte grade = 4;
        orderComment.setProductEvaluationGrade(grade);
        Integer operType = 1;
        orderComment.setOrderId(orderBase.getId());
        orderComment.setOrderNo(orderBase.getOrderNo());
        orderComment.setMemberId(orderBase.getMemberId());
        orderComment.setMemberName(orderBase.getMemberRealName() == null ? orderBase.getMemberNickName() : orderBase.getMemberRealName());
        orderComment.setOperType(operType);
        orderComment.setStoreEvaluationGrade(grade);
        orderComment.setStoreId(orderBase.getStoreId());
        orderComment.setStoreName(orderBase.getStoreName());
        orderComment.setProductId(orderProduct.getProductId());
        orderComment.setProcutName(orderProduct.getProductName());
        orderComment.setProductImg(orderProduct.getProductImg());
        orderCommentMapper.insertSelective(orderComment);
        orderBase.setStatus(5);
        orderBase.setBeauticianReplyCommentStatus((byte) 3);
        orderBaseMapper.updateByPrimaryKeySelective(orderBase);
    }


    public ResponseMessage<List<OrderSendAppVo>> queryJustPreOneHourOrder() {
        ResponseMessage<List<OrderSendAppVo>> res = new ResponseMessage<>();
        List<OrderSendAppVo> list = orderBaseMapper.queryPreOneHourOrders();
        if (!CollectionUtils.isEmpty(list)) {
            res.setData(list);
        } else {
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }

    public ResponseMessage<List<OrderSendAppVo>> queryHalfHourOrder() {
        ResponseMessage<List<OrderSendAppVo>> res = new ResponseMessage<>();
        List<OrderSendAppVo> list = orderBaseMapper.queryPreHalfHourOrders();
        if (!CollectionUtils.isEmpty(list)) {
            res.setData(list);
        } else {
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }

    public ResponseMessage auditOrderRefund(OrderBase orderBase) {
        ResponseMessage res = new ResponseMessage();
        OrderReturn orderReturn = orderReturnMapper.queryByOrderId(orderBase.getId());
        Byte reStatus;
        orderBase.setReturnStatus(2);
        orderBase.setReturnTime(new Date());
        reStatus = 2;
        orderReturn.setReturnStatus(reStatus);
        orderReturn.setAuditTime(new Date());
        orderBaseMapper.updateByPrimaryKeySelective(orderBase);
        orderReturnMapper.updateByPrimaryKeySelective(orderReturn);
        return res;
    }


    public ResponseMessage<List<OrderBase>> queryRefundOrderBaseHasOver() {
        ResponseMessage<List<OrderBase>> res = new ResponseMessage<>();
        List<OrderBase> list = orderBaseMapper.queryAutoRefundHasOver();
        if (!CollectionUtils.isEmpty(list)) {
            res.setData(list);
        } else {
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }


    public ResponseMessage<List<OrderBase>> queryInServerList() {
        OrderBase orderBase = new OrderBase();
        orderBase.setStatus(3);
        List<OrderBase> list = orderBaseMapper.selectListByConditions(orderBase);
        ResponseMessage<List<OrderBase>> res;
        if (!CollectionUtils.isEmpty(list)) {
            res = new ResponseMessage<>();
            res.setData(list);
        } else {
            throw new ServerException(500, "查询为空");
        }
        return res;
    }


    @Override
    public ResponseMessage<HashMap<String, Integer>> countOrderInfoByDays(Integer type, Integer storeId, Integer days) {
        ResponseMessage<HashMap<String, Integer>> res = new ResponseMessage<>();
        Map<String, Object> map = new HashMap<>(16);
        map.put("storeId", storeId);
        map.put("chooseTime", calculationChooseTime(days));
        //统计订单数量
        HashMap<String, Integer> hashMap = orderBaseMapper.countByDays(map);
        //统计会员卡交易数量
        res.setData(hashMap);
        return res;
    }

    /**
     * 计算选择时间
     *
     * @param daysNum
     * @return
     */
    private static String calculationChooseTime(int daysNum) {
        StringBuilder nowTime = new StringBuilder();
        try {
            String time = DateUtil.getFrontDay(new Date(), daysNum - 1, "yyyy-MM-dd");
            nowTime.append(time);
            nowTime.append(" ");
            nowTime.append("00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ServerException(500, "时间计算异常，请稍后重试");
        }
        return nowTime.toString();
    }


    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void completeUpdateJob() {
        List<OrderBase> list = orderBaseMapper.queryHasCompleteList();
        log.info("查询到已完成的数量：" + list.size());
        if (!CollectionUtils.isEmpty(list)) {
            List<String> strList = new ArrayList<>(10);
            for (OrderBase order : list) {
                order.setStatus(4);
                int result = orderBaseMapper.updateByPrimaryKeySelective(order);
                if (result != 1) {
                    throw new ServerException(500, "更改订单状态失败");
                }
                String orderNo = order.getOrderNo();
                strList.add(orderNo);
                //更改美容师流水状态
                //更改店铺流水状态
                //更改平台流水状态
                log.info("推送APP消息，提醒用户评价");
                //推送消息
                OrderSendAppVo vo = orderBaseMapper.queryById(order.getId());
                completeOrder.pushMsg(vo);
            }
            log.info("更改流水状态为已完成");
            ResponseMessage res = financialCommonFeign.updateOrderStatus(strList);
            log.info("更改流水状态结果：" + res.toString());
            if (HttpStatusConstant.OK.getStatus() != res.getCode()) {
                throw new ServerException(500, "更改订单流水状态失败");
            }
        }
    }


    @Override
    public void notifyPreHalfHourJob() {
        log.info("查询还有半个小时开始的服务订单");
        List<OrderSendAppVo> list = orderBaseMapper.queryPreHalfHourOrders();
        if (!CollectionUtils.isEmpty(list)) {
            for (OrderSendAppVo vo : list) {
                String orderNo = vo.getOrderNo();
                String key = "half_hour_" + orderNo;
                Object value = redisService.get(key);
                if (value == null) {
                    halfHourNotifyTask.push(vo);
                    redisService.set(key, vo, 1000 * 60 * 30L);
                }
            }
        }
    }


    @Override
    public ResponseMessage<Integer> sumOrderAmountByStoreIdAndDays(StatisticsOrderVo statisticsOrderVo) {
        ResponseMessage<Integer> res = new ResponseMessage<>();
        Map<String, Object> map = new HashMap<>(16);
        map.put("startTime", statisticsOrderVo.getStartTime());
        map.put("endTime", statisticsOrderVo.getEndTime());
        int type = statisticsOrderVo.getType();
        Integer tonver = 0;
        if (type == 0) {
            tonver = orderBaseMapper.countPlatformTurnoverByDays(map);
        } else if (type == 1) {
            map.put("storeId", statisticsOrderVo.getStoreId());
            tonver = orderBaseMapper.countStoreTurnoverByDays(map);
        }
        res.setData(tonver);
        return res;
    }


    @Override
    public ResponseMessage<Integer> newAddOrderNums(QueryNewAddOrder queryNewAddOrder) {
        ResponseMessage<Integer> res = new ResponseMessage<>();
        Map<String, Object> map = new HashMap<>(16);
        map.put("query", queryNewAddOrder.getQuery());
        map.put("days", queryNewAddOrder.getDays());
        map.put("type", queryNewAddOrder.getType());
        map.put("storeId", queryNewAddOrder.getStoreId());
        Integer result = orderBaseMapper.countStoreNewAddOrderNums(map);
        res.setData(result);
        return res;
    }


    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage auditOrderRefundByPlatForm(Integer orderId) {
        log.info("平台同意退款：");
        ResponseMessage resMsg = new ResponseMessage();
        //查询退款状态
        OrderReturn orderRe = orderReturnMapper.queryByOrderId(orderId);
        Optional.of(orderRe)
                .filter(x -> x != null)
                .orElseThrow(() -> new ServerException(500, "查询退款订单为空"));
        int status = orderRe.getReturnStatus();
        if (status < 0 || status > OrderBase.OrderStatus.IN_SERVER) {
            throw new ServerException(500, "订单状态异常,请仔细检查");
        }
        if (status == 1) {
            throw new ServerException(500, "请耐心等待审核结果");
        }
        if (status == OrderBase.OrderStatus.WAIT_SERVER) {
            throw new ServerException(500, "订单已退款");
        }
        ResponseMessage<OrderInfoVo> orderAllInfo = this.queryOrderAllInfo(orderId);
        if (HttpStatusConstant.OK.getStatus() == orderAllInfo.getCode()) {
            OrderInfoVo orderInfoVo = orderAllInfo.getData();
            OrderBase orderBase = orderInfoVo.getOrderBase();
            OrderBeautician orderBeautician = orderInfoVo.getOrderBeautician();
            OrderProduct orderProduct = orderInfoVo.getOrderProduct();
            //更改订单的退款状态为已完成,更改订单退款记录表为审核通过
            this.auditOrderRefund(orderBase);
            log.info("更改订单状态完成");
            //添加流水记录
            this.addTradeRecordByPlatform(orderBase, orderBeautician, orderProduct);
            log.info("添加流水完成");
            //添加协商记录
            OrderRefundsConsultRecord record = new OrderRefundsConsultRecord();
            Member member = memberFeign.queryById(orderBase.getMemberId());
            if (member != null) {
                record.setApplyMemberId(member.getId());
                record.setApplyMemberHeadImg(member.getMemberImgUrl());
                record.setApplyMemberNickname(member.getMemberNickname());
            }
            OrderReturn orderReturn = orderReturnMapper.queryByOrderId(orderId);
            if (orderReturn != null) {
                record.setOrderReturnId(orderReturn.getId());
                record.setApplyReason(orderReturn.getReason());
                record.setApplyRemark(orderReturn.getRemark());
            }
            String content = "客服接入，支持买家，退款成功";
            record.setOperContent(content);
            Byte type = 2;
            record.setOperType(type);
            orderRefundsConsultRecordMapper.insertSelective(record);
            log.info("添加协商记录完成");
            //执行原路退款
            executeRefund(orderRe, orderBase, orderBeautician, orderProduct);
            log.info("执行退款完成");
        } else {
            resMsg.setCode(orderAllInfo.getCode());
            resMsg.setMessage(orderAllInfo.getMessage());
        }
        return resMsg;

    }


    private void addTradeRecordByPlatform(OrderBase orderBase, OrderBeautician orderBeautician, OrderProduct orderProduct) {
        ResponseMessage<BeauticianTradeDetail> res = beauticianTradeDetailFeign.queryByOrderNoAndType(orderBase.getOrderNo(), 1);
        AssertUtil.isRemoteInvokeSuccess(res);
        BeauticianTradeDetail beauticianTradeDetail = res.getData();
        int beauticianCom = beauticianTradeDetail.getIncome();
        int platForm = beauticianTradeDetail.getPlatformAmount();
        int storeCom = beauticianTradeDetail.getStoreAmoun();
        if (orderBase.getStoreId() != null) {
            //添加店铺交易流水记录
            StoreTradeDetail storeTradeDetail = new StoreTradeDetail();
            storeTradeDetail.setStoreId(orderBase.getStoreId());
            storeTradeDetail.setBeauticianId(orderBeautician.getBeauticianId());
            storeTradeDetail.setStoreName(orderBase.getStoreName());
            storeTradeDetail.setBeauticianName(orderBeautician.getBeauticianName());
            storeTradeDetail.setOrderNo(orderBase.getOrderNo());
            storeTradeDetail.setTradeType(3);
            storeTradeDetail.setNetAmount((-1) * storeCom);
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
        BeauticianTradeDetail beauDetail = new BeauticianTradeDetail();
        beauDetail.setStoreId(orderBase.getStoreId() == null ? orderBase.getAnchoredStoreId() : orderBase.getStoreId());
        beauDetail.setBeauticianId(orderBeautician.getBeauticianId());
        beauDetail.setStoreName(orderBase.getStoreName());
        beauDetail.setBeauticianName(orderBeautician.getBeauticianName());
        beauDetail.setProductNumber(orderProduct.getNums());
        beauDetail.setProductPrice(orderProduct.getProductPrice());
        beauDetail.setOrderNo(orderBase.getOrderNo());
        beauDetail.setTradeType(3);
        beauDetail.setReimburseTime(orderBase.getReturnTime());
        beauDetail.setIncome((-1) * beauticianCom);
        beauDetail.setNetIncome((-1) * beauticianTradeDetail.getNetIncome());
        beauDetail.setBeauticianType(orderBeautician.getType().intValue() == 2 ? 1 : (orderBeautician.getType().intValue() == 3 ? 0 : 1));
        beauDetail.setPayTime(orderBase.getPayTime());
        beauDetail.setProductName(orderProduct.getProductName());
        beauDetail.setTradeStatus(0);
        beauDetail.setReimburseAmount(orderBase.getAmountPay());
        int freight = orderBase.getFreight();
        beauDetail.setVisitAmount(freight);
        log.info("支付方式为:" + orderBase.getPayType());
        if (orderBase.getPayType() != null) {
            beauDetail.setPayMethod(changePayTypeToInt(orderBase.getPayType()));
        }
        beauticianTradeDetailFeign.insertSelectiveV110(beauDetail);
        //添加平台流水
        PlatformTradeDetail platDetail = new PlatformTradeDetail();
        platDetail.setOrderNumber(orderBase.getOrderNo());
        platDetail.setTransactionSerialNumber(orderBase.getTradeNo());
        platDetail.setPayTime(orderBase.getPayTime());
        platDetail.setTradeType(4);
        platDetail.setTradeStatus(orderBase.getStatus());
        platDetail.setOrderAmount(orderBase.getAmountTotal());
        platDetail.setActuallyAmount(orderBase.getAmountPay());
        platDetail.setPlatformCommission((-1) * platForm);
        if (orderBase.getPayType() != null) {
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


    private Integer changePayTypeToInt(String payType) {
        if (StringUtils.isBlank(payType)) {
            throw new ServerException(500, "支付类型为空");
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
                payMethod = 4
                ;
                break;
            case "balancePay":
                payMethod = 5;
                ;
                break;
            default:
                ;
                break;
        }
        return payMethod;
    }


    private ResponseMessage executeRefund(OrderReturn orderReturn, OrderBase orderBase, OrderBeautician orderBeautician, OrderProduct orderProduct) {
        ResponseMessage res = new ResponseMessage();
        //原路退款
        String payType = orderBase.getPayType();
        log.info("开始执行退款");
        if (PayTypeEnum.ALI_PAY.equals(payType)) {
            log.info("开始执行支付宝退款业务逻辑");
            ResponseMessage<AlipayTradeRefundResponse> aliRefundMsg = payReFundFeign.tradeRefund(orderBase.getOrderNo());
            if (aliRefundMsg.getCode() != HttpStatusConstant.OK.getStatus()) {
                res.setCode(aliRefundMsg.getCode());
                res.setMessage(aliRefundMsg.getMessage());
            }
        } else if (PayTypeEnum.WX_PAY.equals(payType)) {
            log.info("开始执行微信退款业务逻辑");
            ResponseMessage<WxPayRefundResult> wxRefundMsg = payReFundFeign.refund(0, orderBase.getOrderNo());
            if (wxRefundMsg.getCode() != HttpStatusConstant.OK.getStatus()) {
                res.setCode(wxRefundMsg.getCode());
                res.setMessage(wxRefundMsg.getMessage());
            }
        } else if (PayTypeEnum.BALANCE_PAY.equals(payType)) {
            log.info("开始执行余额退款业务逻辑");
            RefundParamVo paramVo = getRefundParamVo(0, orderReturn.getRefundOrderNo(), orderReturn.getReason(), orderBase);
            if (paramVo == null) {
                throw new ServerException(500, "退款失败");
            }
            ResponseMessage balanMsg = payReFundFeign.refund(paramVo);
            if (balanMsg.getCode() != HttpStatusConstant.OK.getStatus()) {
                res.setCode(balanMsg.getCode());
                res.setMessage(balanMsg.getMessage());
            }
        } else if (PayTypeEnum.ONE_CARD_PAY.equals(payType)) {
            log.info("开始执行一卡通退款业务逻辑");
            RefundParamVo paramVo = getRefundParamVo(1, orderReturn.getRefundOrderNo(), orderReturn.getReason(), orderBase);
            if (paramVo == null) {
                throw new ServerException(500, "退款失败");
            }
            ResponseMessage oneCardMsg = payReFundFeign.refund(paramVo);
            if (oneCardMsg.getCode() != HttpStatusConstant.OK.getStatus()) {
                res.setCode(oneCardMsg.getCode());
                res.setMessage(oneCardMsg.getMessage());
            }
        }
        return res;
    }

    private RefundParamVo getRefundParamVo(int type, String refundNo, String reason, OrderBase orderBase) {
        RefundParamVo paramVo = new RefundParamVo();
        Member member = memberFeign.queryById(orderBase.getMemberId());
        if (member == null) {
            return null;
        }
        paramVo.setUuid(member.getAmezUuid());
        paramVo.setOrderNo(orderBase.getOrderNo());
        paramVo.setRefundNo(refundNo);
        BigDecimal refundFee = new BigDecimal((double) orderBase.getAmountPay() / 100);
        paramVo.setRefundFee(refundFee.setScale(2, BigDecimal.ROUND_FLOOR));
        paramVo.setRefundReason(reason);
        paramVo.setAppSystem(HttpStatusConstant.OK.getStatus());
        paramVo.setMemberId(member.getAmezUserId().longValue());
        //余额
        if (type == 0) {
            paramVo.setRefundPayType(4);
        } else if (type == 1) {
            //一卡通
            paramVo.setRefundPayType(3);
            paramVo.setOneCardId(orderBase.getCardId().longValue());
        }
        return paramVo;
    }

}