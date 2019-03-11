package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseRoleResources;
import com.union.aimei.common.model.system.BaseRoleResourcesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseRoleResourcesMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseRoleResourcesExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseRoleResourcesExample example);
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
    int insert(BaseRoleResources record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseRoleResources record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseRoleResources> selectByExample(BaseRoleResourcesExample example);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseRoleResources selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseRoleResources record, @Param("example") BaseRoleResourcesExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseRoleResources record, @Param("example") BaseRoleResourcesExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRoleResources record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseRoleResources record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseRoleResources> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseRoleResources> selectListByConditions(BaseRoleResources record);
}