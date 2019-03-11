package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRoleResources;
/**
 * @author liufeihua
 */
public interface BaseRoleResourcesService {
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
    int insertSelective(BaseRoleResources record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseRoleResources selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRoleResources record);

    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseRoleResources> selectListByConditions(Integer pageNo, Integer pageSize, BaseRoleResources record);
}