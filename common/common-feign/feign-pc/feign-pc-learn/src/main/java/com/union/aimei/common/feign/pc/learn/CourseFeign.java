package com.union.aimei.common.feign.pc.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.hystrix.CourseApiHystrix;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.pc.CourseBeauticianRefResultVo;
import com.union.aimei.common.vo.learn.pc.CourseDataVo;
import com.union.aimei.common.vo.learn.pc.CourseDetailVo;
import com.union.aimei.common.vo.learn.pc.CourseParamVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程表
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@FeignClient(serviceId = "PC-LEARN-SERVICE", fallback = CourseApiHystrix.class)
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
    Course queryByIdV110(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询课程表(1.1.0)
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param course   查询条件
     * @return
     */
    @PostMapping(value = "/course/1.1.0/front/findByPage")
    PageInfo<Course> findByPageForFrontV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                            @RequestBody Course course);


    /**
     * 判断课程编号是否重复(1.1.0)
     *
     * @param courseCode 课程编号
     * @return
     */
    @GetMapping("/course/1.1.0/selectCountByCourseCode/{courseCode}")
    ResponseMessage selectCountByCourseCodeV110(@PathVariable(value = "courseCode") String courseCode);

    /**
     * 根据课程id与更新类型 更新课程课时(1.1.0)
     *
     * @param courseId 课程id
     * @param type     类型
     * @return
     */
    @GetMapping("/course/1.1.0/updateStatusEnabledById/{courseId}/{type}")
    ResponseMessage updateStatusEnabledByIdV110(@PathVariable(value = "courseId") Integer courseId, @PathVariable(value = "type") Integer type);

    /**
     * 根据条件查询课程列表 (1.1.0)
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param courseParamVo 查询条件
     * @return
     */
    @PostMapping("/course/1.1.0/selectPageByCourseV110")
    ResponseMessage<PageInfo<Course>> selectPageByCourseV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                             @RequestBody CourseParamVo courseParamVo);

    /**
     * 根据courseId查询课程详情(1.1.0)
     *
     * @param courseId 课程id
     * @return
     */
    @GetMapping("/course/1.1.0/queryBySourceId/{courseId}")
    ResponseMessage<CourseDetailVo> selectCourseDetailByIdV110(@PathVariable(value = "courseId") int courseId);

    /**
     * 修改课程(1.1.0)
     *
     * @param courseDataVo
     * @return
     */
    @PostMapping("/course/1.1.0/editCourseV110")
    ResponseMessage editCourseV110(@RequestBody CourseDataVo courseDataVo);

    /**
     * 发布课程(1.1.0)
     *
     * @param courseDataVo
     * @return
     */
    @PostMapping("/course/1.1.0/insertCourse")
    ResponseMessage insertCourseV110(@RequestBody CourseDataVo courseDataVo);


    /**
     * 调度操作更新状态(V1.1.0)
     *
     * @param
     * @return
     */
    @GetMapping("/course/1.1.0/updateScheduling")
    ResponseMessage updateSchedulingV110();

    /**
     * 查询第二天即将开始培训的课程
     *
     * @param
     * @return
     */
    @GetMapping("/course/findIsAboutToBeginCourse")
    ResponseMessage<List<CourseBeauticianRefResultVo>> findIsAboutToBeginCourse();
}