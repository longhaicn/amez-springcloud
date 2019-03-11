package com.union.aimei.pc.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.pc.financial.mapper.StoreSubordinateTradeDetailMapper;
import com.union.aimei.pc.financial.service.StoreSubordinateTradeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author dell
 */
@Service
public class StoreSubordinateTradeDetailServiceImpl implements StoreSubordinateTradeDetailService {

    @Autowired(required = false)
    private StoreSubordinateTradeDetailMapper storeSubordinateTradeDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.storeSubordinateTradeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(StoreSubordinateTradeDetail record) {
        return this.storeSubordinateTradeDetailMapper.insertSelective(record);
    }

    @Override
    public StoreSubordinateTradeDetail selectByPrimaryKey(Integer id) {
        return this.storeSubordinateTradeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StoreSubordinateTradeDetail record) {
        return this.storeSubordinateTradeDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<StoreSubordinateTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreSubordinateTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(storeSubordinateTradeDetailMapper.selectListByConditions(record));
    }
}