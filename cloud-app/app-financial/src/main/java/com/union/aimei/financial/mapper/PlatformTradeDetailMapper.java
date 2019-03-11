package com.union.aimei.financial.mapper;

import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.model.financial.PlatformTradeDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface PlatformTradeDetailMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(PlatformTradeDetailExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(PlatformTradeDetailExample example);
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
    int insert(PlatformTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(PlatformTradeDetail record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<PlatformTradeDetail> selectByExample(PlatformTradeDetailExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    PlatformTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") PlatformTradeDetail record, @Param("example") PlatformTradeDetailExample example);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") PlatformTradeDetail record, @Param("example") PlatformTradeDetailExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PlatformTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(PlatformTradeDetail record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<PlatformTradeDetail> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<PlatformTradeDetail> selectListByConditions(PlatformTradeDetail record);
}