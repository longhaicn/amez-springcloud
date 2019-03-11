package com.union.aimei.common.feign.app.pay;


import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.union.aimei.common.feign.app.pay.hystrix.WxPayHystrix;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author GaoWei
 * @describe 微信支付Feign
 * @time 2017/12/19,15:41
 */
@FeignClient(serviceId = "APP-PAY-SERVICE", fallback = WxPayHystrix.class)
public interface WxPayFeign {

    /**
     * 微信统一下单
     *
     * @param tradeVo
     * @return
     * @throws WxPayException
     */
    @PostMapping("/wx/pay/unifiedOrder")
    ResponseMessage unifiedOrder(@RequestBody TradeVo tradeVo) throws WxPayException;

    /**
     * 微信申请退款
     * @param paySource
     * @param orderNo
     * @return
     * @throws WxPayException
     */
    @GetMapping(value = "/wx/pay/refund/{paySource}/{orderNo}")
    ResponseMessage<WxPayRefundResult> refund(@PathVariable(value = "paySource") int paySource, @PathVariable(value = "orderNo") String orderNo) throws WxPayException ;

    /**
     * 微信支付回调
     * @param xmlData
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "微信支付回调")
    @PostMapping(value = "/wx/pay/notify")
    String callBackUrl(@RequestBody String xmlData);

}
