package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseOperator;
import com.union.aimei.system.service.BaseOperatorService;
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
@Api(tags = "操作权限表", description = "api")
@RestController
@RequestMapping("/baseOperators")
public class BaseOperatorController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseOperatorService baseOperatorService;

    @ApiOperation("根据ID删除操作权限表")
    @RequestMapping(value = "/{operId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("operId") Integer operId) {
        int resultCount = this.baseOperatorService.deleteByPrimaryKey(operId);
        return resultCount;
    }

    @ApiOperation("添加操作权限表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseOperator record) {
        int resultCount = this.baseOperatorService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新操作权限表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseOperator record) {
        int resultCount = this.baseOperatorService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询操作权限表")
    @RequestMapping(value = "/{operId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseOperator selectByPrimaryKey(@PathVariable("operId") Integer operId) {
        BaseOperator baseOperator = this.baseOperatorService.selectByPrimaryKey(operId);
        return baseOperator;
    }

    @ApiOperation("分页和条件查询操作权限表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseOperator> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseOperator record) {
        PageInfo<BaseOperator> result = this.baseOperatorService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}