package com.union.aimei.app.api.crontab.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.app.api.crontab.service.ScheduleJobService;
import com.union.aimei.common.model.crontab.ScheduleJob;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gaowei
 */
@Api(tags="定时任务表", description = "api")
@RestController
@RequestMapping("/scheduleJobs")
public class ScheduleJobController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScheduleJobService scheduleJobService;

    @ApiOperation("根据ID删除定时任务表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.scheduleJobService.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加定时任务表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody ScheduleJob record) {
        int resultCount = this.scheduleJobService.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新定时任务表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody ScheduleJob record) {
        int resultCount = this.scheduleJobService.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询定时任务表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<ScheduleJob> selectByPrimaryKey(@PathVariable("id") Integer id) {
        ScheduleJob scheduleJob = this.scheduleJobService.selectByPrimaryKey(id);
        return new ResponseMessage<>(scheduleJob);
    }

    @ApiOperation("分页和条件查询定时任务表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<ScheduleJob>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody ScheduleJob record) {
        PageInfo<ScheduleJob> result = this.scheduleJobService.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}