package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreLevelUpgradeRuleByBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
public interface StoreLevelUpgradeRuleService extends SpringCloudBaseService<StoreLevelUpgradeRule> {
    /**
     * 分页查询店铺成长值规则设置
     *
     * @param pageNo                分页索引
     * @param pageSize              每页数量
     * @param storeLevelUpgradeRule 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreLevelUpgradeRule>> findByPageForFront(Integer pageNo, Integer pageSize, StoreLevelUpgradeRule storeLevelUpgradeRule);

    /**
     * 批量添加店铺成长值规则设置
     *
     * @param storeLevelUpgradeRuleByBatchVo
     * @return
     */
    ResponseMessage addByBatch(StoreLevelUpgradeRuleByBatchVo storeLevelUpgradeRuleByBatchVo);

    /**
     * 查询店铺成长值规则设置
     *
     * @return
     */
    ResponseMessage<List<StoreLevelUpgradeRule>> findListByAll();

}