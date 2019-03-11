package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseLogs;
/**
 * @author liufeihua
 */
public interface BaseLogsService {
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
    int insertSelective(BaseLogs record);

    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseLogs selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseLogs record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseLogs> selectListByConditions(Integer pageNo, Integer pageSize, BaseLogs record);
}