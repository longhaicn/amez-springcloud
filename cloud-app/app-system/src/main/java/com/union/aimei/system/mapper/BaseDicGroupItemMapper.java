package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.common.model.system.BaseDicGroupItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseDicGroupItemMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseDicGroupItemExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseDicGroupItemExample example);
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
    int insert(BaseDicGroupItem record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseDicGroupItem record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseDicGroupItem> selectByExample(BaseDicGroupItemExample example);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseDicGroupItem selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseDicGroupItem record, @Param("example") BaseDicGroupItemExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseDicGroupItem record, @Param("example") BaseDicGroupItemExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseDicGroupItem record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseDicGroupItem record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseDicGroupItem> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseDicGroupItem> selectListByConditions(BaseDicGroupItem record);

    /**
     * 根据数据字典ID查询数据字典子项列表
     *
     * @param groupId 数据字典ID
     * @return
     */
    List<BaseDicGroupItem> listByGroupId(@Param(value = "groupId") int groupId);

}