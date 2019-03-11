package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseQuestionType;
import com.union.aimei.common.model.system.BaseQuestionTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseQuestionTypeMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseQuestionTypeExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseQuestionTypeExample example);

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
    int insert(BaseQuestionType record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseQuestionType record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseQuestionType> selectByExample(BaseQuestionTypeExample example);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseQuestionType selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseQuestionType record, @Param("example") BaseQuestionTypeExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseQuestionType record, @Param("example") BaseQuestionTypeExample example);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseQuestionType record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseQuestionType record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseQuestionType> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseQuestionType> selectListByConditions(BaseQuestionType record);
}