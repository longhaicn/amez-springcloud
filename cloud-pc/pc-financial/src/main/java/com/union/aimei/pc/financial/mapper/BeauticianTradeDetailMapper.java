package com.union.aimei.pc.financial.mapper;

import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.model.financial.BeauticianTradeDetailExample;
import com.union.aimei.common.vo.financial.WithdrawsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dell
 */
public interface BeauticianTradeDetailMapper {
    /**
     * 基本操作
     *
     * @param example
     * @return
     */
    long countByExample(BeauticianTradeDetailExample example);

    /**
     * 基本操作
     *
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
     *
     * @param record
     * @return
     */
    int insert(BeauticianTradeDetail record);

    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    int insertSelective(BeauticianTradeDetail record);

    /**
     * 基本操作
     *
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
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BeauticianTradeDetail record, @Param("example") BeauticianTradeDetailExample example);
    /**
     * 基本操作
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BeauticianTradeDetail record, @Param("example") BeauticianTradeDetailExample example);

    /**
     * 基本操作
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BeauticianTradeDetail record);

    /**
     * 基本操作
     *
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
     *
     * @param record
     * @return
     */
    List<BeauticianTradeDetail> selectListByConditions(BeauticianTradeDetail record);

    /**
     * withdrawList
     *
     * @param record
     * @return
     */
    List<BeauticianTradeDetail> withdrawList(WithdrawsVo record);

    /**
     * 根据订单号查数据
     *
     * @param record
     * @return
     */
    BeauticianTradeDetail selectByOrderNoTradeType(BeauticianTradeDetail record);

}