package com.union.aimei.pc.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
/**
 * @author dell
 */
public interface StoreTradeDetailService {
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
    int insertSelective(StoreTradeDetail record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StoreTradeDetail record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<StoreTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeDetail record);

    /**
     * 统计店铺数据
     *
     * @param statisticsYearMonth
     * @return
     */
    PageInfo<StoreTradeStatistics> selectStoreListByConditions(String statisticsYearMonth);


}