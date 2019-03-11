package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseRoleResourcesFeign;
import com.union.aimei.common.model.system.BaseRoleResources;
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
@Api(tags = "角色权限表", description = "api")
@RestController
@RequestMapping("/baseRoleResources")
public class BaseRoleResourcesController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseRoleResourcesFeign baseRoleResourcesFeign;

    @ApiOperation("根据ID删除角色权限表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseRoleResourcesFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加角色权限表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseRoleResources record) {
        int resultCount = this.baseRoleResourcesFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新角色权限表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseRoleResources record) {
        int resultCount = this.baseRoleResourcesFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询角色权限表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseRoleResources> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseRoleResources baseRoleResources = this.baseRoleResourcesFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseRoleResources);
    }

    @ApiOperation("分页和条件查询角色权限表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseRoleResources>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseRoleResources record) {
        PageInfo<BaseRoleResources> result = this.baseRoleResourcesFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    /**
     * param:角色id
     * param:权限ids数组
     * describe: 分配角色权限信息
     * create_by: liufeihua in 2017/12/1 11:10
     */
    @ApiOperation("分配角色权限信息")
    @GetMapping("/distributionBaseRoleResources")
    public ResponseMessage<String> distributionBaseRoleResources(@ApiParam(value = "角色id") @RequestParam(value = "roleId")Integer roleId,
                                                                 @ApiParam(value = "权限id") @RequestParam(value = "resourcesIds")String resourcesIds) {
        return baseRoleResourcesFeign.distributionBaseRoleResources(roleId, resourcesIds);
    }
}