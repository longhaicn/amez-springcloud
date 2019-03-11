package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.common.utils.base.BaseMapper;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2017/12/27 15:59
 */
public interface StoreLevelUpgradeRuleMapper extends BaseMapper<StoreLevelUpgradeRule> {

    /**
     * 删除所有店铺成长值规则设置
     * @return
     */
    int deleteForAll();

}