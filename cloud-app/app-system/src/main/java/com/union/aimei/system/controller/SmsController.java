package com.union.aimei.system.controller;

import com.aliyuncs.exceptions.ClientException;
import com.union.aimei.system.service.SmsService;
import com.union.aimei.common.vo.system.SmsMessageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SmsController
 *
 * @author liufeihua
 * @date 2017/12/27 15:22
 */
@Api(tags = "发送短信", description = "api")
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    SmsService smsService;

    @ApiOperation("发送短信")
    @PostMapping("/sendSmsCode")
    public int sendSmsMessage(@RequestBody SmsMessageVo smsMessageVo) {
        try {
            smsService.sendSmsCode(smsMessageVo);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @ApiOperation("批量发送短信")
    @PostMapping("/sendSmsCodeList")
    public int sendSmsCodeList(@RequestBody List<SmsMessageVo> list) {
        try {
            smsService.sendSmsCodeList(list);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
