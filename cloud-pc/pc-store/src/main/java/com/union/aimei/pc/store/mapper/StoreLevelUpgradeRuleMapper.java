package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreLevelUpgradeRuleByBatchVo;
import com.union.common.utils.base.BaseMapper;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
public interface StoreLevelUpgradeRuleMapper extends BaseMapper<StoreLevelUpgradeRule> {

    /**
     * 删除所有店铺成长值规则设置
     *
     * @return
     */
    int deleteByAll();

    /**
     * 批量添加店铺成长值规则设置
     *
     * @param storeLevelUpgradeRuleByBatchVo
     * @return
     */
    int addByBatch(StoreLevelUpgradeRuleByBatchVo storeLevelUpgradeRuleByBatchVo);

}