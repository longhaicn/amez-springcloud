package com.union.aimei.pay.service;

import com.union.aimei.remote.model.RefundParamVo;
import com.union.aimei.remote.model.TradeVo;
import com.union.common.utils.ResponseMessage;

/**
 * @author GaoWei
 * @time 2018/6/8 16:40
 * @description 余额一卡通
 */
public interface BalanceOneCardService {

    /**
     * 余额/一卡通支付
     * @param tradeVo
     * @return
     */
    ResponseMessage balanceOneCardPay(TradeVo tradeVo);

    /**
     * 余额/一卡通退款
     * @param vo
     * @return
     */
    ResponseMessage refund(RefundParamVo vo);
}
