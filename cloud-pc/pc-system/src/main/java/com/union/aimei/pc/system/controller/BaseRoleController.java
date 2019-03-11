package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRole;
import com.union.aimei.pc.system.service.BaseRoleService;
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
@Api(tags = "角色表", description = "api")
@RestController
@RequestMapping("/baseRoles")
public class BaseRoleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseRoleService baseRoleService;

    @ApiOperation("根据ID删除角色表")
    @RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("roleId") Integer roleId) {
        int resultCount = this.baseRoleService.deleteByPrimaryKey(roleId);
        return resultCount;
    }

    @ApiOperation("添加角色表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseRole record) {
        int resultCount = this.baseRoleService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新角色表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseRole record) {
        int resultCount = this.baseRoleService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询角色表")
    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseRole selectByPrimaryKey(@PathVariable("roleId") Integer roleId) {
        BaseRole baseRole = this.baseRoleService.selectByPrimaryKey(roleId);
        return baseRole;
    }

    @ApiOperation("分页和条件查询角色表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseRole> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseRole record) {
        PageInfo<BaseRole> result = this.baseRoleService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}