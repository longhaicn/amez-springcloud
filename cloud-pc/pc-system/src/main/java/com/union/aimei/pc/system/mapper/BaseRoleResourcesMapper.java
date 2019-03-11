package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseRoleResources;
import com.union.aimei.common.model.system.BaseRoleResourcesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseRoleResourcesMapper {
    /**
     * 统计
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
    int insert(BaseRoleResources record);

    /**
     * 添加
     *
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
     * 查询
     *
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
     * 更新
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
     * 查看
     * @param record
     * @return
     */
    List<BaseRoleResources> selectListByConditions(BaseRoleResources record);
}