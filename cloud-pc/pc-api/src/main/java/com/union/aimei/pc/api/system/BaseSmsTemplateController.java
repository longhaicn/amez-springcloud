package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseSmsTemplateFeign;
import com.union.aimei.common.model.system.BaseSmsTemplate;
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
@Api(tags="短信模板表", description = "api")
@RestController
@RequestMapping("/baseSmsTemplates")
public class BaseSmsTemplateController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseSmsTemplateFeign baseSmsTemplateFeign;

    @ApiOperation("根据ID删除短信模板表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseSmsTemplateFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加短信模板表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseSmsTemplate record) {
        int resultCount = this.baseSmsTemplateFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新短信模板表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseSmsTemplate record) {
        int resultCount = this.baseSmsTemplateFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询短信模板表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseSmsTemplate> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseSmsTemplate baseSmsTemplate = this.baseSmsTemplateFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseSmsTemplate);
    }

    @ApiOperation("分页和条件查询短信模板表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseSmsTemplate>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseSmsTemplate record) {
        PageInfo<BaseSmsTemplate> result = this.baseSmsTemplateFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}