package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestion;

import java.util.Map;
/**
 * @author liufeihua
 */
public interface BaseQuestionService {
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
    int insertSelective(BaseQuestion record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseQuestion selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseQuestion record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseQuestion> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestion record);

    /**
     * 分页和条件查询常见问题-前台
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<Map<String, Object>> selectListByConditionsForBg(Integer pageNo, Integer pageSize, BaseQuestion record);
}