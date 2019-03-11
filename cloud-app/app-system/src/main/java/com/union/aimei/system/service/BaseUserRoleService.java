package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseUserRole;
/**
 * @author liufeihua
 */
public interface BaseUserRoleService {
    /**
     * 基本操作
     * @param rightId
     * @return
     */
    int deleteByPrimaryKey(Integer rightId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseUserRole record);
    /**
     * 基本操作
     * @param rightId
     * @return
     */
    BaseUserRole selectByPrimaryKey(Integer rightId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseUserRole record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseUserRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseUserRole record);
}