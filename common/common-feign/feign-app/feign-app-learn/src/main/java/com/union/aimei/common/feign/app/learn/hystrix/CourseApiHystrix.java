package com.union.aimei.common.feign.app.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.CourseFeign;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.app.CourseParamVo;
import com.union.aimei.common.vo.learn.app.CourseResultVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 查询课程表
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Component(value = "app-CourseFeign")
public class CourseApiHystrix implements CourseFeign {

    /**
     * 前端分页查询课程表
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
    public ResponseMessage<PageInfo<CourseResultVo>> selectCourseListByBeauticV110(Integer pageNo, Integer pageSize, CourseParamVo courseParamVo) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage<CourseResultVo> selectByCourseIdV110(int id,int beauticianId) {
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
    public Course queryById(int id) {
        return null;
    }
}