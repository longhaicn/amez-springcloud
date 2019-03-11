package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseDicGroupFeign;
import com.union.aimei.common.model.system.BaseDicGroup;
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
@Api(tags = "数据字典表", description = "api")
@RestController
@RequestMapping("/baseDicGroups")
public class BaseDicGroupController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseDicGroupFeign baseDicGroupFeign;

    @ApiOperation("根据ID删除数据字典表")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.baseDicGroupFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加数据字典表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseDicGroup record) {
        int resultCount = this.baseDicGroupFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新数据字典表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseDicGroup record) {
        int resultCount = this.baseDicGroupFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询数据字典表")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseDicGroup> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BaseDicGroup baseDicGroup = this.baseDicGroupFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(baseDicGroup);
    }

    @ApiOperation("分页和条件查询数据字典表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseDicGroup>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseDicGroup record) {
        PageInfo<BaseDicGroup> result = this.baseDicGroupFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}