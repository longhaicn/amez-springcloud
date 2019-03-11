package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.pc.CourseDataVo;
import com.union.aimei.common.vo.learn.pc.CourseDetailVo;
import com.union.aimei.common.vo.learn.pc.CourseParamVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 课程表
 *
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
     * 根据条件统计课程(1.1.0)
     *
     * @param courseCode 课程编号
     * @return
     */
    ResponseMessage selectCountByCourseCodeV110(String courseCode);


    /**
     * 根据课程id与类型 更新课程以及关联的课时(1.1.0)
     *
     * @param courseId 课程id
     * @param type     更新类型，1删除 2非删除 3开启课程 4关闭课程
     * @return
     */
    ResponseMessage updateStatusEnabledByIdV110(Integer courseId, Integer type);

    /**
     * 根据条件查询课程列表 (1.1.0)
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param courseParamVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<Course>> selectPageByCourseV110(Integer pageNo, Integer pageSize, CourseParamVo courseParamVo);

    /**
     * 根据课程id查询课程详情(1.1.0)
     *
     * @param courseId
     * @return
     */
    ResponseMessage<CourseDetailVo> selectCourseDetailByIdV110(Integer courseId);

    /**
     * 发布课程(1.1.0)
     *
     * @param courseDataVo
     * @return
     */
    ResponseMessage insertCourseV110(CourseDataVo courseDataVo);

    /**
     * 修改课程(1.1.0)
     *
     * @param courseDataVo
     * @return
     */
    ResponseMessage editCourseV110(CourseDataVo courseDataVo);

    /**
     * 根据条件更新正在进行中的课程(1.1.0)
     *
     * @return
     */
    ResponseMessage updateByOngoingCourse();

    /**
     * 根据条件更新已结束的课程(1.1.0)
     *
     * @return
     */
    ResponseMessage updateByEndedCourse();

    /**
     * 查询第二天即将开始培训的课程
     *
     * @return
     */
    ResponseMessage findIsAboutToBeginCourse();

    /**
     * 调度更新课程数据
     *
     * @return
     */
    ResponseMessage updateScheduling();


}