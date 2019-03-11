package com.union.aimei.financial.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceResponseVo;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceVo;
import com.union.aimei.common.vo.financial.QueryStorePerformanceResponseVo;
import com.union.aimei.financial.service.StoreSubordinateTradeDetailService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author liufeihua
 */
@Api(tags = "店铺挂靠流水", description = "api")
@RestController
@RequestMapping("/storeSubordinateTradeDetails")
public class StoreSubordinateTradeDetailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StoreSubordinateTradeDetailService storeSubordinateTradeDetailService;


    @ApiOperation("app门店端挂靠的营业统计中的项目业绩")
    @PostMapping(value = "/queryProjectPerformance")
    ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                         @RequestBody QueryProjectPerformanceVo vo) {
        return this.storeSubordinateTradeDetailService.queryProjectPerformance(pageNo, pageSize, vo);
    }


    @ApiOperation("根据ID删除店铺挂靠流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeSubordinateTradeDetailService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加店铺挂靠流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage insertSelectiveV110(@RequestBody StoreSubordinateTradeDetail record) {
        //必备参数校验
        if (StringUtil.isEmpty(record.getOrderNo())) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if (record.getTradeType() == null || record.getTradeType() == 0) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.TRANSACTION_TYPE_CANNOT_BE_EMPTY);
        }
        return this.storeSubordinateTradeDetailService.insertSelectiveV110(record);
    }

    @ApiOperation("根据ID更新店铺挂靠流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage updateByPrimaryKeySelectiveV110(@RequestBody StoreSubordinateTradeDetail record) {
        //必备参数校验
        if (StringUtil.isEmpty(record.getOrderNo())) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if (record.getTradeType() == null || record.getTradeType() == 0) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.TRANSACTION_TYPE_CANNOT_BE_EMPTY);
        }
        return this.storeSubordinateTradeDetailService.updateByPrimaryKeySelectiveV110(record);
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

    @ApiOperation(httpMethod = "POST", value = "app门店端的营业统计-挂靠", notes = "app门店端的营业统计-挂靠")
    @PostMapping("/queryStorePerformance")
    public ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(@RequestBody QueryProjectPerformanceVo vo) {
        return this.storeSubordinateTradeDetailService.queryStorePerformance(vo);
    }
}