package com.union.aimei.financial.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.aimei.financial.service.BeauticianTradeDetailService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * @author liufeihua
 */
@Api(tags = "美容师流水", description = "api")
@RestController
@RequestMapping("/beauticianTradeDetails")
public class BeauticianTradeDetailController {

    @Autowired
    private BeauticianTradeDetailService beauticianTradeDetailService;

    @ApiOperation("根据ID删除美容师流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.beauticianTradeDetailService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("根据订单编号删除流水")
    @RequestMapping(value = "/deleteTradeDetailByOrderNo/{orderNo}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteTradeDetailByOrderNo(@PathVariable("orderNo") String orderNo) {
        ResponseMessage<Integer> resultCount = this.beauticianTradeDetailService.deleteTradeDetailByOrderNo(orderNo);
        return resultCount;
    }

    @ApiOperation("添加美容师流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage insertSelectiveV110(@RequestBody BeauticianTradeDetail record) {
        //必备参数校验
        if (StringUtil.isEmpty(record.getOrderNo())) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if (record.getTradeType() == null || record.getTradeType() == 0) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.TRANSACTION_TYPE_CANNOT_BE_EMPTY);
        }
        return this.beauticianTradeDetailService.insertSelectiveV110(record);
    }

    @ApiOperation("根据ID更新美容师流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage updateByPrimaryKeySelectiveV110(@RequestBody BeauticianTradeDetail record) {
        //必备参数校验
        if (StringUtil.isEmpty(record.getOrderNo())) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if (record.getTradeType() == null || record.getTradeType() == 0) {
            throw new ClientException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.TRANSACTION_TYPE_CANNOT_BE_EMPTY);
        }
        return this.beauticianTradeDetailService.updateByPrimaryKeySelectiveV110(record);
    }

    @ApiOperation("根据ID查询美容师流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BeauticianTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id) {
        BeauticianTradeDetail beauticianTradeDetail = this.beauticianTradeDetailService.selectByPrimaryKey(id);
        return beauticianTradeDetail;
    }

    @ApiOperation("分页和条件查询美容师流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BeauticianTradeDetail> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                  @RequestBody BeauticianTradeDetail record) {
        PageInfo<BeauticianTradeDetail> result = this.beauticianTradeDetailService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("日订单数和日收入")
    @RequestMapping(value = "/dayOrderAndAccount/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(@PathVariable("id") Integer id) {
        return this.beauticianTradeDetailService.dayOrderAndAccount(id);
    }

    @ApiOperation("根据订单编号和类型查询")
    @RequestMapping(value = "/queryByOrderNoAndType")
    public ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(@RequestParam(value = "orderNo") String orderNo,
                                                                        @RequestParam(value = "type") Integer type) {
        return beauticianTradeDetailService.queryByOrderNoAndType(orderNo, type);
    }

    @ApiOperation("app门店端的营业统计中的员工业绩(v1.1.0)")
    @Deprecated
    @PostMapping(value = "/1.1.0/queryMemberPerformance")
    public ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                  @RequestBody QueryMemberPerformanceVo vo) {
        return beauticianTradeDetailService.queryMemberPerformanceV110(pageNo, pageSize, vo);
    }

    @ApiOperation("app门店端的营业统计中的员工业绩(v1.1.1)")
    @PostMapping(value = "/1.1.1/queryMemberPerformance")
    public ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                  @RequestBody QueryMemberPerformanceVo vo) {
        return beauticianTradeDetailService.queryMemberPerformanceV111(pageNo, pageSize, vo);
    }

    @ApiOperation("根据美容师流水vo查询数据(v1.1.0)")
    @PostMapping(value = "/1.1.0/selectListByConditionsVo")
    public ResponseMessage<PageInfo<BeauticianTradeDetail>> selectListByConditionsVoV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                         @RequestBody BeauticianTradeDetailVo vo) {
        return beauticianTradeDetailService.selectListByConditionsVoV110(pageNo, pageSize, vo);
    }

    @ApiOperation("美容师流水数据统计vo(v1.1.0)")
    @GetMapping(value = "/1.1.0/queryBeauticianTradeStatistical/{id}")
    public ResponseMessage<BeauticianTradeStatisticalVo> queryBeauticianTradeStatisticalV110(@ApiParam(value = "美容师id") @PathVariable("id") Integer id) {
        return beauticianTradeDetailService.queryBeauticianTradeStatisticalV110(id);
    }


    @ApiOperation("美容师提现到银行卡(v1.1.0)")
    @PostMapping(value = "/1.1.0/withdrawalsByBeautician")
    public ResponseMessage withdrawalsByBeauticianV110(@RequestBody WithdrawsVo memberWithdrawsVo) {
        return beauticianTradeDetailService.withdrawalsByBeauticianV110(memberWithdrawsVo);
    }

    /**
     * 根据ID查询美容师流水(v1.1.0)
     *
     * @param id
     * @return
     */
    @ApiOperation("根据ID查询美容师流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectById/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BeauticianTradeDetailResultVo> selectVoByPrimaryKeyV110(@PathVariable("id") Integer id) {
        return this.beauticianTradeDetailService.selectVoByPrimaryKeyV110(id);
    }

}