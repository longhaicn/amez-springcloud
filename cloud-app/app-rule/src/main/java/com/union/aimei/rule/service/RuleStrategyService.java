package com.union.aimei.rule.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleStrategy;
import com.union.common.utils.ResponseMessage;

/**
 * 规则策略
 *
 * @author liurenkai
 * @time 2018/5/10 17:29
 */
public interface RuleStrategyService {
    /**
     * 分页查询规则策略
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param ruleStrategy 查询条件
     * @return
     */
    ResponseMessage<PageInfo<RuleStrategy>> findByPageForFront(Integer pageNo, Integer pageSize, RuleStrategy ruleStrategy);
}