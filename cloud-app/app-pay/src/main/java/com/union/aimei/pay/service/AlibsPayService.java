package com.union.aimei.pay.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;

/**
 * @author GaoWei
 * @time 2018/6/2
 * @description 支付宝业务service接口
 */
public interface AlibsPayService {


    /**
     * 支付宝支付appPay
     * @param tradeVo
     * @return
     */
    ResponseMessage<String> appPay(TradeVo tradeVo);


    /**
     * 支付宝申请退款
     * @param orderNo
     * @return
     * @throws AlipayApiException
     */
    ResponseMessage<AlipayTradeRefundResponse> applyRefund(String orderNo)throws AlipayApiException;
}
