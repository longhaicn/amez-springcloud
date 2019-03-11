package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseMenu;
import com.union.aimei.pc.system.service.BaseMenuService;
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
@Api(tags = "基础菜单表", description = "api")
@RestController
@RequestMapping("/baseMenus")
public class BaseMenuController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseMenuService baseMenuService;

    @ApiOperation("根据ID删除基础菜单表")
    @RequestMapping(value = "/{menuId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("menuId") Integer menuId) {
        int resultCount = this.baseMenuService.deleteByPrimaryKey(menuId);
        return resultCount;
    }

    @ApiOperation("添加基础菜单表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseMenu record) {
        int resultCount = this.baseMenuService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新基础菜单表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseMenu record) {
        int resultCount = this.baseMenuService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询基础菜单表")
    @RequestMapping(value = "/{menuId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseMenu selectByPrimaryKey(@PathVariable("menuId") Integer menuId) {
        BaseMenu baseMenu = this.baseMenuService.selectByPrimaryKey(menuId);
        return baseMenu;
    }

    @ApiOperation("分页和条件查询基础菜单表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseMenu> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseMenu record) {
        PageInfo<BaseMenu> result = this.baseMenuService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}