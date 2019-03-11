package com.union.aimei.common.feign.app.pay.hystrix;

import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.union.aimei.common.feign.app.pay.PayReFundFeign;
import com.union.aimei.common.vo.pay.RefundParamVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

/**
 * @author GaoWei
 * @time 2018/6/22 10:49
 * @description
 */
@Component
public class PayReFundHystrix implements PayReFundFeign {

    @Override
    public ResponseMessage<WxPayRefundResult> refund(int paySource, String orderNo) {
        throw new ServerException(500, "服务器或网络不稳定");
    }

    @Override
    public ResponseMessage<AlipayTradeRefundResponse> tradeRefund(String orderNo) {
        throw new ServerException(500, "服务器或网络不稳定");
    }

    @Override
    public ResponseMessage refund(RefundParamVo vo) {
        throw new ServerException(500, "服务器或网络不稳定");
    }
}
