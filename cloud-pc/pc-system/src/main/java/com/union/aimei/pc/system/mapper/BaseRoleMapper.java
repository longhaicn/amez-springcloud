package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseRole;
import com.union.aimei.common.model.system.BaseRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseRoleMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseRoleExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseRoleExample example);

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
    int insert(BaseRole record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseRole record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseRole> selectByExample(BaseRoleExample example);

    /**
     * 查询
     *
     * @param roleId
     * @return
     */
    BaseRole selectByPrimaryKey(Integer roleId);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseRole record, @Param("example") BaseRoleExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseRole record, @Param("example") BaseRoleExample example);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRole record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseRole record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseRole> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseRole> selectListByConditions(BaseRole record);
}