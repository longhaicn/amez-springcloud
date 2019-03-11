package com.union.aimei.common.feign.app.system;

import com.union.aimei.common.feign.app.system.hystrix.SendSmsHystrix;
import com.union.aimei.common.vo.system.SmsMessageVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "app-system-service", fallback = SendSmsHystrix.class)
public interface SendSmsFeign {

    /**
     * v短信
     * @param smsMessageVo
     * @return
     */
    @PostMapping(value = "/sms/sendSmsCode")
    int sendSmsMessage(@RequestBody SmsMessageVo smsMessageVo);

    /**
     * 批量发送短信
     *
     * @param smsMessageVo
     * @return
     */
    @PostMapping(value = "/sms/sendSmsCodeList")
    int sendSmsCodeList(List<SmsMessageVo> smsMessageVo);
}
