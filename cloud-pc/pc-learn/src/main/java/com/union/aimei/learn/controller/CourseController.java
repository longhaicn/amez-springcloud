package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.vo.learn.pc.CourseDataVo;
import com.union.aimei.common.vo.learn.pc.CourseDetailVo;
import com.union.aimei.common.vo.learn.pc.CourseParamVo;
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
        return this.courseService.addObj(course);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.courseService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody Course course) {
        return this.courseService.modifyObj(course);
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
        return this.courseService.queryObjById(id);
    }


    /**
     * 课程列表(1.1.0)
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param course   查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "课程列表(1.1.0)")
    @PostMapping("/1.1.0/front/findByPage")
    public PageInfo<Course> findByPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                   @ApiParam(value = "查询条件") @RequestBody Course course) {
        return this.courseService.findByPageForFrontV110(pageNo, pageSize, course);
    }


    /**
     * 根据条件统计课程(1.1.0)
     *
     * @param courseCode 课程编号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据条件统计课程(1.1.0)")
    @GetMapping("/1.1.0/selectCountByCourseCode/{courseCode}")
    public ResponseMessage selectCountByCourseCodeV110(@ApiParam(value = "课程编号") @PathVariable(value = "courseCode") String courseCode) {
        return this.courseService.selectCountByCourseCodeV110(courseCode);
    }

    /**
     * 根据课程id与更新类型更新数据(1.1.0)
     *
     * @param courseId 课程id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据课程id与更新类型更新数据(1.1.0)")
    @GetMapping("/1.1.0/updateStatusEnabledById/{courseId}/{type}")
    public ResponseMessage updateStatusEnabledByIdV110(@ApiParam(value = "课程id") @PathVariable(value = "courseId") Integer courseId,
                                                       @ApiParam(value = "更新类型，1删除 2非删除 3未发布 4已发布 5撤回") @PathVariable(value = "type") Integer type) {
        return this.courseService.updateStatusEnabledByIdV110(courseId, type);
    }

    /**
     * 根据条件查询课程列表 (1.1.0)
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param courseParamVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "课程列表(1.1.0)")
    @PostMapping("/1.1.0/selectPageByCourseV110")
    public ResponseMessage<PageInfo<Course>> selectPageByCourseV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                    @ApiParam(value = "查询条件") @RequestBody CourseParamVo courseParamVo) {
        return this.courseService.selectPageByCourseV110(pageNo, pageSize, courseParamVo);
    }

    /**
     * 根据courseId查询课程详情(1.1.0)
     *
     * @param courseId 课程id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据courseId查询课程详情(1.1.0)")
    @GetMapping("/1.1.0/queryBySourceId/{courseId}")
    public ResponseMessage<CourseDetailVo> selectCourseDetailByIdV110(@PathVariable(value = "courseId") int courseId) {
        return this.courseService.selectCourseDetailByIdV110(courseId);
    }

    /**
     * 发布课程(1.1.0)
     *
     * @param courseDataVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "发布课程(1.1.0)")
    @PostMapping("/1.1.0/insertCourse")
    public ResponseMessage insertCourseV110(@RequestBody CourseDataVo courseDataVo) {
        return this.courseService.insertCourseV110(courseDataVo);
    }

    /**
     * 修改课程(1.1.0)
     *
     * @param courseDataVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "修改课程(1.1.0)")
    @PostMapping("/1.1.0/editCourseV110")
    public ResponseMessage editCourseV110(@RequestBody CourseDataVo courseDataVo) {
        return this.courseService.editCourseV110(courseDataVo);
    }


    /**
     * 调度操作更新状态(V1.1.0)
     *
     * @param
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "调度操作更新状态(1.1.0)")
    @GetMapping("/1.1.0/updateScheduling")
    public ResponseMessage updateScheduling() {
        return this.courseService.updateScheduling();
    }

    /**
     * 查询第二天即将开始培训的课程并发送短信和信息推送
     *
     * @param
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询第二天即将开始培训的课程并发送短信和信息推送")
    @GetMapping("/findIsAboutToBeginCourse")
    public ResponseMessage findIsAboutToBeginCourse() {
        return this.courseService.findIsAboutToBeginCourse();
    }

}