package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.GrowthRuleLog;
import com.union.aimei.store.mapper.GrowthRuleLogMapper;
import com.union.aimei.store.service.GrowthRuleLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Service("growthRuleLogService")
public class GrowthRuleLogServiceImpl implements GrowthRuleLogService {
    @Resource
    private GrowthRuleLogMapper growthRuleLogMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<GrowthRuleLog> list = this.growthRuleLogMapper.selectListByConditions(growthRuleLog);
        PageInfo<GrowthRuleLog> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加成长规则日志表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(GrowthRuleLog t) {
        return this.growthRuleLogMapper.insertSelective(t);
    }

    /**
     * 删除成长规则日志表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.growthRuleLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改成长规则日志表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(GrowthRuleLog t) {
        return this.growthRuleLogMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returngrowthRuleLog
     */
    @Override
    public GrowthRuleLog queryObjById(int id) {
        GrowthRuleLog model = this.growthRuleLogMapper.selectByPrimaryKey(id);
        return model;
    }
}