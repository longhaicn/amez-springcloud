package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseOperatorFeign;
import com.union.aimei.common.model.system.BaseOperator;
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
@Api(tags="操作权限表", description = "api")
@RestController
@RequestMapping("/baseOperators")
public class BaseOperatorController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseOperatorFeign baseOperatorFeign;

    @ApiOperation("根据ID删除操作权限表")
    @RequestMapping(value = "/{operId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("operId") Integer operId) {
        int resultCount = this.baseOperatorFeign.deleteByPrimaryKey(operId);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加操作权限表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseOperator record) {
        int resultCount = this.baseOperatorFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新操作权限表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseOperator record) {
        int resultCount = this.baseOperatorFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询操作权限表")
    @RequestMapping(value = "/{operId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseOperator> selectByPrimaryKey(@PathVariable("operId") Integer operId) {
        BaseOperator baseOperator = this.baseOperatorFeign.selectByPrimaryKey(operId);
        return new ResponseMessage<>(baseOperator);
    }

    @ApiOperation("分页和条件查询操作权限表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseOperator>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseOperator record) {
        PageInfo<BaseOperator> result = this.baseOperatorFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}