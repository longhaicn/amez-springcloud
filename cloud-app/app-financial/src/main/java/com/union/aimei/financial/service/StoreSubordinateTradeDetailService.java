package com.union.aimei.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceResponseVo;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceVo;
import com.union.aimei.common.vo.financial.QueryStorePerformanceResponseVo;
import com.union.common.utils.ResponseMessage;
/**
 * @author liufeihua
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
    ResponseMessage insertSelectiveV110(StoreSubordinateTradeDetail record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreSubordinateTradeDetail selectByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelectiveV110(StoreSubordinateTradeDetail record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<StoreSubordinateTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, StoreSubordinateTradeDetail record);

    /**
     * app门店端的营业统计-挂靠
     *
     * @param vo
     * @return
     */
    ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(QueryProjectPerformanceVo vo);

    /**
     * pp门店端挂靠的营业统计中的项目业绩
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(Integer pageNo, Integer pageSize, QueryProjectPerformanceVo vo);
}