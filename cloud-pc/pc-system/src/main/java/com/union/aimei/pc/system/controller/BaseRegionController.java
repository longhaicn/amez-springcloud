package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.pc.system.service.BaseRegionService;
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
@Api(tags = "全球地区表", description = "api")
@RestController
@RequestMapping("/baseRegions")
public class BaseRegionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseRegionService baseRegionService;

    @ApiOperation("根据ID删除全球地区表")
    @RequestMapping(value = "/{regionId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("regionId") Integer regionId) {
        int resultCount = this.baseRegionService.deleteByPrimaryKey(regionId);
        return resultCount;
    }

    @ApiOperation("添加全球地区表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseRegion record) {
        int resultCount = this.baseRegionService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新全球地区表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseRegion record) {
        int resultCount = this.baseRegionService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询全球地区表")
    @RequestMapping(value = "/{regionId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseRegion selectByPrimaryKey(@PathVariable("regionId") Integer regionId) {
        BaseRegion baseRegion = this.baseRegionService.selectByPrimaryKey(regionId);
        return baseRegion;
    }

    @ApiOperation("分页和条件查询全球地区表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseRegion> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseRegion record) {
        PageInfo<BaseRegion> result = this.baseRegionService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}