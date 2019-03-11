package com.union.aimei.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.CommissionSetting;
/**
 * @author liufeihua
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
     * 基本操作
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
     * 查看
     * @param commissionCode
     * @return
     */
    CommissionSetting selectByCommissionCode(String commissionCode);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CommissionSetting record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<CommissionSetting> selectListByConditions(Integer pageNo, Integer pageSize, CommissionSetting record);
}