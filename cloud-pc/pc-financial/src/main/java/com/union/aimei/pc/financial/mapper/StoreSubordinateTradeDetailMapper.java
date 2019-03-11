package com.union.aimei.pc.financial.mapper;

import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author dell
 */
public interface StoreSubordinateTradeDetailMapper {
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    long countByExample(StoreSubordinateTradeDetailExample example);
    /**
     * 基本操作
     *
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
     *
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
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") StoreSubordinateTradeDetail record, @Param("example") StoreSubordinateTradeDetailExample example);
    /**
     * 基本操作
     *
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
     * 基本操作
     * @param record
     * @return
     */
    List<StoreSubordinateTradeDetail> selectListByConditions(StoreSubordinateTradeDetail record);

    /**
     * 根据订单号查数据
     *
     * @param record
     * @return
     */
    StoreSubordinateTradeDetail selectByOrderNoTradeType(StoreSubordinateTradeDetail record);
}