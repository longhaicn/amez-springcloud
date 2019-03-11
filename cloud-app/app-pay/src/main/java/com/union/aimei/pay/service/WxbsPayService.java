package com.union.aimei.pay.service;

import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;

/**
 * @author GaoWei
 * @time 2018/6/1 18:35
 * @description 微信业务操作Service
 */
public interface WxbsPayService {


    /**
     * 微信统一下单
     * @param tradeVo
     * @return
     * @throws WxPayException
     */
    ResponseMessage unifiedOrder(TradeVo tradeVo)throws WxPayException;

    /**
     * 微信申请退款
     * @param paySource
     * @param orderNo
     * @return
     * @throws WxPayException
     */
     ResponseMessage<WxPayRefundResult> refund(int paySource,String orderNo)throws WxPayException;
}
