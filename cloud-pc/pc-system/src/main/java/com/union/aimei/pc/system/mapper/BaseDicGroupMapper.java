package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.model.system.BaseDicGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseDicGroupMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseDicGroupExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseDicGroupExample example);

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
    int insert(BaseDicGroup record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseDicGroup record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseDicGroup> selectByExample(BaseDicGroupExample example);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseDicGroup selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseDicGroup record, @Param("example") BaseDicGroupExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseDicGroup record, @Param("example") BaseDicGroupExample example);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseDicGroup record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseDicGroup record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseDicGroup> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseDicGroup> selectListByConditions(BaseDicGroup record);
}