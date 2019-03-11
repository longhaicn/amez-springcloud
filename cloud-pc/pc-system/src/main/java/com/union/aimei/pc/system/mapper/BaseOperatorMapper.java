package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseOperator;
import com.union.aimei.common.model.system.BaseOperatorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseOperatorMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseOperatorExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseOperatorExample example);

    /**
     * 根据id删除
     *
     * @param operId
     * @return
     */
    int deleteByPrimaryKey(Integer operId);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insert(BaseOperator record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseOperator record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseOperator> selectByExample(BaseOperatorExample example);

    /**
     * 查询
     *
     * @param operId
     * @return
     */
    BaseOperator selectByPrimaryKey(Integer operId);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseOperator record, @Param("example") BaseOperatorExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseOperator record, @Param("example") BaseOperatorExample example);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseOperator record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseOperator record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseOperator> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);

    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseOperator> selectListByConditions(BaseOperator record);
}