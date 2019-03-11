package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseLogs;
import com.union.aimei.common.model.system.BaseLogsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseLogsMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseLogsExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseLogsExample example);
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
    int insert(BaseLogs record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseLogs record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseLogs> selectByExample(BaseLogsExample example);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseLogs selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseLogs record, @Param("example") BaseLogsExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseLogs record, @Param("example") BaseLogsExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseLogs record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseLogs record);

    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseLogs> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseLogs> selectListByConditions(BaseLogs record);
}