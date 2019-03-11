package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseBtnMenus;
import com.union.aimei.pc.system.service.BaseBtnMenusService;
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
@Api(tags = "按钮权限", description = "api")
@RestController
@RequestMapping("/baseBtnMenus")
public class BaseBtnMenusController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseBtnMenusService baseBtnMenusService;

    @ApiOperation("根据ID删除按钮权限")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseBtnMenusService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加按钮权限")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseBtnMenus record) {
        int resultCount = this.baseBtnMenusService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新按钮权限")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseBtnMenus record) {
        int resultCount = this.baseBtnMenusService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询按钮权限")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseBtnMenus selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseBtnMenus baseBtnMenus = this.baseBtnMenusService.selectByPrimaryKey(id);
        return baseBtnMenus;
    }

    @ApiOperation("分页和条件查询按钮权限")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseBtnMenus> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseBtnMenus record) {
        PageInfo<BaseBtnMenus> result = this.baseBtnMenusService.selectListByConditions(pageNo, pageSize, record);
        logger.debug(result.getList().toString());
        return result;
    }
}