package com.union.aimei.pc.financial.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.pc.financial.mapper.StoreTradeDetailMapper;
import com.union.aimei.pc.financial.service.StoreTradeDetailService;
import com.union.common.utils.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
/**
 * @author dell
 */
@Service
public class StoreTradeDetailServiceImpl implements StoreTradeDetailService {

    @Autowired(required = false)
    private StoreTradeDetailMapper storeTradeDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.storeTradeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    @TxTransaction(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(StoreTradeDetail record) {
        record.setStatisticsYear(DateUtil.getCurrentYear());
        record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        record.setCreateTime(new Date());
        return this.storeTradeDetailMapper.insertSelective(record);
    }

    @Override
    public StoreTradeDetail selectByPrimaryKey(Integer id) {
        return this.storeTradeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StoreTradeDetail record) {
        record.setUpdateTime(new Date());
        return this.storeTradeDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<StoreTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(storeTradeDetailMapper.selectListByConditions(record));
    }

    /**
     * 统计店铺数据
     *
     * @param statisticsYearMonth
     * @return
     */
    @Override
    public PageInfo<StoreTradeStatistics> selectStoreListByConditions(String statisticsYearMonth) {
        return new PageInfo<>(storeTradeDetailMapper.selectStoreListByConditions());
    }

}