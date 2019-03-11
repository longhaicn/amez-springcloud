package com.union.aimei.pc.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.StoreshipWithdrawalFeign;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags = "店铺提现", description = "api")
@RestController
@RequestMapping("/storeshipWithdrawals")
public class StoreshipWithdrawalApiController {

    @Autowired
    private StoreshipWithdrawalFeign storeshipWithdrawalFeign;

    @ApiOperation("根据ID删除店铺提现")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeshipWithdrawalFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加店铺提现")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody StoreshipWithdrawal record) {
        int resultCount = this.storeshipWithdrawalFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新店铺提现")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody StoreshipWithdrawal record) {
        int resultCount = this.storeshipWithdrawalFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询店铺提现")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<StoreshipWithdrawal> selectByPrimaryKey(@PathVariable("id") Integer id) {
        StoreshipWithdrawal storeshipWithdrawal = this.storeshipWithdrawalFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(storeshipWithdrawal);
    }

    @ApiOperation("分页和条件查询店铺提现")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreshipWithdrawal>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody StoreshipWithdrawal record) {
        PageInfo<StoreshipWithdrawal> result = this.storeshipWithdrawalFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}