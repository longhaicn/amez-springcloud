package com.union.aimei.app.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.StoreTradeDetailFeign;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author liufeihua
 */
@Api(tags = "店铺流水", description = "api")
@RestController
@RequestMapping("/storeTradeDetails")
public class StoreTradeDetailApiController {


    @Autowired
    private StoreTradeDetailFeign storeTradeDetailFeign;

    @ApiOperation("分页和条件查询店铺流水（已结算）(v1.1.0)")
    @RequestMapping(value = "/v1.1.0/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreTradeDetail>> selectListByConditionsV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                  @RequestBody StoreTradeDetail record) {
        PageInfo<StoreTradeDetail> result = this.storeTradeDetailFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    @ApiOperation("分页和条件查询店铺流水（待结算）(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectListBySettlementStatus", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreTradeDetail>> selectListBySettlementStatusV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                        @RequestBody StoreTradeDetail record) {
        return this.storeTradeDetailFeign.selectListBySettlementStatusV110(pageNo, pageSize, record);
    }

    @ApiOperation(httpMethod = "POST", value = "app门店端的营业统计(v1.1.0)", notes = "app门店端的营业统计(v1.1.0)")
    @PostMapping("/1.1.0/queryStorePerformance")
    public ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformanceV110(@RequestBody QueryProjectPerformanceVo vo) {
        return this.storeTradeDetailFeign.queryStorePerformance(vo);
    }

    @ApiOperation(httpMethod = "POST", value = "app门店端的营业统计中的项目业绩(v1.1.0)", notes = "app门店端的营业统计中的项目业绩(v1.1.0)")
    @PostMapping("/1.1.0/queryProjectPerformance")
    public ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformanceV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                                    @RequestBody QueryProjectPerformanceVo vo) {
        return this.storeTradeDetailFeign.queryProjectPerformance(pageNo, pageSize, vo);
    }


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


    @ApiOperation("根据ID查询店铺流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<QueryStoreTradeDetailVo> selectByPrimaryKeyV110(@PathVariable("id") Integer id) {
        return this.storeTradeDetailFeign.selectByPrimaryKeyV110(id);
    }


    /**
     * 查询店铺资产
     *
     * @param storeId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询店铺资产")
    @GetMapping(value = "queryStoreAssertInfo/{storeId}")
    public ResponseMessage<StoreAssertVo> queryStoreAssertInfo(@PathVariable(value = "storeId") Integer storeId) {
        return storeTradeDetailFeign.queryStoreAssertInfo(storeId);
    }


    /**
     * 查询店铺年月账单信息
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询店铺月账单信息", notes = "根据返回是否为净收入和净支出字段展示+或者-")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "storeId", value = "店铺ID", defaultValue = "1", paramType = "path"),
            @ApiImplicitParam(dataType = "string", name = "yearMonth", value = "年份月份", defaultValue = "2018-03", paramType = "path"),
    })
    @GetMapping(value = "queryStoreMonthAssertInfo/{storeId}/{yearMonth}")
    public ResponseMessage<List<StoreMonthBillVo>> queryStoreMonthBillInfo(@PathVariable(value = "storeId") Integer storeId,
                                                                           @PathVariable(value = "yearMonth") String yearMonth) {
        return storeTradeDetailFeign.queryStoreMonthBillInfo(storeId, yearMonth);
    }

    @ApiOperation("日订单数和日收入")
    @RequestMapping(value = "/dayOrderAndAccount/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(@PathVariable("id") Integer id) {
        return this.storeTradeDetailFeign.dayOrderAndAccount(id);
    }
}