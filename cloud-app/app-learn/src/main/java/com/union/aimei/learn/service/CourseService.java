package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.app.CourseParamVo;
import com.union.aimei.common.vo.learn.app.CourseResultVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 查询课程表
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseService extends SpringCloudBaseService<Course> {
    /**
     * 前端分页查询课程表(1.1.0)
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param course   查询条件
     * @return
     */
    PageInfo<Course> findByPageForFrontV110(Integer pageNo, Integer pageSize, Course course);

    /**
     * 查询培训课程列表(1.1.0)
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param courseParamVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<CourseResultVo>> selectCourseListByBeauticV110(Integer pageNo, Integer pageSize, CourseParamVo courseParamVo);

    /**
     * 根据id查询培训课程详情(1.1.0)
     *
     * @param id
     * @param beauticianId
     * @return
     */
    ResponseMessage<CourseResultVo> selectByCourseIdV110(Integer id, Integer beauticianId);


}