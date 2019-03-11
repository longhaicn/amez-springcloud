package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseRole;
import com.union.aimei.common.model.system.BaseRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseRoleMapper {
    /**
     * 基本操作
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
    int insert(BaseRole record);
    /**
     * 基本操作
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
     * 基本操作
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
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRole record);
    /**
     * 基本操作
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
     * 基本操作
     * @param record
     * @return
     */
    List<BaseRole> selectListByConditions(BaseRole record);
}