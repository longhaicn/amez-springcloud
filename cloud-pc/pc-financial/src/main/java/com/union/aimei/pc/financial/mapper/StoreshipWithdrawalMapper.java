package com.union.aimei.pc.financial.mapper;

import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.common.model.financial.StoreshipWithdrawalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author dell
 */
public interface StoreshipWithdrawalMapper {
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    long countByExample(StoreshipWithdrawalExample example);
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    int deleteByExample(StoreshipWithdrawalExample example);
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
    int insert(StoreshipWithdrawal record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(StoreshipWithdrawal record);
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    List<StoreshipWithdrawal> selectByExample(StoreshipWithdrawalExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    StoreshipWithdrawal selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") StoreshipWithdrawal record, @Param("example") StoreshipWithdrawalExample example);
    /**
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") StoreshipWithdrawal record, @Param("example") StoreshipWithdrawalExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(StoreshipWithdrawal record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(StoreshipWithdrawal record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<StoreshipWithdrawal> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<StoreshipWithdrawal> selectListByConditions(StoreshipWithdrawal record);

    /**
     * 根据年月跟storeId更新数据
     *
     * @param record
     * @return
     */
    int updateByStoreIdAndStatisticsYearMonth(StoreshipWithdrawal record);
}