package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestionType;
import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseQuestionTypeService {
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
    int insertSelective(BaseQuestionType record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseQuestionType selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseQuestionType record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseQuestionType> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestionType record);
}