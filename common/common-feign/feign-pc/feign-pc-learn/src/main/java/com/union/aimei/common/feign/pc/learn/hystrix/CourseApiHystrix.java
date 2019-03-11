package com.union.aimei.common.feign.pc.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.CourseFeign;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.pc.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.pc.CourseDataVo;
import com.union.aimei.common.vo.learn.pc.CourseDetailVo;
import com.union.aimei.common.vo.learn.pc.CourseParamVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "pc-CourseFeign")
public class CourseApiHystrix implements CourseFeign {

    /**
     * 前端分页查询课程表(1.1.0)
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param course   查询条件
     * @return
     */
    @Override
    public PageInfo<Course> findByPageForFrontV110(Integer pageNo, Integer pageSize, Course course) {
        return null;
    }

    @Override
    public ResponseMessage insertCourseV110(CourseDataVo courseDataVo) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage updateSchedulingV110() {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage<List<CourseBeauticianRefResultVo>> findIsAboutToBeginCourse() {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage selectCountByCourseCodeV110(String courseCode) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage updateStatusEnabledByIdV110(Integer courseId, Integer type) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage<PageInfo<Course>> selectPageByCourseV110(Integer pageNo, Integer pageSize, CourseParamVo courseParamVo) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage<CourseDetailVo> selectCourseDetailByIdV110(int courseId) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage editCourseV110(CourseDataVo courseDataVo) {
        return HystrixResponse.invokeFail ();
    }

    /**
     * 添加课程表
     *
     * @param course
     * @return
     */
    @Override
    public int insert(Course course) {
        return 0;
    }

    /**
     * 删除课程表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改课程表
     *
     * @param course
     * @return
     */
    @Override
    public int edit(Course course) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourse
     */
    @Override
    public Course queryByIdV110(int id) {
        return null;
    }
}