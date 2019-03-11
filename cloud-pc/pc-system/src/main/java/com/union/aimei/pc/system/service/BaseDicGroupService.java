package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroup;

/**
 * @author liufeihua
 */

public interface BaseDicGroupService {

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
    int insertSelective(BaseDicGroup record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseDicGroup selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseDicGroup record);

    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseDicGroup> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroup record);
}