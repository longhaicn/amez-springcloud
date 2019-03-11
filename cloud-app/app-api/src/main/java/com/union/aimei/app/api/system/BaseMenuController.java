package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseMenuFeign;
import com.union.aimei.common.model.system.BaseMenu;
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
@Api(tags="基础菜单表", description = "api")
@RestController
@RequestMapping("/baseMenus")
public class BaseMenuController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseMenuFeign baseMenuFeign;

    @ApiOperation("根据ID删除基础菜单表")
    @RequestMapping(value = "/{menuId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("menuId") Integer menuId) {
        int resultCount = this.baseMenuFeign.deleteByPrimaryKey(menuId);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加基础菜单表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseMenu record) {
        int resultCount = this.baseMenuFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新基础菜单表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseMenu record) {
        int resultCount = this.baseMenuFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询基础菜单表")
    @RequestMapping(value = "/{menuId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseMenu> selectByPrimaryKey(@PathVariable("menuId") Integer menuId) {
        BaseMenu baseMenu = this.baseMenuFeign.selectByPrimaryKey(menuId);
        return new ResponseMessage<>(baseMenu);
    }

    @ApiOperation("分页和条件查询基础菜单表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseMenu>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseMenu record) {
        PageInfo<BaseMenu> result = this.baseMenuFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}