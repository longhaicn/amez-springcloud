package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRoleResources;
import com.union.aimei.system.service.BaseRoleResourcesService;
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
@Api(tags = "角色权限表", description = "api")
@RestController
@RequestMapping("/baseRoleResources")
public class BaseRoleResourcesController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseRoleResourcesService baseRoleResourcesService;

    @ApiOperation("根据ID删除角色权限表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseRoleResourcesService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加角色权限表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseRoleResources record) {
        int resultCount = this.baseRoleResourcesService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新角色权限表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseRoleResources record) {
        int resultCount = this.baseRoleResourcesService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询角色权限表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseRoleResources selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseRoleResources baseRoleResources = this.baseRoleResourcesService.selectByPrimaryKey(id);
        return baseRoleResources;
    }

    @ApiOperation("分页和条件查询角色权限表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseRoleResources> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseRoleResources record) {
        PageInfo<BaseRoleResources> result = this.baseRoleResourcesService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}