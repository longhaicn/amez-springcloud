package com.union.aimei.financial.mapper;

import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.model.financial.BeauticianTradeDetailExample;
import com.union.aimei.common.vo.financial.BeauticianTradeDetailVo;
import com.union.aimei.common.vo.financial.BeauticianTradeStatisticalVo;
import com.union.aimei.common.vo.financial.QueryMemberPerformanceResponseVo;
import com.union.aimei.common.vo.financial.QueryMemberPerformanceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author liufeihua
 */
public interface BeauticianTradeDetailMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BeauticianTradeDetailExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BeauticianTradeDetailExample example);
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
    int insert(BeauticianTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BeauticianTradeDetail record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BeauticianTradeDetail> selectByExample(BeauticianTradeDetailExample example);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    BeauticianTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BeauticianTradeDetail record, @Param("example") BeauticianTradeDetailExample example);
    /**
     * 查看
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BeauticianTradeDetail record, @Param("example") BeauticianTradeDetailExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BeauticianTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(BeauticianTradeDetail record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BeauticianTradeDetail> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BeauticianTradeDetail> selectListByConditions(BeauticianTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BeauticianTradeDetail> selectListByConditionsVo(BeauticianTradeDetailVo record);


    /**
     * 日订单数和日收入
     *
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
     * app门店端的营业统计中的员工业绩
     *
     * @param vo
     * @return
     */
    List<QueryMemberPerformanceResponseVo> queryMemberPerformance(QueryMemberPerformanceVo vo);

    /**
     * app门店端的营业统计中的员工业绩
     *
     * @param vo
     * @return
     */
    List<QueryMemberPerformanceResponseVo> queryMemberPerformanceV111(QueryMemberPerformanceVo vo);


    /**
     * 美容师流水数据统计vo
     *
     * @param beauticianId
     * @return
     */
    BeauticianTradeStatisticalVo queryBeauticianTradeStatistical(Integer beauticianId);
}