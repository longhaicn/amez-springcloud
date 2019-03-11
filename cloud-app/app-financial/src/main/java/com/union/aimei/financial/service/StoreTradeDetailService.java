package com.union.aimei.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.common.utils.ResponseMessage;

import java.util.List;
import java.util.Map;
/**
 * @author liufeihua
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
    ResponseMessage insertSelectiveV110(StoreTradeDetail record);
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
    ResponseMessage updateByPrimaryKeySelectiveV110(StoreTradeDetail record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<StoreTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreTradeDetail record);

    /**
     * 根据店铺ID查询店铺资产
     *
     * @param storeId
     * @return
     */
    ResponseMessage<StoreAssertVo> queryStoreAssertInfo(Integer storeId);

    /**
     * 查询店铺年月账单
     *
     * @param storeId
     * @param yearMonth
     * @return
     */
    ResponseMessage<List<StoreMonthBillVo>> queryStoreMonthBillInfo(Integer storeId, String yearMonth);

    /**
     * app门店端的营业统计中的项目业绩
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(Integer pageNo, Integer pageSize, QueryProjectPerformanceVo vo);

    /**
     * app门店端的营业统计
     *
     * @param vo
     * @return
     */
    ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(QueryProjectPerformanceVo vo);

    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    ResponseMessage<Map<String, Object>> dayOrderAndAccount(Integer id);

    /**
     * 分页和条件查询店铺流水（待结算）(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    ResponseMessage<PageInfo<StoreTradeDetail>> selectListBySettlementStatus(Integer pageNo, Integer pageSize, StoreTradeDetail record);

    /**
     * 根据ID查询店铺流水(v1.1.0)
     *
     * @param id
     * @return
     */
    ResponseMessage<QueryStoreTradeDetailVo> selectByPrimaryKeyV110(Integer id);


}