package com.union.aimei.pay.service;


import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.common.utils.ResponseMessage;

/**
 * @author GaoWei
 * @describe  支付成功后续操作
 * @time 2018/5/21,14:06
*/
public interface AfterPayService {

    /**
     * 成功支付费用后续操作
     * @param payReturnVo
     * @return
     */
    ResponseMessage hasPaySuccess(PayReturnVo payReturnVo);
}
