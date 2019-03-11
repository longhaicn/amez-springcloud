package com.union.aimei.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.financial.service.StoreshipWithdrawalService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author liufeihua
 */
@Api(tags = "店铺提现", description = "api")
@RestController
@RequestMapping("/storeshipWithdrawals")
public class StoreshipWithdrawalController {

    @Autowired
    private StoreshipWithdrawalService storeshipWithdrawalService;

    @ApiOperation("根据ID删除店铺提现")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeshipWithdrawalService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加店铺提现")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody StoreshipWithdrawal record) {
        int resultCount = this.storeshipWithdrawalService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新店铺提现")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody StoreshipWithdrawal record) {
        int resultCount = this.storeshipWithdrawalService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询店铺提现")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public StoreshipWithdrawal selectByPrimaryKey(@PathVariable("id") Integer id) {
        StoreshipWithdrawal storeshipWithdrawal = this.storeshipWithdrawalService.selectByPrimaryKey(id);
        return storeshipWithdrawal;
    }

    @ApiOperation("分页和条件查询店铺提现")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<StoreshipWithdrawal> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody StoreshipWithdrawal record) {
        PageInfo<StoreshipWithdrawal> result = this.storeshipWithdrawalService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("根据条件查询列表（V1.1.0）")
    @RequestMapping(value = "/1.1.0/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<List<StoreshipWithdrawal>> selectListByConditionsV110(@RequestBody StoreshipWithdrawal record) {
        return this.storeshipWithdrawalService.selectListByConditionsV110(record);
    }


}