package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseSmsHistory;

/**
 * @author liufeihua
 */

public interface BaseSmsHistoryService {

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
    int insertSelective(BaseSmsHistory record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseSmsHistory selectByPrimaryKey(Integer id);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseSmsHistory record);

    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseSmsHistory> selectListByConditions(Integer pageNo, Integer pageSize, BaseSmsHistory record);
}