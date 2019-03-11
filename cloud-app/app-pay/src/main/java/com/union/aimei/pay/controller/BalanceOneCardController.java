package com.union.aimei.pay.controller;


import com.union.aimei.pay.service.BalanceOneCardService;
import com.union.aimei.remote.model.RefundParamVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author GaoWei
 * @describe 余额支付Controller
 * @time 2018/1/30,15:42
 */
@RestController
@Api(tags = "余额/一卡通支付")
@RequestMapping(value = "/balance")
public class BalanceOneCardController {

    @Resource
    private BalanceOneCardService balanceOneCardService;

    /**
     * 余额/一卡通支付
     * @param tradeVo
     * @return
     */
    @PostMapping(value = "/pay")
    public ResponseMessage balancePay(@RequestBody TradeVo tradeVo){
       return balanceOneCardService.balanceOneCardPay(tradeVo);
    }


    /**
     * 余额/一卡通退款
     * @param vo
     * @return
     */
    @PostMapping(value = "/refund")
    public ResponseMessage refund(@RequestBody RefundParamVo vo){
        return balanceOneCardService.refund(vo);
    }
 }
