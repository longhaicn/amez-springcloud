package com.union.aimei.pc.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.vo.financial.PlatformTradeDetailVo;
import com.union.aimei.pc.financial.service.PlatformTradeDetailService;
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
@Api(tags = "平台交易流水", description = "api")
@RestController
@RequestMapping("/platformTradeDetails")
public class PlatformTradeDetailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlatformTradeDetailService platformTradeDetailService;

    @ApiOperation("根据ID删除平台交易流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.platformTradeDetailService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加平台交易流水")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody PlatformTradeDetail record) {
        int resultCount = this.platformTradeDetailService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新平台交易流水")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody PlatformTradeDetail record) {
        int resultCount = this.platformTradeDetailService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询平台交易流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public PlatformTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id) {
        PlatformTradeDetail platformTradeDetail = this.platformTradeDetailService.selectByPrimaryKey(id);
        return platformTradeDetail;
    }

    @ApiOperation("分页和条件查询平台交易流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<PlatformTradeDetail> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody PlatformTradeDetail record) {
        PageInfo<PlatformTradeDetail> result = this.platformTradeDetailService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("分页和条件查询平台交易流水-后台管理")
    @RequestMapping(value = "/selectPlatformListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<PlatformTradeDetail> selectPlatformListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody PlatformTradeDetailVo record) {
        PageInfo<PlatformTradeDetail> result = this.platformTradeDetailService.selectPlatformListByConditions(pageNo, pageSize, record);
        return result;
    }
}