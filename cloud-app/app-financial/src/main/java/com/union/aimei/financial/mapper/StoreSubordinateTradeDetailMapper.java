package com.union.aimei.financial.mapper;

import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetailExample;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceResponseVo;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceVo;
import com.union.aimei.common.vo.financial.QueryStorePerformanceResponseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface StoreSubordinateTradeDetailMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(StoreSubordinateTradeDetailExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(StoreSubordinateTradeDetailExample example);
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
    int insert(StoreSubordinateTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(StoreSubordinateTradeDetail record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<StoreSubordinateTradeDetail> selectByExample(StoreSubordinateTradeDetailExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreSubordinateTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") StoreSubordinateTradeDetail record, @Param("example") StoreSubordinateTradeDetailExample example);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") StoreSubordinateTradeDetail record, @Param("example") StoreSubordinateTradeDetailExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StoreSubordinateTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(StoreSubordinateTradeDetail record);

    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<StoreSubordinateTradeDetail> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);

    /**
     * 查看
     * @param record
     * @return
     */
    List<StoreSubordinateTradeDetail> selectListByConditions(StoreSubordinateTradeDetail record);

    /**
     * app门店端的营业统计-挂靠
     *
     * @param vo
     * @return
     */
    QueryStorePerformanceResponseVo queryStorePerformance(QueryProjectPerformanceVo vo);

    /**
     * app门店端挂靠的营业统计中的项目业绩
     *
     * @param vo
     * @return
     */
    List<QueryProjectPerformanceResponseVo> queryProjectPerformance(QueryProjectPerformanceVo vo);
}