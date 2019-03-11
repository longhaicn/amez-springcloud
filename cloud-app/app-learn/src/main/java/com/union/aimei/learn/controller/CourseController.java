package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.app.CourseParamVo;
import com.union.aimei.common.vo.learn.app.CourseResultVo;
import com.union.aimei.learn.service.CourseService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags = "课程表")
@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @PostMapping("/insert")
    public int insert(@RequestBody Course course) {
        return this.courseService.addObj (course);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.courseService.deleteObjById (id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody Course course) {
        return this.courseService.modifyObj (course);
    }


    /**
     * 根据ID查询课程(1.1.0)
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询课程(1.1.0)")
    @GetMapping("/1.1.0/queryById/{id}")
    public Course queryByIdV110(@PathVariable(value = "id") int id) {
        return this.courseService.queryObjById (id);
    }

    /**
     * 根据courseId、美容师id查询课程详情(1.1.0)
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据courseId、美容师id查询课程详情(1.1.0)")
    @GetMapping("/1.1.0/queryCourseResultVoById/{id}/{beauticianId}")
    public ResponseMessage<CourseResultVo> selectByCourseIdV110(@PathVariable(value = "id") int id,
                                                                @PathVariable(value = "beauticianId") int beauticianId) {
        return this.courseService.selectByCourseIdV110 (id,beauticianId);
    }

    /**
     * 前端分页查询课程表(1.1.0)
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param course   查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询课程表(1.1.0)")
    @PostMapping("/1.1.0/front/findByPage")
    public PageInfo<Course> findByPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                   @ApiParam(value = "查询条件") @RequestBody Course course) {
        return this.courseService.findByPageForFrontV110 (pageNo, pageSize, course);
    }



    /**
     * 查询培训课程列表(1.1.0)
     *
     * @param pageNo        分页索引
     * @param pageSize      每页数量
     * @param courseParamVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询培训课程列表1.1.0")
    @PostMapping("/1.1.0/selectCourseListByBeautic")
    public ResponseMessage<PageInfo<CourseResultVo>> selectCourseListByBeauticV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody CourseParamVo courseParamVo) {
        return this.courseService.selectCourseListByBeauticV110 (pageNo, pageSize, courseParamVo);
    }

}