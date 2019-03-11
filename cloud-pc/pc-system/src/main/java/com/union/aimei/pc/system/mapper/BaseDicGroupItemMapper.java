package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.common.model.system.BaseDicGroupItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseDicGroupItemMapper {
    /**
     * 统计
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
    int insert(BaseDicGroupItem record);

    /**
     * 添加
     *
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
     * 查询
     *
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
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseDicGroupItem record);
    /**
     * 更新
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
     * 查看
     * @param record
     * @return
     */
    List<BaseDicGroupItem> selectListByConditions(BaseDicGroupItem record);
}