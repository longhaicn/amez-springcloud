package com.union.aimei.pc.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.CommissionSetting;
import com.union.aimei.pc.financial.mapper.CommissionSettingMapper;
import com.union.aimei.pc.financial.service.CommissionSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author dell
 */
@Service
public class CommissionSettingServiceImpl implements CommissionSettingService {

    @Autowired(required = false)
    private CommissionSettingMapper commissionSettingMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.commissionSettingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(CommissionSetting record) {
        return this.commissionSettingMapper.insertSelective(record);
    }

    @Override
    public CommissionSetting selectByPrimaryKey(Integer id) {
        return this.commissionSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CommissionSetting record) {
        return this.commissionSettingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<CommissionSetting> selectListByConditions(Integer pageNo, Integer pageSize, CommissionSetting record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(commissionSettingMapper.selectListByConditions(record));
    }

    @Override
    public int updateByPrimaryKeySelectiveByList(List<CommissionSetting> record) {
        for (CommissionSetting commissionSetting : record) {
            this.commissionSettingMapper.updateByPrimaryKeySelective(commissionSetting);
        }
        return 0;
    }
}