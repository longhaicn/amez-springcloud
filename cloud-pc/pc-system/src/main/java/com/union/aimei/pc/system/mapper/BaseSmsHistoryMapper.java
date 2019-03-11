package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseSmsHistory;
import com.union.aimei.common.model.system.BaseSmsHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseSmsHistoryMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseSmsHistoryExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseSmsHistoryExample example);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insert(BaseSmsHistory record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseSmsHistory record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseSmsHistory> selectByExample(BaseSmsHistoryExample example);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseSmsHistory selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseSmsHistory record, @Param("example") BaseSmsHistoryExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseSmsHistory record, @Param("example") BaseSmsHistoryExample example);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseSmsHistory record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseSmsHistory record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseSmsHistory> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseSmsHistory> selectListByConditions(BaseSmsHistory record);
}