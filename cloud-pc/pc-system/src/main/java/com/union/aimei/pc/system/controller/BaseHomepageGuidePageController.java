package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomepageGuidePage;
import com.union.aimei.pc.system.service.BaseHomepageGuidePageService;
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
@Api(tags = "首页引导页", description = "api")
@RestController
@RequestMapping("/baseHomepageGuidePages")
public class BaseHomepageGuidePageController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseHomepageGuidePageService baseHomepageGuidePageService;

    @ApiOperation("根据ID删除首页引导页")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseHomepageGuidePageService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加首页引导页")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseHomepageGuidePage record) {
        int resultCount = this.baseHomepageGuidePageService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新首页引导页")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseHomepageGuidePage record) {
        int resultCount = this.baseHomepageGuidePageService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询首页引导页")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseHomepageGuidePage selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseHomepageGuidePage baseHomepageGuidePage = this.baseHomepageGuidePageService.selectByPrimaryKey(id);
        return baseHomepageGuidePage;
    }

    @ApiOperation("分页和条件查询首页引导页")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseHomepageGuidePage> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseHomepageGuidePage record) {
        PageInfo<BaseHomepageGuidePage> result = this.baseHomepageGuidePageService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}