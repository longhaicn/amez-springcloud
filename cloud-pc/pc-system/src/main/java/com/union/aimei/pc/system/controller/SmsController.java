package com.union.aimei.pc.system.controller;

import com.aliyuncs.exceptions.ClientException;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.pc.system.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SmsService smsService;

    @ApiOperation("发送短信")
    @PostMapping("/sendSmsCode")
    public int sendSmsMessageCode(@RequestBody SmsMessageVo smsMessageVo) {
        try {
            smsService.sendSmsCode(smsMessageVo);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @ApiOperation("发送短信")
    @PostMapping("/sendSmsCodeList")
    public int sendSmsCodeList(@RequestBody List<SmsMessageVo> list) {
        try {
            smsService.sendSmsCodeList(list);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @ApiOperation("发送短信")
    @PostMapping("/exist/{phone}")
    public boolean exist(@PathVariable("phone") String phone) {
        return smsService.isExist(phone);
    }
}
