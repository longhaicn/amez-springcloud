package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestionType;
import com.union.aimei.pc.system.service.BaseQuestionTypeService;
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
@Api(tags = "常见问题分类", description = "api")
@RestController
@RequestMapping("/baseQuestionTypes")
public class BaseQuestionTypeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseQuestionTypeService baseQuestionTypeService;

    @ApiOperation("根据ID删除常见问题分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseQuestionTypeService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加常见问题分类")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseQuestionType record) {
        int resultCount = this.baseQuestionTypeService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新常见问题分类")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseQuestionType record) {
        int resultCount = this.baseQuestionTypeService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询常见问题分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseQuestionType selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseQuestionType baseQuestionType = this.baseQuestionTypeService.selectByPrimaryKey(id);
        return baseQuestionType;
    }

    @ApiOperation("分页和条件查询常见问题分类")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseQuestionType> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseQuestionType record) {
        PageInfo<BaseQuestionType> result = this.baseQuestionTypeService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}