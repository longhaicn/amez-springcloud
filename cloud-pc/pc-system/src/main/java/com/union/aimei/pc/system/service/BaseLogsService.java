package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseLogs;

/**
 * @author liufeihua
 */

public interface BaseLogsService {

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
    int insertSelective(BaseLogs record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseLogs selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseLogs record);

    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseLogs> selectListByConditions(Integer pageNo, Integer pageSize, BaseLogs record);
}