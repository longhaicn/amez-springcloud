package com.union.aimei.pc.financial.mapper;

import com.union.aimei.common.model.financial.CommissionSetting;
import com.union.aimei.common.model.financial.CommissionSettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author dell
 */
public interface CommissionSettingMapper {
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    long countByExample(CommissionSettingExample example);
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    int deleteByExample(CommissionSettingExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insert(CommissionSetting record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(CommissionSetting record);
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    List<CommissionSetting> selectByExample(CommissionSettingExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    CommissionSetting selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") CommissionSetting record, @Param("example") CommissionSettingExample example);
    /**
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") CommissionSetting record, @Param("example") CommissionSettingExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CommissionSetting record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(CommissionSetting record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<CommissionSetting> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<CommissionSetting> selectListByConditions(CommissionSetting record);
}