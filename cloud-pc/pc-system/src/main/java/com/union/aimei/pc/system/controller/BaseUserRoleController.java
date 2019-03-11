package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseUserRole;
import com.union.aimei.pc.system.service.BaseUserRoleService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author liufeihua
 */
@Api(tags = "用户角色关联表", description = "api")
@RestController
@RequestMapping("/baseUserRoles")
public class BaseUserRoleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseUserRoleService baseUserRoleService;

    @ApiOperation("根据ID删除用户角色关联表")
    @RequestMapping(value = "/{rightId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("rightId") Integer rightId) {
        int resultCount = this.baseUserRoleService.deleteByPrimaryKey(rightId);
        return resultCount;
    }

    @ApiOperation("添加用户角色关联表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseUserRole record) {
        int resultCount = this.baseUserRoleService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新用户角色关联表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseUserRole record) {
        int resultCount = this.baseUserRoleService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询用户角色关联表")
    @RequestMapping(value = "/{rightId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseUserRole selectByPrimaryKey(@PathVariable("rightId") Integer rightId) {
        BaseUserRole baseUserRole = this.baseUserRoleService.selectByPrimaryKey(rightId);
        return baseUserRole;
    }

    @ApiOperation("分页和条件查询用户角色关联表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseUserRole> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseUserRole record) {
        PageInfo<BaseUserRole> result = this.baseUserRoleService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    /**
     * param: userId用户id
     * param: roleIds角色数组
     * describe: TODO
     * create_by: liufeihua in 2017/12/11 11:15
     */
    @GetMapping("/distributionBaseUserRole")
    public ResponseMessage<String> distributionBaseUserRole(@ApiParam(value = "用户id") @RequestParam(value = "userId") Integer userId,
                                                            @ApiParam(value = "角色id") @RequestParam(value = "roleIds") String roleIds) {
        return baseUserRoleService.distributionBaseUserRole(userId, roleIds);
    }

    /**
     * param: userId 用户id
     * describe: TODO
     * create_by: liufeihua in 2017/12/11 11:15
     */
    @GetMapping("/findBaseUserRoles/{userId}")
    public ResponseMessage<Map<String, Object>> findBaseUserRoles(@ApiParam(value = "userId用户id") @PathVariable(value = "userId") Integer userId) {
        return baseUserRoleService.findBaseUserRoles(userId);
    }
}