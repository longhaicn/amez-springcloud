package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseUserRoleFeign;
import com.union.aimei.common.model.system.BaseUserRole;
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
    private BaseUserRoleFeign baseUserRoleFeign;

    @ApiOperation("根据ID删除用户角色关联表")
    @RequestMapping(value = "/{rightId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("rightId") Integer rightId) {
        int resultCount = this.baseUserRoleFeign.deleteByPrimaryKey(rightId);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加用户角色关联表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseUserRole record) {
        int resultCount = this.baseUserRoleFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新用户角色关联表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseUserRole record) {
        int resultCount = this.baseUserRoleFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询用户角色关联表")
    @RequestMapping(value = "/{rightId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseUserRole> selectByPrimaryKey(@PathVariable("rightId") Integer rightId) {
        BaseUserRole baseUserRole = this.baseUserRoleFeign.selectByPrimaryKey(rightId);
        return new ResponseMessage<>(baseUserRole);
    }

    @ApiOperation("分页和条件查询用户角色关联表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseUserRole>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseUserRole record) {
        PageInfo<BaseUserRole> result = this.baseUserRoleFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
    /**
     * param: userId用户id
     * param: roleIds角色数组
     * describe: TODO
     * create_by: liufeihua in 2017/12/11 11:15
     */
    @ApiOperation("给用户分配角色")
    @GetMapping("/distributionBaseUserRole")
    public ResponseMessage<String> distributionBaseUserRole(@ApiParam(value = "用户id") @RequestParam(value = "userId")Integer userId,
                                                            @ApiParam(value = "角色id") @RequestParam(value = "roleIds")String roleIds) {
        return baseUserRoleFeign.distributionBaseUserRole(userId, roleIds);
    }

    /**
     * param: userId 用户id
     * describe: TODO
     * create_by: liufeihua in 2017/12/11 11:15
     */
    @GetMapping("/findBaseUserRoles/{userId}")
    public ResponseMessage<Map<String, Object>> findBaseUserRoles(@ApiParam(value = "userId用户id") @PathVariable(value = "userId") Integer userId) {
        return baseUserRoleFeign.findBaseUserRoles(userId);
    }
}