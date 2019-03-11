package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseQuestionFeign;
import com.union.aimei.common.model.system.BaseQuestion;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.*;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags="常见问题", description = "api")
@RestController
@RequestMapping("/baseQuestions")
public class BaseQuestionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseQuestionFeign baseQuestionFeign;

    @ApiOperation("根据ID删除常见问题")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseQuestionFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加常见问题")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseQuestion record) {
        int resultCount = this.baseQuestionFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新常见问题")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseQuestion record) {
        int resultCount = this.baseQuestionFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询常见问题")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseQuestion> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseQuestion baseQuestion = this.baseQuestionFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseQuestion);
    }

    @ApiOperation("分页和条件查询常见问题")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseQuestion>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseQuestion record) {
        PageInfo<BaseQuestion> result = this.baseQuestionFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    @ApiOperation("分页和条件查询常见问题-后台")
    @RequestMapping(value = "/selectListByConditionsForBg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<Map<String,Object>> selectListByConditionsForBg(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseQuestion record) {
        PageInfo<Map<String,Object>> result = this.baseQuestionFeign.selectListByConditionsForBg(pageNo, pageSize, record);
        return result;
    }
}