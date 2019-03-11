package com.union.aimei.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsAwaitVo;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * @author liufeihua
 */
public interface StoreTradeStatisticsService {
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
    int insertSelective(StoreTradeStatistics record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreTradeStatistics selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StoreTradeStatistics record);

    /**
     * 分页财务对账列表
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<StoreTradeStatistics> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeStatistics record);

    /**
     * 查询财务对账列表
     *
     * @param record
     * @return
     */
    ResponseMessage<List<StoreTradeStatistics>> selectListByConditionsV110(StoreTradeStatistics record);

    /**
     * 查询财务对账列表vo(v1.1.0)
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    ResponseMessage<PageInfo<StoreTradeStatisticsVo>> selectListByConditionsVoV110(Integer pageNo, Integer pageSize, StoreTradeStatistics record);


    /**
     * 根据店铺id 查询待结算的对账数据
     *
     * @param storeId
     * @return
     */
    ResponseMessage<StoreTradeStatisticsAwaitVo> selectBySettlementAndStoreIdV110(Integer storeId);

    /**
     * 对账确认接口(v1.1.0)
     *
     * @param id
     * @return
     */
    ResponseMessage checkForConfirmationV110(Integer id);

    /**
     * 根据店铺统计id查询体现表数据(v1.1.0)
     *
     * @param id
     * @return
     */
    ResponseMessage<StoreshipWithdrawal> selectStoreshipWithdrawalByStoreTradeIdV110(Integer id);


}