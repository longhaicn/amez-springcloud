package com.union.aimei.common.feign.pc.system;

import com.union.aimei.common.feign.pc.system.hystrix.SendSmsHystrix;
import com.union.aimei.common.vo.system.SmsMessageVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * SendSmsFeign
 *
 * @author liufeihua
 * @date 2018/1/10 16:55
 */
@FeignClient(name = "pc-system-service", fallback = SendSmsHystrix.class)
public interface SendSmsFeign {

    /**
     * 发送短信
     * @param smsMessageVo
     * @return
     */
    @PostMapping(value = "/sms/sendSmsCode")
    int sendSmsMessageCode(@RequestBody SmsMessageVo smsMessageVo);


    /**
     * 批量发送短信
     *
     * @param smsMessageVo
     * @return
     */
    @PostMapping(value = "/sms/sendSmsCodeList")
    int sendSmsCodeList(List<SmsMessageVo> smsMessageVo);
}
