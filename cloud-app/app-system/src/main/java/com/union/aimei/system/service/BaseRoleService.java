package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRole;
/**
 * @author liufeihua
 */
public interface BaseRoleService {
    /**
     * 基本操作
     * @param roleId
     * @return
     */
    int deleteByPrimaryKey(Integer roleId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseRole record);
    /**
     * 基本操作
     * @param roleId
     * @return
     */
    BaseRole selectByPrimaryKey(Integer roleId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRole record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseRole record);
}