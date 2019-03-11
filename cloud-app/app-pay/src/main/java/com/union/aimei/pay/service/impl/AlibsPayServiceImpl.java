package com.union.aimei.pay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.union.aimei.common.constant.pay.PayConstant;
import com.union.aimei.common.feign.app.learn.LearnTradeRecodeFeign;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.feign.app.order.OrderReturnFeign;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.RefundObject;
import com.union.aimei.pay.config.AliPayProperties;
import com.union.aimei.pay.service.AlibsPayService;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author GaoWei
 * @time 2018/6/2
 * @description
 */
@Service
@CommonsLog
public class AlibsPayServiceImpl implements AlibsPayService {


    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;
    @Resource
    private LearnTradeRecodeFeign learnTradeRecodeFeign;
    @Resource
    private AliPayProperties aliPayProperties;
    @Resource
    private OrderReturnFeign orderReturnFeign;

    /**
     * 支付宝支付合计金额
     *
     * @param tradeType
     * @param tradeVo
     * @param orderBase
     * @param orderGoodsBase
     * @return
     */
    private Integer appPayByTradeType(Integer tradeType, TradeVo tradeVo, OrderBase orderBase, OrderGoodsBase orderGoodsBase) {
        Integer amountTotal = 0;
        if (tradeType == 0) {
            //查询订单状态存在
            orderBase = orderBaseFeign.queryByOrderNo(tradeVo.getOrderNo());
            Optional.ofNullable(orderBase).filter(orderBase1 -> orderBase1 != null).orElseThrow(() -> new ServerException(500, "查询项目订单为空"));
            Integer status = orderBase.getStatus();
            if (status >= OrderBase.OrderStatus.WAIT_SERVER) {
                throw new ResponseException(PayConstant.REPEAT_PAY, PayConstant.REPEAT_PAY_MSG);
            }
            amountTotal = orderBase.getNeedPay().intValue();
        } else if (tradeType == TradeVo.TradeType.BUY_GOODS) {
            ResponseMessage<OrderGoodsBase> orderMsg = orderGoodsBaseFeign.queryByOrderNo(tradeVo.getOrderNo());
            AssertUtil.isRemoteInvokeSuccess(orderMsg);
            orderGoodsBase = orderMsg.getData();
            int status = orderGoodsBase.getStatus();
            if (status >= 1) {
                throw new ServerException(500, PayConstant.REPEAT_PAY_MSG);
            }
            amountTotal = orderGoodsBase.getAmountTotal().intValue();
        } else if (TradeVo.TradeType.BUY_LESSSONS == tradeType || TradeVo.TradeType.BUY_ACTIVITY == tradeType) {
            ResponseMessage<LearnTradeRecode> resMsg = learnTradeRecodeFeign.queryTradeRecodeByOrderNo(tradeVo.getOrderNo());
            AssertUtil.isRemoteInvokeSuccess(resMsg);
            LearnTradeRecode learnTradeRecode = resMsg.getData();
            boolean payStatus = learnTradeRecode.getPayStatus();
            Optional.of(payStatus).filter(stat -> stat == false).orElseThrow(() -> new ServerException(500, "请勿重复支付"));
            amountTotal = learnTradeRecode.getTradeAmount();
        }
        return amountTotal;
    }

    /**
     * 支付宝支付
     *
     * @param tradeVo
     * @param tradeType
     * @param amountTotal
     * @param res
     */
    private void appPayByAlipay(TradeVo tradeVo, Integer tradeType, Integer amountTotal, ResponseMessage<String> res) {
        AlipayClient alipayClient = new DefaultAlipayClient(this.aliPayProperties.getOpenApiDomain(), this.aliPayProperties.getAppid(), this.aliPayProperties.getPrivateKey(), "json", "utf-8", this.aliPayProperties.getAlipayPublicKey(), this.aliPayProperties.getSignType());
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayResponse response;
        String orderNo = tradeVo.getOrderNo();
        log.info("订单编号为：" + orderNo);
        String name = tradeVo.getProductName();
        log.info("交易商品名称为：" + name);
        String str = "";
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("美容邦商家支付宝支付");
        StringBuilder sb = new StringBuilder();
        sb.append(name == null ? "美容邦商品" : name);
        this.appPayByTradeTypeToPassbackParams(model, tradeType);
        double totalAmount = (double) amountTotal / 100;
        log.info("所需支付金额为：" + totalAmount);
        model.setSubject(sb.toString());
        log.info("subject：" + sb.toString());
        model.setOutTradeNo(orderNo);
        model.setTotalAmount(String.valueOf(totalAmount));
        model.setProductCode("QUICK_MSECURITY_PAY");
        log.info("交易Model为：" + model.toString());
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        request.setBizModel(model);
        request.setNotifyUrl(aliPayProperties.getNotifyUrl());
        log.info("HTTP请求：" + request.getBizModel().toString());
        log.info("HTTP请求：" + request.getNotifyUrl().toString());
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            response = alipayClient.sdkExecute(request);
            str = response.getBody();
            log.info("支付宝返回参数为：" + str);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        res.setData(str);
    }

    /**
     * 支付宝支付交易类型转换参数
     *
     * @param model
     * @param tradeType
     */
    private void appPayByTradeTypeToPassbackParams(AlipayTradeAppPayModel model, Integer tradeType) {
        switch (tradeType) {
            case 0:
                model.setPassbackParams("buyProduct");
                break;
            case 1:
                model.setPassbackParams("buyCard");
                break;
            case 2:
                model.setPassbackParams("rechargeCard");
                break;
            case 3:
                model.setPassbackParams("buyGoods");
                break;
            case 4:
                model.setPassbackParams("buyLearns");
                break;
            case 5:
                model.setPassbackParams("buyActivity");
                break;
            default:
                break;
        }
    }

    @Override
    public ResponseMessage<String> appPay(TradeVo tradeVo) {
        log.info("申请支付宝APP支付");
        //交易类型为商品交易并且支付类型为支付宝
        log.info("APP支付对象为:" + tradeVo.toString());
        int tradeType = tradeVo.getTradeType();
        int payType = tradeVo.getPayType();
        boolean isAliPay = (tradeType == 0 || tradeType == 3 || tradeType == 4 || tradeType == 5) && payType == 1;
        ResponseMessage<String> res = new ResponseMessage<>();
        if (isAliPay) {
            OrderBase orderBase = null;
            OrderGoodsBase orderGoodsBase = null;
            int amountTotal = this.appPayByTradeType(tradeType, tradeVo, orderBase, orderGoodsBase);
            if (amountTotal >= 1) {
                tradeVo.setAmountTotal(amountTotal);
            } else {
                throw new ServerException(500, PayConstant.TRADE_AMOUNT_ERROR_MSG);
            }
            this.appPayByAlipay(tradeVo, tradeType, amountTotal, res);
        } else {
            throw new ServerException(500, "请输入正确的支付方式");
        }
        return res;
    }

    @Override
    public ResponseMessage<AlipayTradeRefundResponse> applyRefund(String orderNo) throws AlipayApiException {
        ResponseMessage<RefundObject> res = orderReturnFeign.queryRefundObject(orderNo);
        AssertUtil.isRemoteInvokeSuccess(res);
        RefundObject refundObject = res.getData();
        double refundFee = (double) refundObject.getRefundFee() / 100;
        AlipayClient alipayClient = new DefaultAlipayClient(this.aliPayProperties.getOpenApiDomain(), this.aliPayProperties.getAppid(), this.aliPayProperties.getPrivateKey(), "json", "utf-8", this.aliPayProperties.getAlipayPublicKey(), this.aliPayProperties.getSignType());
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{    \"out_trade_no\":\"" + refundObject.getOutTradeNo() + "\",    \"trade_no\":\"" + refundObject.getTradeNo() + "\",    \"refund_amount\":\"" + refundFee + "\"  }");

        AlipayTradeRefundResponse response = (AlipayTradeRefundResponse) alipayClient.execute(request);
        ResponseMessage<AlipayTradeRefundResponse> responseMessage = new ResponseMessage<>();
        boolean isSuccess = "10000".equals(response.getCode());
        if (!isSuccess) {
            responseMessage.setCode(500);
            responseMessage.setMessage(response.getSubMsg());
        } else {
            responseMessage.setData(response);
        }
        return responseMessage;
    }


}
