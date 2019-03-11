package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.aimei.learn.service.CourseEvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags = "课程试题")
@RestController
@RequestMapping(value = "courseEvaluate")
public class CourseEvaluateController {
    @Resource
    private CourseEvaluateService courseEvaluateService;


    @PostMapping("/insert")
    public int insert(@RequestBody CourseEvaluate courseEvaluate) {
        return this.courseEvaluateService.addObj (courseEvaluate);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.courseEvaluateService.deleteObjById (id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody CourseEvaluate courseEvaluate) {
        return this.courseEvaluateService.modifyObj (courseEvaluate);
    }

    @GetMapping("/queryById/{id}")
    public CourseEvaluate queryById(@PathVariable(value = "id") int id) {
        return this.courseEvaluateService.queryObjById (id);
    }

    /**
     * 前端分页查询课程试题(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param courseEvaluate
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询课程试题(v1.1.0)")
    @PostMapping("/1.1.0/front/findByPage")
    public PageInfo<CourseEvaluate> findByPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                   Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                   Integer pageSize, @ApiParam(value = "查询条件") @RequestBody CourseEvaluate courseEvaluate) {
        return this.courseEvaluateService.findByPageForFrontV110 (pageNo, pageSize, courseEvaluate);
    }
}