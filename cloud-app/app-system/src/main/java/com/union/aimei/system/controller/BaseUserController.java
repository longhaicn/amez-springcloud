package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.system.service.BaseUserService;
import com.union.aimei.common.vo.system.BaseUserVo;
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
@Api(tags = "用户表", description = "api")
@RestController
@RequestMapping("/baseUsers")
public class BaseUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseUserService baseUserService;

    @ApiOperation("根据ID删除用户表")
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("userId") Integer userId) {
        int resultCount = this.baseUserService.deleteByPrimaryKey(userId);
        return resultCount;
    }

    @ApiOperation("添加用户表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseUser> insertSelective(@RequestBody BaseUser record) {
        ResponseMessage<BaseUser> resultCount = this.baseUserService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新用户表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseUser record) {
        int resultCount = this.baseUserService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询用户表")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseUser selectByPrimaryKey(@PathVariable("userId") Integer userId) {
        BaseUser baseUser = this.baseUserService.selectByPrimaryKey(userId);
        return baseUser;
    }

    @ApiOperation("分页和条件查询用户表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseUser> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseUser record) {
        PageInfo<BaseUser> result = this.baseUserService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("添加老板,店长,者员工")
    @RequestMapping(value = "/insertBbossAndShopkeeperAndMember", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseUser> insertBbossAndShopkeeperAndMember(@RequestBody BaseUserVo record) {
        return this.baseUserService.insertBbossAndShopkeeperAndMember(record);
    }

}