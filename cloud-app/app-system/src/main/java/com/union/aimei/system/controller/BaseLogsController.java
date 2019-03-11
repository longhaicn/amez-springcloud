package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseLogs;
import com.union.aimei.system.service.BaseLogsService;
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
@Api(tags = "日志表", description = "api")
@RestController
@RequestMapping("/baseLogs")
public class BaseLogsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseLogsService baseLogsService;

    @ApiOperation("根据ID删除日志表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseLogsService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加日志表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseLogs record) {
        int resultCount = this.baseLogsService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新日志表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseLogs record) {
        int resultCount = this.baseLogsService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询日志表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseLogs selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseLogs baseLogs = this.baseLogsService.selectByPrimaryKey(id);
        return baseLogs;
    }

    @ApiOperation("分页和条件查询日志表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseLogs> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseLogs record) {
        PageInfo<BaseLogs> result = this.baseLogsService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}