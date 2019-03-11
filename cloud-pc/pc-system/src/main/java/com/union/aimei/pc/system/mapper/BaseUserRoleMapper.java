package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseUserRole;
import com.union.aimei.common.model.system.BaseUserRoleExample;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseUserRoleMapper {
    /**
     * 统计
     *
     * @param example
     * @return
     */
    long countByExample(BaseUserRoleExample example);

    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    int deleteByExample(BaseUserRoleExample example);

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
    int insert(BaseUserRole record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseUserRole record);

    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    List<BaseUserRole> selectByExample(BaseUserRoleExample example);

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
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseUserRole record, @Param("example") BaseUserRoleExample example);

    /**
     * 更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseUserRole record, @Param("example") BaseUserRoleExample example);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseUserRole record);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseUserRole record);

    /**
     * 查看
     *
     * @param offset
     * @param limit
     * @return
     */
    List<BaseUserRole> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);

    /**
     * 查看
     *
     * @param record
     * @return
     */
    List<BaseUserRole> selectListByConditions(BaseUserRole record);
}