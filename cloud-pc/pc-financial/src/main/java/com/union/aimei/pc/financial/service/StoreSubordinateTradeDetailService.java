package com.union.aimei.pc.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
/**
 * @author dell
 */
public interface StoreSubordinateTradeDetailService {
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
    int insertSelective(StoreSubordinateTradeDetail record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreSubordinateTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StoreSubordinateTradeDetail record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<StoreSubordinateTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreSubordinateTradeDetail record);
}