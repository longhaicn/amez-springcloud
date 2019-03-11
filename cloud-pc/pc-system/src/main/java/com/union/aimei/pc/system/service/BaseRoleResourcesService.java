package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRoleResources;
import com.union.common.utils.ResponseMessage;

/**
 * @author liufeihua
 */

public interface BaseRoleResourcesService {

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
    int insertSelective(BaseRoleResources record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseRoleResources selectByPrimaryKey(Integer id);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRoleResources record);

    /**
     * 查询
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseRoleResources> selectListByConditions(Integer pageNo, Integer pageSize, BaseRoleResources record);

    /**
     * 分配
     *
     * @param roleId
     * @param resourcesIds
     * @return
     */
    ResponseMessage<String> distributionBaseRoleResources(Integer roleId, String resourcesIds);

}