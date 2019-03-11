package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseBtnMenusFeign;
import com.union.aimei.common.model.system.BaseBtnMenus;
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
@Api(tags="按钮权限", description = "api")
@RestController
@RequestMapping("/baseBtnMenus")
public class BaseBtnMenusController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseBtnMenusFeign baseBtnMenusFeign;

    @ApiOperation("根据ID删除按钮权限")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseBtnMenusFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加按钮权限")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseBtnMenus record) {
        int resultCount = this.baseBtnMenusFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新按钮权限")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseBtnMenus record) {
        int resultCount = this.baseBtnMenusFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询按钮权限")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseBtnMenus> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseBtnMenus baseBtnMenus = this.baseBtnMenusFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseBtnMenus);
    }

    @ApiOperation("分页和条件查询按钮权限")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseBtnMenus>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseBtnMenus record) {
        PageInfo<BaseBtnMenus> result = this.baseBtnMenusFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}