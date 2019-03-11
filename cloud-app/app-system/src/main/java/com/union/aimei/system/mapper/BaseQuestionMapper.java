package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseQuestion;
import com.union.aimei.common.model.system.BaseQuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author liufeihua
 */
public interface BaseQuestionMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseQuestionExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseQuestionExample example);
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
    int insert(BaseQuestion record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseQuestion record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseQuestion> selectByExampleWithBLOBs(BaseQuestionExample example);

    /**
     * 查看
     * @param example
     * @return
     */
    List<BaseQuestion> selectByExample(BaseQuestionExample example);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseQuestion selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseQuestion record, @Param("example") BaseQuestionExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleWithBLOBs(@Param("record") BaseQuestion record, @Param("example") BaseQuestionExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseQuestion record, @Param("example") BaseQuestionExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseQuestion record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(BaseQuestion record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseQuestion record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseQuestion> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseQuestion> selectListByConditions(BaseQuestion record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<Map<String, Object>> selectListByConditionsForBg(BaseQuestion record);
}