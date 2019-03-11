package com.union.aimei.app.api.pay;


import com.union.aimei.common.feign.app.pay.BalanceOneCardFeign;
import com.union.aimei.remote.model.RefundParamVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    private BalanceOneCardFeign balanceOneCardFeign;

    /**
     * 余额/一卡通支付
     * @param tradeVo
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "余额/一卡通支付")
    @PostMapping(value = "/pay")
    public ResponseMessage balancePay(@RequestBody TradeVo tradeVo){
        return balanceOneCardFeign.balancePay(tradeVo);
    }



    /**
     * 余额/一卡通退款
     * @param vo
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "余额/一卡通退款")
    @PostMapping(value = "/refund")
    public ResponseMessage refund(@RequestBody RefundParamVo vo){
        return balanceOneCardFeign.refund(vo);
    }
}
