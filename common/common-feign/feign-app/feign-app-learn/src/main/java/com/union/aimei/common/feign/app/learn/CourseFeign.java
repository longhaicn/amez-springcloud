package com.union.aimei.common.feign.app.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.hystrix.CourseApiHystrix;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.app.CourseParamVo;
import com.union.aimei.common.vo.learn.app.CourseResultVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 课程表
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@FeignClient(serviceId = "APP-LEARN-SERVICE", fallback = CourseApiHystrix.class)
public interface CourseFeign {
    /**
     * 添加课程表
     *
     * @param course
     * @return
     */
    @PostMapping(value = "/course/insert")
    int insert(@RequestBody Course course);

    /**
     * 删除课程表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/course/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改课程表
     *
     * @param course
     * @return
     */
    @PutMapping(value = "/course/edit")
    int edit(@RequestBody Course course);

    /**
     * 根据ID查询
     *
     * @param id
     * @returncourse
     */
    @GetMapping(value = "/course/1.1.0/queryById/{id}")
    Course queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询课程表1.1.0
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param course   查询条件
     * @return
     */
    @PostMapping(value = "/course/1.1.0/front/findByPage")
    PageInfo<Course> findByPageForFrontV110(@RequestParam(value = "pageNo", defaultValue = "0")
                                                    Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                    Integer pageSize, @RequestBody Course course);

    /**
     * 查询培训课程列表1.1.0
     *
     * @param pageNo        分页索引
     * @param pageSize      每页数量
     * @param courseParamVo 查询条件
     * @return
     */
    @PostMapping("/course/1.1.0/selectCourseListByBeautic")
    ResponseMessage<PageInfo<CourseResultVo>> selectCourseListByBeauticV110(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                                    Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                    Integer pageSize, @RequestBody CourseParamVo courseParamVo);

    /**
     * 根据courseId、美容师id查询课程详情(1.1.0)
     *
     * @param id
     * @param beauticianId
     * @returncourse
     */
    @GetMapping(value = "/course/1.1.0/queryCourseResultVoById/{id}/{beauticianId}")
    ResponseMessage<CourseResultVo> selectByCourseIdV110(@PathVariable(value = "id") int id,
                                                         @PathVariable(value = "beauticianId") int beauticianId);



}