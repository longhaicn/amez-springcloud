package com.union.aimei.app.api.crontab.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.crontab.ScheduleJob;

/**
 * @author gaowei
 */
public interface ScheduleJobService {
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     * @param record
     * @return
     */
    int insertSelective(ScheduleJob record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ScheduleJob selectByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ScheduleJob record);

    /**
     * 查询分页
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<ScheduleJob> selectListByConditions(Integer pageNo, Integer pageSize, ScheduleJob record);
}