package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRole;

/**
 * @author liufeihua
 */

public interface BaseRoleService {
    /**
     * 根据id删除
     *
     * @param roleId
     * @return
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseRole record);

    /**
     * 查询
     *
     * @param roleId
     * @return
     */
    BaseRole selectByPrimaryKey(Integer roleId);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRole record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseRole record);
}