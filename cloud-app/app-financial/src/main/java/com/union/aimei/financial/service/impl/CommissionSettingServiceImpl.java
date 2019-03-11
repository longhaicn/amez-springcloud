package com.union.aimei.financial.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.CommissionSetting;
import com.union.aimei.financial.mapper.CommissionSettingMapper;
import com.union.aimei.financial.service.CommissionSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
/**
 * @author liufeihua
 */
@Service
public class CommissionSettingServiceImpl implements CommissionSettingService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        record.setUpdateTime(new Date());
        return this.commissionSettingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<CommissionSetting> selectListByConditions(Integer pageNo, Integer pageSize, CommissionSetting record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(commissionSettingMapper.selectListByConditions(record));
    }

    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public CommissionSetting selectByCommissionCode(String commissionCode) {
        return commissionSettingMapper.selectListByConditions(
                CommissionSetting
                        .builder()
                        .commissionCode(commissionCode).build())
                .get(0);
    }
}