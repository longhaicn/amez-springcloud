package com.union.aimei.app.api.system;

import com.union.aimei.common.feign.app.system.SendSmsFeign;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.common.utils.ResponseMessage;
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

    @Autowired(required = false)
    SendSmsFeign sendSmsFeign;

    @ApiOperation("发送短信")
    @PostMapping("/sendSmsCode")
    public ResponseMessage<Integer> sendSmsMessage(@RequestBody SmsMessageVo smsMessageVo) {

        return new ResponseMessage<>(sendSmsFeign.sendSmsMessage(smsMessageVo));
    }

    @ApiOperation("批量发送短信")
    @PostMapping("/sendSmsCodeList")
    public ResponseMessage<Integer> sendSmsCodeList(@RequestBody List<SmsMessageVo> smsMessageVo) {

        return new ResponseMessage<>(sendSmsFeign.sendSmsCodeList(smsMessageVo));
    }

}
