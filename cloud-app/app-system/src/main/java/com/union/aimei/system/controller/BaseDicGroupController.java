package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.vo.system.app.BaseDicGroupDeatilResVo;
import com.union.aimei.system.service.BaseDicGroupService;
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
@Api(tags = "数据字典表", description = "api")
@RestController
@RequestMapping("/baseDicGroups")
public class BaseDicGroupController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseDicGroupService baseDicGroupService;

    @ApiOperation("根据ID删除数据字典表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseDicGroupService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加数据字典表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseDicGroup record) {
        int resultCount = this.baseDicGroupService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新数据字典表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseDicGroup record) {
        int resultCount = this.baseDicGroupService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询数据字典表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseDicGroup selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseDicGroup baseDicGroup = this.baseDicGroupService.selectByPrimaryKey(id);
        return baseDicGroup;
    }

    @ApiOperation("分页和条件查询数据字典表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseDicGroup> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseDicGroup record) {
        PageInfo<BaseDicGroup> result = this.baseDicGroupService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }


    /**
     * 根据数据字典代码查询数据字典详情
     *
     * @param code 数据字典代码
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据数据字典代码查询数据字典详情")
    @GetMapping(value = "/1.1.1/detailByCode/{code}")
    public ResponseMessage<BaseDicGroupDeatilResVo> detailByCodeV111(@ApiParam(value = "数据字典代码") @PathVariable(value = "code") String code) {
        return this.baseDicGroupService.detailByCodeV111(code);
    }

}