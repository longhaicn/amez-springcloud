package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseOfficialDocuments;
import com.union.aimei.pc.system.service.BaseOfficialDocumentsService;
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
@Api(tags = "文案", description = "api")
@RestController
@RequestMapping("/baseOfficialDocuments")
public class BaseOfficialDocumentsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseOfficialDocumentsService baseOfficialDocumentsService;

    @ApiOperation("根据ID删除文案")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseOfficialDocumentsService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加文案")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseOfficialDocuments record) {
        int resultCount = this.baseOfficialDocumentsService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新文案")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseOfficialDocuments record) {
        int resultCount = this.baseOfficialDocumentsService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询文案")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseOfficialDocuments selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseOfficialDocuments baseOfficialDocuments = this.baseOfficialDocumentsService.selectByPrimaryKey(id);
        return baseOfficialDocuments;
    }

    @ApiOperation("分页和条件查询文案")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseOfficialDocuments> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseOfficialDocuments record) {
        PageInfo<BaseOfficialDocuments> result = this.baseOfficialDocumentsService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}