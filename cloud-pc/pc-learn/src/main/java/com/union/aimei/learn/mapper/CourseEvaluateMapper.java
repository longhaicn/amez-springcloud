package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 课程题目
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseEvaluateMapper extends BaseMapper<CourseEvaluate> {

    /**
     * 批量添加课程题目
     *
     * @param list
     * @return
     */
    int addBatch(List<CourseEvaluate> list);

    /**
     * 批量根据id删除数据
     *
     * @param list
     * @return
     */
    int deleteByPrimaryKeyList(List<Integer> list);
}