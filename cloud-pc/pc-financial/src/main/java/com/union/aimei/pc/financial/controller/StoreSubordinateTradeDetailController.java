package com.union.aimei.pc.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.pc.financial.service.StoreSubordinateTradeDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@Api(tags = "店铺挂靠流水", description = "api")
@RestController
@RequestMapping("/storeSubordinateTradeDetails")
public class StoreSubordinateTradeDetailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StoreSubordinateTradeDetailService storeSubordinateTradeDetailService;

    @ApiOperation("根据ID删除店铺挂靠流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeSubordinateTradeDetailService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加店铺挂靠流水")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody StoreSubordinateTradeDetail record) {
        int resultCount = this.storeSubordinateTradeDetailService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新店铺挂靠流水")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody StoreSubordinateTradeDetail record) {
        int resultCount = this.storeSubordinateTradeDetailService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询店铺挂靠流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public StoreSubordinateTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id) {
        StoreSubordinateTradeDetail storeSubordinateTradeDetail = this.storeSubordinateTradeDetailService.selectByPrimaryKey(id);
        return storeSubordinateTradeDetail;
    }

    @ApiOperation("分页和条件查询店铺挂靠流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<StoreSubordinateTradeDetail> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody StoreSubordinateTradeDetail record) {
        PageInfo<StoreSubordinateTradeDetail> result = this.storeSubordinateTradeDetailService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }
}