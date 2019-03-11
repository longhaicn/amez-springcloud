package com.union.aimei.common.feign.app.pay.hystrix;

import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.union.aimei.common.feign.app.pay.WxPayFeign;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 微信支付
 *
 * @author GaoWei
 * @time 2018/8/23 10:42
 */
@Component(value = "app-WxPayFeign")
public class WxPayHystrix implements WxPayFeign {
    @Override
    public ResponseMessage unifiedOrder(TradeVo tradeVo) throws WxPayException {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<WxPayRefundResult> refund(int paySource, String orderNo) throws WxPayException {
        return HystrixResponse.invokeFail();
    }

    @Override
    public String callBackUrl(String xmlData) {
        return "FAIL";
    }
}
