package com.union.aimei.pc.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.StoreSubordinateTradeDetailFeign;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags = "店铺挂靠流水", description = "api")
@RestController
@RequestMapping("/storeSubordinateTradeDetails")
public class StoreSubordinateTradeDetailApiController {

    @Autowired
    private StoreSubordinateTradeDetailFeign storeSubordinateTradeDetailFeign;

    @ApiOperation("根据ID删除店铺挂靠流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeSubordinateTradeDetailFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加店铺挂靠流水")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody StoreSubordinateTradeDetail record) {
        int resultCount = this.storeSubordinateTradeDetailFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新店铺挂靠流水")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody StoreSubordinateTradeDetail record) {
        int resultCount = this.storeSubordinateTradeDetailFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询店铺挂靠流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<StoreSubordinateTradeDetail> selectByPrimaryKey(@PathVariable("id") Integer id) {
        StoreSubordinateTradeDetail storeSubordinateTradeDetail = this.storeSubordinateTradeDetailFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(storeSubordinateTradeDetail);
    }

    @ApiOperation("分页和条件查询店铺挂靠流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreSubordinateTradeDetail>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody StoreSubordinateTradeDetail record) {
        PageInfo<StoreSubordinateTradeDetail> result = this.storeSubordinateTradeDetailFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }
}