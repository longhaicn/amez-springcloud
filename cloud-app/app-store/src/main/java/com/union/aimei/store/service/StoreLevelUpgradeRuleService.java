package com.union.aimei.store.service;

import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.common.vo.store.app.StoreLevelUpgradeRuleVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2017/12/27 15:52
 */
public interface StoreLevelUpgradeRuleService {

    /**
     * 新增店铺成长值规则设置
     *
     * @param storeLevelUpgradeRuleVo 店铺成长值规则设置vo
     * @return
     */
    ResponseMessage add(StoreLevelUpgradeRuleVo storeLevelUpgradeRuleVo);

    /**
     * 查询店铺成长值规则设置
     *
     * @return
     */
    ResponseMessage<List<StoreLevelUpgradeRule>> findList();

}