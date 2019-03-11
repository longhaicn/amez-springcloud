package com.union.aimei.common.feign.app.pay;

import com.union.aimei.common.feign.app.pay.hystrix.BalanceOneCardHystrix;
import com.union.aimei.remote.model.RefundParamVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author GaoWei
 * @time 2018/6/4 15:34
 * @description
 */
@FeignClient(serviceId = "APP-PAY-SERVICE", fallback = BalanceOneCardHystrix.class)
public interface BalanceOneCardFeign {

    /**
     * 余额/一卡通支付
     *
     * @param tradeVo
     * @return
     */
    @PostMapping(value = "/balance/pay")
    ResponseMessage balancePay(@RequestBody TradeVo tradeVo);

    /**
     * 余额/一卡通退款
     *
     * @param vo
     * @return
     */
    @PostMapping(value = "/balance/refund")
    ResponseMessage refund(@RequestBody RefundParamVo vo);
}
