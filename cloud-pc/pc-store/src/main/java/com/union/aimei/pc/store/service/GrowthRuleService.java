package com.union.aimei.pc.store.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.GrowthRule;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public interface GrowthRuleService extends SpringCloudBaseService<GrowthRule> {
    /**
     * 前端分页查询成长规则
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param growthRule 查询条件
     * @return
     */
    PageInfo<GrowthRule> findByPageForFront(Integer pageNo, Integer pageSize, GrowthRule growthRule);

    /**
     * 校验编码是否重复
     *
     * @param ruleType
     * @param code
     * @return
     */
    ResponseMessage checkCode(byte ruleType, String code);

    /**
     * 保存成长规则
     *
     * @param growthRule
     * @return
     */
    ResponseMessage saveGrowthRule(GrowthRule growthRule);

    /**
     * 修改成长规则
     *
     * @param growthRule
     * @return
     */
    ResponseMessage editGrowthRule(GrowthRule growthRule);

    /**
     * 保存门店、美容师成长值(v1.1.1)
     *
     * @param growthRuleVo
     * @return
     */
    ResponseMessage saveGrowthRuleV111(GrowthRuleVo growthRuleVo);

    /**
     * 批量保存门店、美容师成长值(v1.1.1)
     *
     * @param growthRuleVoList
     * @return
     */
    ResponseMessage saveBatchGrowthRuleV111(List<GrowthRuleVo> growthRuleVoList);

}