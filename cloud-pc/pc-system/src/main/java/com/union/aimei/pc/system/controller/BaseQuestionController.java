package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestion;
import com.union.aimei.pc.system.service.BaseQuestionService;
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
@Api(tags = "常见问题", description = "api")
@RestController
@RequestMapping("/baseQuestions")
public class BaseQuestionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseQuestionService baseQuestionService;

    @ApiOperation("根据ID删除常见问题")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseQuestionService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加常见问题")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseQuestion record) {
        int resultCount = this.baseQuestionService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新常见问题")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseQuestion record) {
        int resultCount = this.baseQuestionService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询常见问题")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseQuestion selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseQuestion baseQuestion = this.baseQuestionService.selectByPrimaryKey(id);
        return baseQuestion;
    }

    @ApiOperation("分页和条件查询常见问题")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseQuestion> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseQuestion record) {
        PageInfo<BaseQuestion> result = this.baseQuestionService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("分页和条件查询常见问题")
    @RequestMapping(value = "/selectListByConditionsForBg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<Map<String, Object>> selectListByConditionsForBg(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseQuestion record) {
        PageInfo<Map<String, Object>> result = this.baseQuestionService.selectListByConditionsForBg(pageNo, pageSize, record);
        return result;
    }
}