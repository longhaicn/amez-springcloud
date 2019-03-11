package com.union.aimei.common.feign.app.pay.hystrix;

import com.union.aimei.common.feign.app.pay.BalanceOneCardFeign;
import com.union.aimei.remote.model.RefundParamVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * @author GaoWei
 * @time 2018/6/4 15:35
 * @description
 */
@Component(value = "app-BalanceOneCardFeign")
public class BalanceOneCardHystrix implements BalanceOneCardFeign {

    @Override
    public ResponseMessage balancePay(TradeVo tradeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage refund(RefundParamVo vo) {
        return HystrixResponse.invokeFail();
    }
}
