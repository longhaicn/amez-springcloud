package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseQuestionType;
import com.union.aimei.common.model.system.BaseQuestionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * @author liufeihua
 */
public interface BaseQuestionTypeMapper {
    /**
     * 基本操作
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
     * 基本操作
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insert(BaseQuestionType record);
    /**
     * 基本操作
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
     * 基本操作
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
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseQuestionType record);
    /**
     * 基本操作
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
     * 基本操作
     * @param record
     * @return
     */
    List<BaseQuestionType> selectListByConditions(BaseQuestionType record);
}