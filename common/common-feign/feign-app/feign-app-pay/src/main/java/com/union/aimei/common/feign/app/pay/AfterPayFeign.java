package com.union.aimei.common.feign.app.pay;

import com.union.aimei.common.feign.app.pay.hystrix.AfterPayHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author GaoWei
 * @time 2018/6/11 10:26
 * @description
 */
@FeignClient(serviceId = "APP-PAY-SERVICE", fallback = AfterPayHystrix.class)
public interface AfterPayFeign {

    /**
     * 调起支付业务
     */
    @GetMapping(value = "/afterPay/invoke")
    void invokeAfterPayBusiness();
}
