package com.union.aimei.pc.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.pc.financial.service.StoreTradeDetailService;
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
@Api(tags = "店铺流水", description = "api")
@RestController
@RequestMapping("/storeTradeDetails")
public class StoreTradeDetailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StoreTradeDetailService storeTradeDetailService;

    @ApiOperation("根据ID删除店铺流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeTradeDetailService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加店铺流水")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody StoreTradeDetail record) {
        int resultCount = this.storeTradeDetailService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新店铺流水")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody StoreTradeDetail record) {
        int resultCount = this.storeTradeDetailService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询店铺流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public StoreTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id) {
        StoreTradeDetail storeTradeDetail = this.storeTradeDetailService.selectByPrimaryKey(id);
        return storeTradeDetail;
    }

    @ApiOperation("分页和条件查询店铺流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<StoreTradeDetail> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody StoreTradeDetail record) {
        PageInfo<StoreTradeDetail> result = this.storeTradeDetailService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("统计店铺数据")
    @RequestMapping(value = "/selectStoreListByConditions/{statisticsYearMonth}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public PageInfo<StoreTradeStatistics> selectStoreListByConditions(@PathVariable("statisticsYearMonth") String statisticsYearMonth) {
        PageInfo<StoreTradeStatistics> result = this.storeTradeDetailService.selectStoreListByConditions(statisticsYearMonth);
        return result;
    }
}