package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelUpgradeRuleByBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 美容师成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreBeauticianLevelUpgradeRuleService extends SpringCloudBaseService<StoreBeauticianLevelUpgradeRule> {
    /**
     * 分页查询美容师成长值规则设置
     *
     * @param pageNo                          分页索引
     * @param pageSize                        每页数量
     * @param storeBeauticianLevelUpgradeRule 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeauticianLevelUpgradeRule>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule);

    /**
     * 批量添加美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRuleByBatchVo
     * @return
     */
    ResponseMessage addByBatch(StoreBeauticianLevelUpgradeRuleByBatchVo storeBeauticianLevelUpgradeRuleByBatchVo);

    /**
     * 查询所有美容师成长值规则设置
     *
     * @return
     */
    ResponseMessage<List<StoreBeauticianLevelUpgradeRule>> findListByAll();

}