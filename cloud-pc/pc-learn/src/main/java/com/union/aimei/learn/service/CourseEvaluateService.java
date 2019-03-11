package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 课程试题
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseEvaluateService extends SpringCloudBaseService<CourseEvaluate> {
    /**
     * 前端分页查询课程试题(v1.1.0)
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param courseEvaluate 查询条件
     * @return
     */
    PageInfo<CourseEvaluate> findByPageForFrontV110(Integer pageNo, Integer pageSize, CourseEvaluate courseEvaluate);
}