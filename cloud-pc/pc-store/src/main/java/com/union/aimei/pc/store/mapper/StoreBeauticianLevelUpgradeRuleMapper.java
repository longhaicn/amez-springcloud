package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelUpgradeRuleByBatchVo;
import com.union.common.utils.base.BaseMapper;

/**
 * 美容师成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreBeauticianLevelUpgradeRuleMapper extends BaseMapper<StoreBeauticianLevelUpgradeRule> {

    /**
     * 删除所有美容师成长值规则设置
     *
     * @return
     */
    int deleteByAll();

    /**
     * 批量添加美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRuleByBatchVo
     * @return
     */
    int addByBatch(StoreBeauticianLevelUpgradeRuleByBatchVo storeBeauticianLevelUpgradeRuleByBatchVo);

}