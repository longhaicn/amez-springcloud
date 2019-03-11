package com.union.aimei.rule.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleItem;
import com.union.common.utils.ResponseMessage;

/**
 * 规则项
 *
 * @author liurenkai
 * @time 2018/5/10 17:29
 */
public interface RuleItemService {
    /**
     * 分页查询规则项
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param ruleItem 查询条件
     * @return
     */
    ResponseMessage<PageInfo<RuleItem>> findByPageForFront(Integer pageNo, Integer pageSize, RuleItem ruleItem);
}