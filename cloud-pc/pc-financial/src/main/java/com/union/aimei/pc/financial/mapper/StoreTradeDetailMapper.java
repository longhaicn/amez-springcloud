package com.union.aimei.pc.financial.mapper;

import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeDetailExample;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author dell
 */
public interface StoreTradeDetailMapper {
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    long countByExample(StoreTradeDetailExample example);
    /**
     * 基本操作
     *
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
     *
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
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") StoreTradeDetail record, @Param("example") StoreTradeDetailExample example);
    /**
     * 基本操作
     *
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
     * 分页和条件查询店铺流水-后台
     *
     * @param
     * @return
     */
    List<StoreTradeStatistics> selectStoreListByConditions();

    /**
     * 批量修改我的过期会员卡
     * @param record
     */
    void updateBatch(StoreTradeDetail record);

    /**
     * 根据订单号查数据
     *
     * @param record
     * @return
     */
    StoreTradeDetail selectByOrderNoTradeType(StoreTradeDetail record);
}