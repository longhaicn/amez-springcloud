package com.union.aimei.pay.service.impl;

import com.github.binarywang.wxpay.bean.order.WxPayAppOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.pay.PayConstant;
import com.union.aimei.common.feign.app.learn.LearnTradeRecodeFeign;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.feign.app.order.OrderReturnFeign;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.RefundObject;
import com.union.aimei.pay.service.WxbsPayService;
import com.union.aimei.pay.util.InetUtil;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author GaoWei
 * @time 2018/6/1 18:39
 * @description
 */
@Service
@CommonsLog
public class WxbsPayServiceImpl implements WxbsPayService {


    /**
     * 商品描述
     */
    private static final String PRODUCT_DESCRIBE = "美容邦商品微信支付";
    /**
     * 产品描述
     */
    private static final String PRODUCT_GOODS_DESCRIBE = "美容邦产品微信支付";
    /**
     * 购买课程描述
     */
    private static final String LEARN_DES = "课程购买";
    /**
     * 参与活动
     */
    private static final String JOIN_ACTIVITY = "活动支付";
    /**
     * 成功状态
     */
    private static final String SUCCESS = "SUCCESS";

    @Resource
    private OrderReturnFeign orderReturnFeign;
    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;
    @Resource
    private LearnTradeRecodeFeign learnTradeRecodeFeign;
    /**
     * 用户端bean
     */
    @Resource(name = "wxPayService")
    private WxPayService wxService;
    /**
     * 美容师端bean
     */
    @Resource(name = "wxPayBeauticianService")
    private WxPayService wxPayService;
    /**
     * 店长端bean
     */
    @Resource(name = "wxPayStoreOwnerService")
    private WxPayService payService;

    /**
     * 微信统一下单交易类型
     *
     * @param responseMessage
     * @param tradeVo
     * @param tradeType
     * @throws WxPayException
     */
    private void unifiedOrderByTradeType(ResponseMessage responseMessage, TradeVo tradeVo, Integer tradeType) throws WxPayException {
        WxPayUnifiedOrderRequest request = new WxPayUnifiedOrderRequest();
        request.setSpbillCreateIp(InetUtil.getIp());
        request.setTotalFee(tradeVo.getAmountTotal());
        request.setOutTradeNo(tradeVo.getOrderNo());
        StringBuilder sb = new StringBuilder();
        String name = tradeVo.getProductName();
        sb.append(name == null ? "" : name);
        if (tradeType == 0) {
            request.setBody(PRODUCT_DESCRIBE);
            request.setAttach("buyProduct");
        } else if (tradeType == 1) {
            request.setAttach("buyCard");
            sb.append("会员卡");
            sb.append("-");
            sb.append("购卡");
            request.setBody(sb.toString());
        } else if (tradeType == TradeVo.TradeType.RECHARGE_CARD) {
            sb.append("会员卡");
            sb.append("-");
            sb.append("充值");
            request.setBody(sb.toString());
            request.setAttach("rechargeCard");
        } else if (tradeType == TradeVo.TradeType.BUY_GOODS) {
            request.setBody(PRODUCT_GOODS_DESCRIBE);
            request.setAttach("buyGoods");
        } else if (tradeType == TradeVo.TradeType.BUY_LESSSONS) {
            request.setBody(LEARN_DES);
            request.setAttach("buyLearns");
        } else if (tradeType == TradeVo.TradeType.BUY_ACTIVITY) {
            request.setBody(JOIN_ACTIVITY);
            request.setAttach("buyActivity");
        }
        WxPayAppOrderResult result = null;
        Integer useType = tradeVo.getUseType();
        if (useType == TradeVo.UseType.CUSTOMER) {
            result = this.wxService.createOrder(request);
        } else if (useType == TradeVo.UseType.BEAUTICIAN) {
            result = this.wxPayService.createOrder(request);
        } else if (useType == TradeVo.UseType.STORE_SELLER) {
            result = this.payService.createOrder(request);
        }
        if (result != null) {
            responseMessage.setData(result);
        } else {
            responseMessage.setCode(PayConstant.INOVKE_WXPAY_FAIL);
            responseMessage.setMessage(PayConstant.INOVKE_WXPAY_FAIL_MSG);
        }
    }

    @Override
    public ResponseMessage unifiedOrder(TradeVo tradeVo) throws WxPayException {
        log.info("申请微信APP支付");
        ResponseMessage responseMessage = new ResponseMessage();
        //交易类型为商品交易并且支付类型为微信支付
        log.info("微信APP支付请求对象为:" + tradeVo.toString());
        Integer tradeType = tradeVo.getTradeType();
        Integer payType = tradeVo.getPayType();
        //如果是服务商品或者实物产品交易，以及支付类型为微信支付
        boolean isWxPayCondition = (tradeType == 0 || tradeType == 3 || tradeType == 4 || tradeType == 5) && payType == 0;
        if (isWxPayCondition) {
            int amountTotal = 0;
            if (0 == tradeType) {
                //查询订单状态存在
                OrderBase orderBase = orderBaseFeign.queryByOrderNo(tradeVo.getOrderNo());
                if (orderBase != null) {
                    Integer status = orderBase.getStatus();
                    if (status >= OrderBase.OrderStatus.WAIT_SERVER) {
                        responseMessage.setCode(PayConstant.REPEAT_PAY);
                        responseMessage.setMessage(PayConstant.REPEAT_PAY_MSG);
                        return responseMessage;
                    }
                    amountTotal = orderBase.getNeedPay();
                } else {
                    responseMessage.setCode(PayConstant.GET_ORDER_INFO_FAIL);
                    responseMessage.setMessage(PayConstant.GET_AMORDERINFO_FAI_MSG);
                    return responseMessage;
                }
            } else if (TradeVo.TradeType.BUY_GOODS == tradeType) {
                ResponseMessage<OrderGoodsBase> res = orderGoodsBaseFeign.queryByOrderNo(tradeVo.getOrderNo());
                if (HttpStatusConstant.OK.getStatus() == res.getCode()) {
                    OrderGoodsBase orderGoodsBase = res.getData();
                    Integer status = orderGoodsBase.getStatus();
                    if (status >= 1) {
                        responseMessage.setCode(PayConstant.REPEAT_PAY);
                        responseMessage.setMessage(PayConstant.REPEAT_PAY_MSG);
                        return responseMessage;
                    }
                    amountTotal = orderGoodsBase.getAmountTotal();
                } else {
                    responseMessage.setCode(PayConstant.GET_ORDER_INFO_FAIL);
                    responseMessage.setMessage(PayConstant.GET_AMORDERINFO_FAI_MSG);
                    return responseMessage;
                }
            } else if (TradeVo.TradeType.BUY_LESSSONS == tradeType || TradeVo.TradeType.BUY_ACTIVITY == tradeType) {
                //课程交易
                ResponseMessage<LearnTradeRecode> res = learnTradeRecodeFeign.queryTradeRecodeByOrderNo(tradeVo.getOrderNo());
                AssertUtil.isRemoteInvokeSuccess(res);
                LearnTradeRecode learnTradeRecode = res.getData();
                boolean payStatus = learnTradeRecode.getPayStatus();
                Optional.of(payStatus).filter(stat -> stat == false).orElseThrow(() -> new ServerException(500, "请勿重复支付"));
                amountTotal = learnTradeRecode.getTradeAmount();
            }
            if (amountTotal >= 1) {
                tradeVo.setAmountTotal(amountTotal);
            } else {
                log.info("交易金额小于1");
                responseMessage.setCode(PayConstant.TRADE_AMOUNT_ERROR);
                responseMessage.setMessage(PayConstant.TRADE_AMOUNT_ERROR_MSG);
                return responseMessage;
            }
        } else {
            responseMessage.setCode(PayConstant.INVOKE_WEIXIN_PAY_FAIL);
            responseMessage.setMessage(PayConstant.INVOKE_WEIXIN_PAY_FAIL_MSG);
        }
        // 微信统一下单交易类型
        this.unifiedOrderByTradeType(responseMessage, tradeVo, tradeType);
        return responseMessage;
    }

    @Override
    public ResponseMessage<WxPayRefundResult> refund(int paySource, String orderNo) throws WxPayException {
        ResponseMessage<RefundObject> res = orderReturnFeign.queryRefundObject(orderNo);
        AssertUtil.isRemoteInvokeSuccess(res);
        RefundObject refundObject = res.getData();
        WxPayRefundRequest request = WxPayRefundRequest.newBuilder()
                .outTradeNo(refundObject.getOutTradeNo())
                .transactionId(refundObject.getTradeNo())
                .totalFee(refundObject.getTotalFee())
                .outRefundNo(refundObject.getOutRefundNo())
                .refundFee(refundObject.getRefundFee())
                .build();
        WxPayRefundResult result = null;
        switch (paySource) {
            case 0:
                result = wxService.refund(request);
                break;
            case 1:
                result = wxPayService.refund(request);
                break;
            case 2:
                result = payService.refund(request);
                break;
            default:
                ;
                break;
        }
        ResponseMessage<WxPayRefundResult> responseMessage = new ResponseMessage<>();
        String returnCode = result.getReturnCode();
        String resultCode = result.getResultCode();
        if (!SUCCESS.equals(returnCode) || !SUCCESS.equals(resultCode)) {
            responseMessage.setCode(500);
            responseMessage.setMessage(result.getReturnMsg());
        } else {
            responseMessage.setData(result);
        }
        return responseMessage;
    }
}
