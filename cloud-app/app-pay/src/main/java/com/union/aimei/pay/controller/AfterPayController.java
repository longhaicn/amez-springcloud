package com.union.aimei.pay.controller;

import com.union.aimei.pay.task.PayCompensate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @time 2018/6/11 10:07
 * @description 支付成功controller，用于pc-api定时器调用
 */
@RestController
@RequestMapping(value = "/afterPay")
public class AfterPayController {

    @Resource
    private PayCompensate payCompensate;

    @GetMapping(value = "/invoke")
    public void invokeAfterPayBusiness(){
        payCompensate.orderPaySuccessCompensateTask();
    }
}
