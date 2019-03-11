package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseScheduleJob;
/**
 * @author liufeihua
 */
public interface BaseScheduleJobService {
    /**
     * 基本操作
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseScheduleJob record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseScheduleJob selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseScheduleJob record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseScheduleJob> selectListByConditions(Integer pageNo, Integer pageSize, BaseScheduleJob record);
}