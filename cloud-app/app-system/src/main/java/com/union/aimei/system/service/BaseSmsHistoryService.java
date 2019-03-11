package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseSmsHistory;
/**
 * @author liufeihua
 */
public interface BaseSmsHistoryService {
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
    int insertSelective(BaseSmsHistory record);

    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseSmsHistory selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseSmsHistory record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseSmsHistory> selectListByConditions(Integer pageNo, Integer pageSize, BaseSmsHistory record);
}