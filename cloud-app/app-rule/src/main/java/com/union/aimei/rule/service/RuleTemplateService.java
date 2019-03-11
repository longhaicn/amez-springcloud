package com.union.aimei.rule.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleTemplate;
import com.union.common.utils.ResponseMessage;

/**
 * 规则模板
 *
 * @author liurenkai
 * @time 2018/5/10 17:30
 */
public interface RuleTemplateService {
    /**
     * 分页查询规则模板
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param ruleTemplate 查询条件
     * @return
     */
    ResponseMessage<PageInfo<RuleTemplate>> findByPageForFront(Integer pageNo, Integer pageSize, RuleTemplate ruleTemplate);
}