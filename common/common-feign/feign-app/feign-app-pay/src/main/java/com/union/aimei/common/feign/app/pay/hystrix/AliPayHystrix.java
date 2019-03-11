package com.union.aimei.common.feign.app.pay.hystrix;

import com.alipay.api.response.AlipayTradeRefundResponse;
import com.union.aimei.common.feign.app.pay.AliPayFeign;
import com.union.aimei.common.vo.pay.AlipayNotifyVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * @author GaoWei
 * @describe 支付宝支付服务降级
 * @time 2017/12/20,17:00
 */
@Component(value = "app-AliPayFeign")
public class AliPayHystrix implements AliPayFeign {

    @Override
    public ResponseMessage<String> appPayReturnBody(TradeVo tradeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<AlipayTradeRefundResponse> tradeRefund(String orderNo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public String notifyResult(AlipayNotifyVo vo) {
        return "failed";
    }
}
