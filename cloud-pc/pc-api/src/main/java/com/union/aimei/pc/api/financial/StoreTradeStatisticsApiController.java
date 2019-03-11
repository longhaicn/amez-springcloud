package com.union.aimei.pc.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.StoreTradeStatisticsFeign;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
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
@Api(tags = "店铺流水统计", description = "api")
@RestController
@RequestMapping("/storeTradeStatistics")
public class StoreTradeStatisticsApiController {

    @Autowired
    private StoreTradeStatisticsFeign storeTradeStatisticsFeign;

    @ApiOperation("根据ID删除店铺流水统计")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeTradeStatisticsFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("添加店铺流水统计")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody StoreTradeStatistics record) {
        int resultCount = this.storeTradeStatisticsFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新店铺流水统计")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody StoreTradeStatistics record) {
        int resultCount = this.storeTradeStatisticsFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询店铺流水统计")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<StoreTradeStatistics> selectByPrimaryKey(@PathVariable("id") Integer id) {
        StoreTradeStatistics storeTradeStatistics = this.storeTradeStatisticsFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(storeTradeStatistics);
    }

    @ApiOperation("分页和条件查询店铺流水统计")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreTradeStatistics>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody StoreTradeStatistics record) {
        PageInfo<StoreTradeStatistics> result = this.storeTradeStatisticsFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    @ApiOperation("批量打款")
    @RequestMapping(value = "/batchMoney/{ids}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<String> batchMoney(@PathVariable("ids") String ids) {
        return this.storeTradeStatisticsFeign.batchMoney(ids);
    }

    @ApiOperation("批量打款（V1.1.0）")
    @RequestMapping(value = "/1.1.0/batchMoney", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage batchMoneyV110(@RequestBody List<Integer> idList) {
        return this.storeTradeStatisticsFeign.batchMoneyV110(idList);
    }
}