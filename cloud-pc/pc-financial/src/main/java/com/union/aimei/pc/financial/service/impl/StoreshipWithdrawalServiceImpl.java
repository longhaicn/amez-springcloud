package com.union.aimei.pc.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.pc.financial.mapper.StoreshipWithdrawalMapper;
import com.union.aimei.pc.financial.service.StoreshipWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author dell
 */
@Service
public class StoreshipWithdrawalServiceImpl implements StoreshipWithdrawalService {

    @Autowired(required = false)
    private StoreshipWithdrawalMapper storeshipWithdrawalMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.storeshipWithdrawalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(StoreshipWithdrawal record) {
        return this.storeshipWithdrawalMapper.insertSelective(record);
    }

    @Override
    public StoreshipWithdrawal selectByPrimaryKey(Integer id) {
        return this.storeshipWithdrawalMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StoreshipWithdrawal record) {
        return this.storeshipWithdrawalMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<StoreshipWithdrawal> selectListByConditions(Integer pageNo, Integer pageSize, StoreshipWithdrawal record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(storeshipWithdrawalMapper.selectListByConditions(record));
    }
}