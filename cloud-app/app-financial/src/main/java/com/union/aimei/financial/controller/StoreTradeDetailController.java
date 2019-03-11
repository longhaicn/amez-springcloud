package com.union.aimei.financial.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.aimei.financial.service.StoreTradeDetailService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class StoreTradeDetailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StoreTradeDetailService storeTradeDetailService;


    @ApiOperation("根据ID查询店铺流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public StoreTradeDetail selectByPrimaryKeyV110(@PathVariable("id") Integer id) {
        StoreTradeDetail storeTradeDetail = this.storeTradeDetailService.selectByPrimaryKey(id);
        return storeTradeDetail;
    }

    @ApiOperation("分页和条件查询店铺流水（已结算）(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<StoreTradeDetail> selectListByConditionsV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                 @RequestBody StoreTradeDetail record) {
        return this.storeTradeDetailService.selectListByConditions(pageNo, pageSize, record);
    }

    @ApiOperation("分页和条件查询店铺流水（待结算）(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectListBySettlementStatus", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreTradeDetail>> selectListBySettlementStatusV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                        @RequestBody StoreTradeDetail record) {
        return this.storeTradeDetailService.selectListBySettlementStatus(pageNo, pageSize, record);
    }


    @ApiOperation("根据ID删除店铺流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeTradeDetailService.deleteByPrimaryKey(id);
        return resultCount;
    }


    @ApiOperation("添加店铺流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage insertSelectiveV110(@RequestBody StoreTradeDetail record) {
        //必备参数校验
        if (StringUtil.isEmpty(record.getOrderNo())) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if (record.getTradeType() == null || record.getTradeType() == 0) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.TRANSACTION_TYPE_CANNOT_BE_EMPTY);
        }
        return this.storeTradeDetailService.insertSelectiveV110(record);
    }

    @ApiOperation("根据ID更新店铺流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage updateByPrimaryKeySelectiveV110(@RequestBody StoreTradeDetail record) {
        //必备参数校验
        if (StringUtil.isEmpty(record.getOrderNo())) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if (record.getTradeType() == null || record.getTradeType() == 0) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.TRANSACTION_TYPE_CANNOT_BE_EMPTY);
        }
        return this.storeTradeDetailService.updateByPrimaryKeySelectiveV110(record);
    }

    /**
     * 通过店铺ID查询店铺资产信息
     *
     * @param storeId
     * @return
     */
    @GetMapping(value = "/queryStoreAssertInfo/{storeId}")
    public ResponseMessage<StoreAssertVo> queryStoreAssertInfo(@PathVariable(value = "storeId") Integer storeId) {
        return storeTradeDetailService.queryStoreAssertInfo(storeId);
    }

    @ApiOperation("查询店铺年月账单信息")
    @GetMapping(value = "/queryStoreMonthAssertInfo/{storeId}/{yearMonth}")
    public ResponseMessage<List<StoreMonthBillVo>> queryStoreMonthBillInfo(@PathVariable(value = "storeId") Integer storeId,
                                                                           @PathVariable(value = "yearMonth") String yearMonth) {
        return storeTradeDetailService.queryStoreMonthBillInfo(storeId, yearMonth);
    }

    @ApiOperation("app门店端的营业统计中的项目业绩")
    @PostMapping(value = "/queryProjectPerformance")
    ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                         @RequestBody QueryProjectPerformanceVo vo) {
        return storeTradeDetailService.queryProjectPerformance(pageNo, pageSize, vo);
    }

    @ApiOperation(httpMethod = "POST", value = "app门店端的营业统计", notes = "app门店端的营业统计")
    @PostMapping("/queryStorePerformance")
    public ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(@RequestBody QueryProjectPerformanceVo vo) {
        return this.storeTradeDetailService.queryStorePerformance(vo);
    }


    @ApiOperation("日订单数和日收入")
    @RequestMapping(value = "/dayOrderAndAccount/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(@PathVariable("id") Integer id) {
        return this.storeTradeDetailService.dayOrderAndAccount(id);
    }

    @ApiOperation("根据ID查询店铺流水(v1.1.0)")
    @GetMapping(value = "/selectByPrimaryKeyV110/{id}")
    public ResponseMessage<QueryStoreTradeDetailVo> selectByPrimaryKeyV110(@PathVariable(value = "id") int id) {
        return storeTradeDetailService.selectByPrimaryKeyV110(id);
    }


}