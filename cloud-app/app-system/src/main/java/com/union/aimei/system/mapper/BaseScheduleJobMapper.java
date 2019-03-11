package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseScheduleJob;
import com.union.aimei.common.model.system.BaseScheduleJobExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseScheduleJobMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseScheduleJobExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseScheduleJobExample example);
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
    int insert(BaseScheduleJob record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseScheduleJob record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseScheduleJob> selectByExample(BaseScheduleJobExample example);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseScheduleJob selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseScheduleJob record, @Param("example") BaseScheduleJobExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseScheduleJob record, @Param("example") BaseScheduleJobExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseScheduleJob record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseScheduleJob record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseScheduleJob> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseScheduleJob> selectListByConditions(BaseScheduleJob record);
}