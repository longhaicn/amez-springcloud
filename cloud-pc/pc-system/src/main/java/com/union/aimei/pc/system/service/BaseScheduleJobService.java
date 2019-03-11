package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseScheduleJob;

/**
 * @author liufeihua
 */

public interface BaseScheduleJobService {
    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseScheduleJob record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseScheduleJob selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseScheduleJob record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseScheduleJob> selectListByConditions(Integer pageNo, Integer pageSize, BaseScheduleJob record);
}