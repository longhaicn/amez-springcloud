package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestionType;

/**
 * @author liufeihua
 */

public interface BaseQuestionTypeService {

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
    int insertSelective(BaseQuestionType record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseQuestionType selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseQuestionType record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseQuestionType> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestionType record);
}