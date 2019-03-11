package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.common.utils.base.BaseMapper;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,10:45
*/
public interface MemberCardTradeRecodeMapper extends BaseMapper<MemberCardTradeRecode> {

    /**
     * 根据订单编号查询
     * @param orderNo
     * @return
     */
    MemberCardTradeRecode queryByOrderNo(String orderNo);
}