package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.model.system.BaseDicGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseDicGroupMapper {
    /**
     * 基本操作
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
    int insert(BaseDicGroup record);
    /**
     * 基本操作
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
     * 基本操作
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
     * 基本操作
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
     * 基本操作
     * @param record
     * @return
     */
    List<BaseDicGroup> selectListByConditions(BaseDicGroup record);

    /**
     * 根据数据字典代码查询数据字典
     *
     * @param code 数据字典代码
     * @return
     */
    BaseDicGroup getByCode(@Param(value = "code") String code);

}