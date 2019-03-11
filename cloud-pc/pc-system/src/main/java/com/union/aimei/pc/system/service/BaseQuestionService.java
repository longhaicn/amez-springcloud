package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestion;

import java.util.Map;

/**
 * @author liufeihua
 */

public interface BaseQuestionService {

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
    int insertSelective(BaseQuestion record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseQuestion selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseQuestion record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseQuestion> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestion record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<Map<String, Object>> selectListByConditionsForBg(Integer pageNo, Integer pageSize, BaseQuestion record);


}