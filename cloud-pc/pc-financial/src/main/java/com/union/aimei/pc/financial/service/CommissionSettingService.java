package com.union.aimei.pc.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.CommissionSetting;

import java.util.List;

/**
 * @author dell
 */
public interface CommissionSettingService {
    /**
     * 基本操作
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
    int insertSelective(CommissionSetting record);

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
     * @return
     */
    int updateByPrimaryKeySelective(CommissionSetting record);

    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<CommissionSetting> selectListByConditions(Integer pageNo, Integer pageSize, CommissionSetting record);

    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelectiveByList(List<CommissionSetting> record);
}