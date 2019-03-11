package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseScheduleJob;
import com.union.aimei.pc.system.mapper.BaseScheduleJobMapper;
import com.union.aimei.pc.system.service.BaseScheduleJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseScheduleJobServiceImpl implements BaseScheduleJobService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseScheduleJobMapper baseScheduleJobMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseScheduleJobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseScheduleJob record) {
        return this.baseScheduleJobMapper.insertSelective(record);
    }

    @Override
    public BaseScheduleJob selectByPrimaryKey(Integer id) {
        return this.baseScheduleJobMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseScheduleJob record) {
        return this.baseScheduleJobMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseScheduleJob> selectListByConditions(Integer pageNo, Integer pageSize, BaseScheduleJob record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseScheduleJobMapper.selectListByConditions(record));
    }
}