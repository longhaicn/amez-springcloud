package com.union.aimei.rule.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleLevel;
import com.union.common.utils.ResponseMessage;

/**
 * 规则等级
 *
 * @author liurenkai
 * @time 2018/5/10 17:29
 */
public interface RuleLevelService {
    /**
     * 分页查询规则等级
     *
     * @param pageNo    分页索引
     * @param pageSize  每页显示数量
     * @param ruleLevel 查询条件
     * @return
     */
    ResponseMessage<PageInfo<RuleLevel>> findByPageForFront(Integer pageNo, Integer pageSize, RuleLevel ruleLevel);
}