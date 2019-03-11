package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseRegionFeign;
import com.union.aimei.common.model.system.BaseRegion;
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
@Api(tags = "全球地区表", description = "api")
@RestController
@RequestMapping("/baseRegions")
public class BaseRegionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseRegionFeign baseRegionFeign;

    @ApiOperation("根据ID删除全球地区表")
    @RequestMapping(value = "/{regionId}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("regionId") Integer regionId) {
        int resultCount = this.baseRegionFeign.deleteByPrimaryKey(regionId);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加全球地区表")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BaseRegion record) {
        int resultCount = this.baseRegionFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新全球地区表")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BaseRegion record) {
        int resultCount = this.baseRegionFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询全球地区表")
    @RequestMapping(value = "/{regionId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BaseRegion> selectByPrimaryKey(@PathVariable("regionId") Integer regionId) {
        BaseRegion baseRegion = this.baseRegionFeign.selectByPrimaryKey(regionId);
        return new ResponseMessage<>(baseRegion);
    }

    @ApiOperation("分页和条件查询全球地区表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BaseRegion>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BaseRegion record) {
        PageInfo<BaseRegion> result = this.baseRegionFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}