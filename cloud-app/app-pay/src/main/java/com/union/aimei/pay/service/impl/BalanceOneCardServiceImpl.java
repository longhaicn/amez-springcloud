package com.union.aimei.pay.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.pay.PayConstant;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.aimei.pay.service.AfterPayService;
import com.union.aimei.pay.service.BalanceOneCardService;
import com.union.aimei.remote.AmezResponse;
import com.union.aimei.remote.model.PayRecordVo;
import com.union.aimei.remote.model.RefundParamVo;
import com.union.aimei.remote.model.ResultVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @time 2018/6/8 16:42
 * @description
 */
@Service
@CommonsLog
public class BalanceOneCardServiceImpl implements BalanceOneCardService {

    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private AfterPayService afterPayService;
    @Resource
    private AmezResponse amezResponse;

    /**
     * 支付创建艾美平台订单
     *
     * @param token
     * @param tradeVo
     * @param payPrice
     * @param orderBase
     * @return
     */
    private Double payByCreateAmezPlatOrder(String token, TradeVo tradeVo, Double payPrice, OrderBase orderBase) {
        double payCardDiscountRate = 0;
        ResultVo<PayRecordVo> resultVo = amezResponse.createAmezPlatOrder(token, tradeVo, payPrice);
        boolean createAmOrderNo = "SUCCESS".equals(resultVo.getStatus().name());
        if (createAmOrderNo) {
            PayRecordVo payRecordVo = resultVo.getData();
            payCardDiscountRate = payRecordVo.getPayCardDiscountRate();
            log.info("艾美返一卡通折扣比例：" + payCardDiscountRate);
            //艾美平台订单类型
            String payRecordNo = payRecordVo.getPayRecordNo();
            //更新订单表
            orderBase.setTradeNo(payRecordNo);
            if (tradeVo.getPayType() == TradeVo.PayType.ONE_CARD_PAY) {
                orderBase.setCardId(tradeVo.getAmPayCardId());
            }
            int result = orderBaseFeign.edit(orderBase);
            AssertUtil.isRemoteInvokeNum(result);
        } else {
            throw new ServerException(resultVo.getCode(), resultVo.getMsg());
        }
        return payCardDiscountRate;
    }

    /**
     * 支付结果
     *
     * @param tradeVo
     * @param payRecordNo
     * @param token
     * @param payCardDiscountRate
     * @param amountPay
     */
    private void payByResult(TradeVo tradeVo, String payRecordNo, String token, Double payCardDiscountRate, Integer amountPay) {
        String payResult = amezResponse.getPreResult(tradeVo.getOrderNo(), payRecordNo, tradeVo.getPayPassword(), token, tradeVo.getPayType(), tradeVo.getAmUserId());
        log.info("支付结果：" + payRecordNo);
        JsonObject jsonObject = new Gson().fromJson(payResult, JsonObject.class);
        boolean getPayReturn = "SUCCESS".equals(jsonObject.get("status").getAsString());
        log.info("获取支付结果" + getPayReturn);
        if (getPayReturn) {
            String result = jsonObject.get("data").getAsJsonObject().get("result").getAsString();
            boolean isTrue = "true".equals(result);
            int oneCardReduce = 0;
            int oneCardDiscount = (int) (payCardDiscountRate * 100);
            log.info("一卡通折扣比例：" + oneCardDiscount);
            if (isTrue) {
                int type = tradeVo.getPayType();
                //如果是一卡通支付则获取返回的实际支付金额
                if (TradeVo.PayType.ONE_CARD_PAY == type) {
                    JsonObject dataJson = jsonObject.get("data").getAsJsonObject();
                    //获取一卡通支付折扣
                    JsonObject json;
                    if (dataJson != null) {
                        JsonElement isExsit = dataJson.get("platformOrder");
                        if (isExsit != null) {
                            json = dataJson.get("platformOrder").getAsJsonObject();
                            double actural = json.get("payPrice").getAsDouble();
                            double oneCardReduceDou = json.get("oneCardDiscountMoney").getAsDouble();
                            amountPay = (int) (actural * 100);
                            oneCardReduce = (int) (oneCardReduceDou * 100);
                            log.info("一卡通减免金额:" + oneCardReduce);
                        } else {
                            throw new ServerException(500, "请勿重复支付");
                        }
                    } else {
                        throw new ServerException(500, "支付异常,请稍后重试");
                    }
                }
                log.info("实际支付金额：" + amountPay);
                //支付类型(传递入数据库为4则为一卡通，5则为余额支付)
                Integer payType = type == 3 ? 4 : 5;
                //更新订单状态
                PayReturnVo vo = PayReturnVo.builder()
                        .orderNo(tradeVo.getOrderNo())
                        .payType(payType)
                        .tradeNo(payRecordNo)
                        .amountPay(amountPay)
                        .payUseType(0)
                        .oneCardDiscount(oneCardDiscount)
                        .reduceAmount(oneCardReduce)
                        .build();
                updateOrderStatus(vo);
                afterPayService.hasPaySuccess(vo);
            } else {
                throw new ServerException(PayConstant.AM_PAY_FAIL, PayConstant.AM_PAY_FAIL_MSG);
            }
        } else {
            throw new ServerException(PayConstant.GET_AMORDERINFO_FAIL, jsonObject.get("msg").getAsString());
        }
    }

    @Override
    public ResponseMessage balanceOneCardPay(TradeVo tradeVo) {
        ResponseMessage res = new ResponseMessage();
        String orderNo = tradeVo.getOrderNo();
        OrderBase orderBase = orderBaseFeign.queryByOrderNo(orderNo);
        if (orderBase == null) {
            throw new ServerException(500, "查询订单信息为空");
        }
        Integer status = orderBase.getStatus();
        if (status.intValue() != 0) {
            throw new ServerException(500, "订单已支付或者关闭");
        }
        Integer amountPay = orderBase.getNeedPay();
        double payPrice = (double) amountPay / 100;
        log.info("应付金额为：" + payPrice);
        //1:获取网关token
        String token = amezResponse.getAccessToken();
        log.info("请求网关为：" + token);
        if (StringUtils.isBlank(token)) {
            throw new ServerException(PayConstant.REQUEST_AM_TOKEN_FAIL, PayConstant.REQUEST_AM_TOKEN_FAIL_MSG);
        } else {
            String payRecordNo = orderBase.getTradeNo();
            double payCardDiscountRate = 0;
            if (StringUtils.isBlank(payRecordNo)) {
                //2:调用艾美接口生成订单,获取艾美商城订单
                payCardDiscountRate = this.payByCreateAmezPlatOrder(token, tradeVo, payPrice, orderBase);
                payRecordNo = orderBase.getTradeNo();
            }
            log.info("支付订单号为：" + payRecordNo);
            this.payByResult(tradeVo, payRecordNo, token, payCardDiscountRate, amountPay);
        }
        return res;
    }


    /**
     * 修改订单状态为已支付
     *
     * @param returnVo
     */
    private void updateOrderStatus(PayReturnVo returnVo) {
        int payUseType = returnVo.getPayUseType();
        log.info("购买类型为；" + payUseType);
        switch (payUseType) {
            case 0:
                ResponseMessage res = orderBaseFeign.updateStateAfterPay(returnVo);
                if (res.getCode() == HttpStatusConstant.OK.getStatus()) {
                    log.warn("项目订单状态已更新为支付成功");
                } else {
                    log.warn("项目订单状态未更新");
                }
                ;
                break;
            default:
                ;
                break;
        }
    }


    /**
     * 退款
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseMessage refund(RefundParamVo vo) {
        return amezResponse.refund(vo);
    }
}
