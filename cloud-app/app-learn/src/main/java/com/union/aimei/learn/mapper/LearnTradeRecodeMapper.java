package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.common.utils.base.BaseMapper;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface LearnTradeRecodeMapper extends BaseMapper<LearnTradeRecode> {

    /**
     * 根据订单编号查询订单交易记录
     * @param orderNo
     * @return
     */
    LearnTradeRecode queryTradeRecodeByOrderNo(String orderNo);

    /**
     * 支付成功回调方法，根据订单编号更改订单状态和其他信息
     * @param learnTradeRecode
     * @return
     */
    int updateByOrderNo(LearnTradeRecode learnTradeRecode);
}