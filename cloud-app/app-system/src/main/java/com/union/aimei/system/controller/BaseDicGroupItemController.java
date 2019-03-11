package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.system.service.BaseDicGroupItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liufeihua
 */
@Api(tags = "数据字典子项表", description = "api")
@RestController
@RequestMapping("/baseDicGroupItems")
public class BaseDicGroupItemController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseDicGroupItemService baseDicGroupItemService;

    @ApiOperation("根据ID删除数据字典子项表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseDicGroupItemService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加数据字典子项表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BaseDicGroupItem record) {
        int resultCount = this.baseDicGroupItemService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新数据字典子项表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BaseDicGroupItem record) {
        int resultCount = this.baseDicGroupItemService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询数据字典子项表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseDicGroupItem selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseDicGroupItem baseDicGroupItem = this.baseDicGroupItemService.selectByPrimaryKey(id);
        return baseDicGroupItem;
    }

    @ApiOperation("分页和条件查询数据字典子项表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BaseDicGroupItem> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseDicGroupItem record) {
        PageInfo<BaseDicGroupItem> result = this.baseDicGroupItemService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    /**
     * describe: 查询
     * create_by: liufeihua in 2017/11/29 16:22
     **/
    @ApiOperation("查看数据字典子项表信息信息")
    @GetMapping("/findListByCode/{bandCode}")
    public List<BaseDicGroupItem> findListByCode(@PathVariable("bandCode") String bandCode) {
        return baseDicGroupItemService.findListByCode(bandCode);
    }
}