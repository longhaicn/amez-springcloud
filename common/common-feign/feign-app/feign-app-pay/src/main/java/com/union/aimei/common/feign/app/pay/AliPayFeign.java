package com.union.aimei.common.feign.app.pay;


/**
 * @author GaoWei
 * @describe 支付宝支付Feign
 * @time 2017/12/20,16:59
 */


import com.alipay.api.response.AlipayTradeRefundResponse;
import com.union.aimei.common.feign.app.pay.hystrix.AliPayHystrix;
import com.union.aimei.common.vo.pay.AlipayNotifyVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(serviceId = "APP-PAY-SERVICE",fallback = AliPayHystrix.class)
public interface AliPayFeign {

    /**
     * 获取调用支付宝返回body
     * @param tradeVo
     * @return
     */
    @PostMapping(value = "/alipay/appPay")
    ResponseMessage<String> appPayReturnBody(@RequestBody TradeVo tradeVo);


    /**
     * 申请退款
     * @param orderNo
     * @return
     */
    @GetMapping(value ="/alipay/refund/{orderNo}")
    ResponseMessage<AlipayTradeRefundResponse> tradeRefund(@PathVariable(value = "orderNo") String orderNo);

    /**
     * 支付回调接口
     * @param vo
     * @return
     */
    @PostMapping(value = "/alipay/notify")
    String notifyResult(@RequestBody AlipayNotifyVo vo);

}
