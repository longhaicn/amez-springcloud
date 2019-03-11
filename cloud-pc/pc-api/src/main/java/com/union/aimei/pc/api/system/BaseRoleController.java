package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseRoleFeign;
import com.union.aimei.common.model.system.BaseRole;
import com.union.common.utils.ResponseMessage;
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
    private BaseRoleFeign baseRoleFeign;

    @ApiOperation("根据ID删除角色表")
    @RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("roleId") Integer roleId) {
        int resultCount = this.baseRoleFeign.deleteByPrimaryKey(roleId);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加角色表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseRole record) {
        int resultCount = this.baseRoleFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新角色表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseRole record) {
        int resultCount = this.baseRoleFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询角色表")
    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseRole> selectByPrimaryKey(@PathVariable("roleId") Integer roleId) {
        BaseRole baseRole = this.baseRoleFeign.selectByPrimaryKey(roleId);
        return new ResponseMessage<>(baseRole);
    }

    @ApiOperation("分页和条件查询角色表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseRole>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseRole record) {
        PageInfo<BaseRole> result = this.baseRoleFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}