package com.union.aimei.pc.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.StoreTradeDetailFeign;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags = "店铺流水", description = "api")
@RestController
@RequestMapping("/storeTradeDetails")
public class StoreTradeDetailApiController {

    @Autowired
    private StoreTradeDetailFeign storeTradeDetailFeign;

    @ApiOperation("根据ID删除店铺流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeTradeDetailFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加店铺流水")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody StoreTradeDetail record) {
        int resultCount = this.storeTradeDetailFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新店铺流水")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody StoreTradeDetail record) {
        int resultCount = this.storeTradeDetailFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询店铺流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<StoreTradeDetail> selectByPrimaryKey(@PathVariable("id") Integer id) {
        StoreTradeDetail storeTradeDetail = this.storeTradeDetailFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(storeTradeDetail);
    }

    @ApiOperation("分页和条件查询店铺流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreTradeDetail>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody StoreTradeDetail record) {
        PageInfo<StoreTradeDetail> result = this.storeTradeDetailFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

}