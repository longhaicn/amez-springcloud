package com.union.aimei.rule.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleAction;
import com.union.common.utils.ResponseMessage;

/**
 * 规则行为
 *
 * @author liurenkai
 * @time 2018/5/10 17:28
 */
public interface RuleActionService {
    /**
     * 分页查询规则行为
     *
     * @param pageNo     分页索引
     * @param pageSize   每页数量
     * @param ruleAction 查询条件
     * @return
     */
    ResponseMessage<PageInfo<RuleAction>> findByPageForFront(Integer pageNo, Integer pageSize, RuleAction ruleAction);
}