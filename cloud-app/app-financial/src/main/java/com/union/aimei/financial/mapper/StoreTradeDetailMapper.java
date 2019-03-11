package com.union.aimei.financial.mapper;

import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeDetailExample;
import com.union.aimei.common.vo.financial.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author liufeihua
 */
public interface StoreTradeDetailMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(StoreTradeDetailExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(StoreTradeDetailExample example);
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
    int insert(StoreTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(StoreTradeDetail record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<StoreTradeDetail> selectByExample(StoreTradeDetailExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") StoreTradeDetail record, @Param("example") StoreTradeDetailExample example);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") StoreTradeDetail record, @Param("example") StoreTradeDetailExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StoreTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(StoreTradeDetail record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<StoreTradeDetail> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<StoreTradeDetail> selectListByConditions(StoreTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<StoreTradeDetail> selectListByConditionsVo(StoreTradeDetailDateVo record);

    /**
     * 查看
     * @param map
     * @return
     */
    Map<String, Object> queryStoreThisYearIncome(Map<String, Object> map);

    /**
     * 查看
     * @param storeId
     * @return
     */
    List<StoreMonthSettleVo> queryStoreSettlement(Integer storeId);

    /**
     * 查询店铺年月账单
     *
     * @param map
     * @return
     */
    List<StoreMonthBillVo> queryStoreBillInfo(Map<String, Object> map);

    /**
     * app门店端的营业统计中的项目业绩
     *
     * @param vo
     * @return
     */
    List<QueryProjectPerformanceResponseVo> queryProjectPerformance(QueryProjectPerformanceVo vo);

    /**
     * app门店端的营业统计
     *
     * @param vo
     * @return
     */
    QueryStorePerformanceResponseVo queryStorePerformance(QueryProjectPerformanceVo vo);

    /**
     * 统计
     * @param id
     * @return
     */
    Map<String, Object> dayOrderAndAccount(Integer id);

    /**
     * 月收入
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> monthAccount(Map<String, Object> paramsMap);

    /**
     * 统计店铺待结算流水的对账金额
     *
     * @param storeTradeDetailSumVo
     * @return
     */
    int sumBySettlementAndStoreId(StoreTradeDetailSumVo storeTradeDetailSumVo);

}