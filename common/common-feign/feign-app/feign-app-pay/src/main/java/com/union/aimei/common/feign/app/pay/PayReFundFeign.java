package com.union.aimei.common.feign.app.pay;

import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.union.aimei.common.feign.app.pay.hystrix.PayReFundHystrix;
import com.union.aimei.common.vo.pay.RefundParamVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author GaoWei
 * @time 2018/6/22 10:49
 * @description
 */
@FeignClient(serviceId = "APP-PAY-SERVICE", fallback = PayReFundHystrix.class)
public interface PayReFundFeign {

    /**
     * <pre>
     * 微信支付-申请退款
     * 详见 https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_4
     * 接口链接：https://api.mch.weixin.qq.com/secapi/pay/refund
     * </pre>
     *
     * @param paySource 支付来源
     * @param orderNo   订单编号
     * @return 退款操作结果
     */
    @GetMapping(value = "/wx/pay/refund/{paySource}/{orderNo}")
    ResponseMessage<WxPayRefundResult> refund(@PathVariable(value = "paySource") int paySource,
                                              @PathVariable(value = "orderNo") String orderNo);

    /**
     * 支付宝支付退款
     *
     * @param orderNo 订单编号
     * @return
     */
    @GetMapping(value = "/alipay/refund/{orderNo}")
    ResponseMessage<AlipayTradeRefundResponse> tradeRefund(@PathVariable(value = "orderNo") String orderNo);


    /**
     * 余额/一卡通退款
     *
     * @param vo
     * @return
     */
    @PostMapping(value = "/balance/refund")
    ResponseMessage refund(@RequestBody RefundParamVo vo);
}
