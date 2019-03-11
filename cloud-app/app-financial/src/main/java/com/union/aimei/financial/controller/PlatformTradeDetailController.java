package com.union.aimei.financial.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.financial.service.PlatformTradeDetailService;
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

    @ApiOperation("添加平台交易流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage insertSelectiveV110(@RequestBody PlatformTradeDetail record) {
        //必备参数校验
        if (StringUtil.isEmpty(record.getOrderNumber())) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if (record.getTradeType() == null || record.getTradeType() == 0) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.TRANSACTION_TYPE_CANNOT_BE_EMPTY);
        }
        return this.platformTradeDetailService.insertSelectiveV110(record);
    }

    @ApiOperation("根据ID更新平台交易流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage updateByPrimaryKeySelectiveV110(@RequestBody PlatformTradeDetail record) {
        //必备参数校验
        if (StringUtil.isEmpty(record.getOrderNumber())) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if (record.getTradeType() == null || record.getTradeType() == 0) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.TRANSACTION_TYPE_CANNOT_BE_EMPTY);
        }
        return this.platformTradeDetailService.updateByPrimaryKeySelectiveV110(record);
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


    @ApiOperation("根据订单no和交易类型获取数据")
    @RequestMapping(value = "/1.1.1/findByOrderNo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PlatformTradeDetail> findByOrderNo(@RequestParam(value = "orderNo") @ApiParam(value = "订单no") String orderNo,
                                                              @RequestParam(value = "tradeType") @ApiParam(value = "订单类型") Integer tradeType) {
        return this.platformTradeDetailService.findByOrderNo(orderNo, tradeType);
    }

}