package com.union.aimei.pc.store.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.GrowthRuleLog;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public interface GrowthRuleLogService extends SpringCloudBaseService<GrowthRuleLog> {
    /**
     * 前端分页查询成长规则日志表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param growthRuleLog 查询条件
     * @return
     */
    PageInfo<GrowthRuleLog> findByPageForFront(Integer pageNo, Integer pageSize, GrowthRuleLog growthRuleLog);
}