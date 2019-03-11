package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.CourseProductRef;
import com.union.aimei.learn.service.CourseProductRefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Api(tags = "课程适用的服务表")
@RestController
@RequestMapping(value = "courseProductRef")
public class CourseProductRefController {
    @Resource
    private CourseProductRefService courseProductRefService;

    @ApiOperation(httpMethod = "POST", value = "查看课程服务关联列表")
    @PostMapping("/front/findByPage")
    public PageInfo<CourseProductRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                 Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                 Integer pageSize, @ApiParam(value = "查询条件") @RequestBody CourseProductRef courseProductRef) {
        return this.courseProductRefService.findByPageForFront (pageNo, pageSize, courseProductRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody CourseProductRef courseProductRef) {
        return this.courseProductRefService.addObj (courseProductRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.courseProductRefService.deleteObjById (id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody CourseProductRef courseProductRef) {
        return this.courseProductRefService.modifyObj (courseProductRef);
    }

    @GetMapping("/queryById/{id}")
    public CourseProductRef queryById(@PathVariable(value = "id") int id) {
        return this.courseProductRefService.queryObjById (id);
    }
}