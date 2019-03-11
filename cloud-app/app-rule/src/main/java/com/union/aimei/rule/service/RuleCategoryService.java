package com.union.aimei.rule.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleCategory;
import com.union.common.utils.ResponseMessage;

/**
 * 规则分类
 *
 * @author liurenkai
 * @time 2018/5/10 17:29
 */
public interface RuleCategoryService {
    /**
     * 分页查询规则分类
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param ruleCategory 查询条件
     * @return
     */
    ResponseMessage<PageInfo<RuleCategory>> findByPageForFront(Integer pageNo, Integer pageSize, RuleCategory ruleCategory);
}