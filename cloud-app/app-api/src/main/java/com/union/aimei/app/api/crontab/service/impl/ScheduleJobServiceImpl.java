package com.union.aimei.app.api.crontab.service.impl;

import com.github.pagehelper.PageInfo;
import com.union.aimei.app.api.crontab.feign.ScheduleJobFeign;
import com.union.aimei.app.api.crontab.service.ScheduleJobService;
import com.union.aimei.common.model.crontab.ScheduleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaowei
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScheduleJobFeign scheduleJobFeign;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.scheduleJobFeign.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ScheduleJob record) {
        return this.scheduleJobFeign.insertSelective(record);
    }

    @Override
    public ScheduleJob selectByPrimaryKey(Integer id) {
        return this.scheduleJobFeign.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ScheduleJob record) {
        return this.scheduleJobFeign.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<ScheduleJob> selectListByConditions(Integer pageNo, Integer pageSize, ScheduleJob record) {
        return scheduleJobFeign.selectListByConditions(pageNo, pageSize, record);
    }
}