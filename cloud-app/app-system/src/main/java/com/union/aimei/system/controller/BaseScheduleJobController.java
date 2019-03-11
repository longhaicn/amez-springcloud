package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseScheduleJob;
import com.union.aimei.system.service.BaseScheduleJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author liufeihua
 */
@Api(tags = "定时任务表", description = "api")
@RestController
@RequestMapping("/baseScheduleJobs")
public class BaseScheduleJobController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseScheduleJobService baseScheduleJobService;

    @ApiOperation("根据ID删除定时任务表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseScheduleJobService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加定时任务表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseScheduleJob record) {
        int resultCount = this.baseScheduleJobService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新定时任务表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseScheduleJob record) {
        int resultCount = this.baseScheduleJobService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询定时任务表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseScheduleJob selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseScheduleJob baseScheduleJob = this.baseScheduleJobService.selectByPrimaryKey(id);
        return baseScheduleJob;
    }

    @ApiOperation("分页和条件查询定时任务表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseScheduleJob> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseScheduleJob record) {
        PageInfo<BaseScheduleJob> result = this.baseScheduleJobService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}