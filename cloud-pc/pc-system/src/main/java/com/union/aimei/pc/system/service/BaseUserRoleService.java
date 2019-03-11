package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseUserRole;
import com.union.common.utils.ResponseMessage;

import java.util.Map;

/**
 * @author liufeihua
 */

public interface BaseUserRoleService {

    /**
     * 根据id删除
     *
     * @param rightId
     * @return
     */
    int deleteByPrimaryKey(Integer rightId);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseUserRole record);

    /**
     * 查询
     *
     * @param rightId
     * @return
     */
    BaseUserRole selectByPrimaryKey(Integer rightId);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseUserRole record);

    /**
     * 查询
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseUserRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseUserRole record);

    /**
     * 分配
     *
     * @param userId
     * @param roleIds
     * @return
     */
    ResponseMessage<String> distributionBaseUserRole(Integer userId, String roleIds);

    /**
     * 查询
     *
     * @param userId
     * @return
     */
    ResponseMessage<Map<String, Object>> findBaseUserRoles(Integer userId);
}