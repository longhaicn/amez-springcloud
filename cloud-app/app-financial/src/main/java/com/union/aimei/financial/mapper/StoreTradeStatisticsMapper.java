package com.union.aimei.financial.mapper;

import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.financial.StoreTradeStatisticsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface StoreTradeStatisticsMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(StoreTradeStatisticsExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(StoreTradeStatisticsExample example);
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
    int insert(StoreTradeStatistics record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(StoreTradeStatistics record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<StoreTradeStatistics> selectByExample(StoreTradeStatisticsExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreTradeStatistics selectByPrimaryKey(Integer id);

    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") StoreTradeStatistics record, @Param("example") StoreTradeStatisticsExample example);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") StoreTradeStatistics record, @Param("example") StoreTradeStatisticsExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StoreTradeStatistics record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(StoreTradeStatistics record);

    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<StoreTradeStatistics> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<StoreTradeStatistics> selectListByConditions(StoreTradeStatistics record);
}