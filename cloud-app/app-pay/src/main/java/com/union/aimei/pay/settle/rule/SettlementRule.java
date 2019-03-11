package com.union.aimei.pay.settle.rule;


import com.union.aimei.common.vo.pay.SettlementVo;

import java.util.Map;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:49
  * @description
  */
public interface SettlementRule {


    /**
     * 计算收益
     * @param settlementVo
     * @return
     */
    Map<String,Integer> calculateCommission(SettlementVo settlementVo);


}
