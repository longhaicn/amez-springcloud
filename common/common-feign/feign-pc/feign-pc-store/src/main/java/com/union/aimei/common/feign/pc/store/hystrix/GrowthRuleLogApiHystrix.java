package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.GrowthRuleLogFeign;
import com.union.aimei.common.model.store.GrowthRuleLog;
import org.springframework.stereotype.Component;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Component(value = "pc-GrowthRuleLogFeign")
public class GrowthRuleLogApiHystrix implements GrowthRuleLogFeign {

    /**
     * 前端分页查询成长规则日志表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param growthRuleLog 查询条件
     * @return
     */
    @Override
    public PageInfo<GrowthRuleLog> findByPageForFront(Integer pageNo, Integer pageSize, GrowthRuleLog growthRuleLog) {
        return null;
    }

    /**
     * 添加成长规则日志表
     *
     * @param growthRuleLog
     * @return
     */
    @Override
    public int insert(GrowthRuleLog growthRuleLog) {
        return 0;
    }

    /**
     * 删除成长规则日志表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改成长规则日志表
     *
     * @param growthRuleLog
     * @return
     */
    @Override
    public int edit(GrowthRuleLog growthRuleLog) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returngrowthRuleLog
     */
    @Override
    public GrowthRuleLog queryById(int id) {
        return null;
    }
}