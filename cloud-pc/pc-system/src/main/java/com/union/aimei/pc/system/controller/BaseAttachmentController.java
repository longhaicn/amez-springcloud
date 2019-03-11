package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAttachment;
import com.union.aimei.pc.system.service.BaseAttachmentService;
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
@Api(tags = "方案附件表", description = "api")
@RestController
@RequestMapping("/baseAttachments")
public class BaseAttachmentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseAttachmentService baseAttachmentService;

    @ApiOperation("根据ID删除方案附件表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseAttachmentService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加方案附件表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseAttachment record) {
        int resultCount = this.baseAttachmentService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新方案附件表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseAttachment record) {
        int resultCount = this.baseAttachmentService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询方案附件表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseAttachment selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseAttachment baseAttachment = this.baseAttachmentService.selectByPrimaryKey(id);
        return baseAttachment;
    }

    @ApiOperation("分页和条件查询方案附件表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseAttachment> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseAttachment record) {
        PageInfo<BaseAttachment> result = this.baseAttachmentService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}