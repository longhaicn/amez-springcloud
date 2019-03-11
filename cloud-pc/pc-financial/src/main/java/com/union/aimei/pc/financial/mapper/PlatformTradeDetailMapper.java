package com.union.aimei.pc.financial.mapper;

import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.model.financial.PlatformTradeDetailExample;
import com.union.aimei.common.vo.financial.PlatformTradeDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author dell
 */
public interface PlatformTradeDetailMapper {
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    long countByExample(PlatformTradeDetailExample example);
    /**
     * 基本操作
     *
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
     *
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
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") PlatformTradeDetail record, @Param("example") PlatformTradeDetailExample example);
    /**
     * 基本操作
     *
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

    /**
     * 分页和条件查询平台交易流水-后台管理
     *
     * @param record
     * @return
     */
    List<PlatformTradeDetail> selectPlatformListByConditions(PlatformTradeDetailVo record);

    /**
     * 根据订单号查数据
     *
     * @param record
     * @return
     */
    PlatformTradeDetail selectByOrderNoTradeType(PlatformTradeDetail record);
}