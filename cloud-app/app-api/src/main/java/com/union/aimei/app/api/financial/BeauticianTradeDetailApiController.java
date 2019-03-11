package com.union.aimei.app.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.feign.app.financial.BeauticianTradeDetailFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * @author liufeihua
 */
@Api(tags = "美容师流水", description = "api")
@RestController
@RequestMapping("/beauticianTradeDetails")
public class BeauticianTradeDetailApiController {

    @Autowired
    private BeauticianTradeDetailFeign beauticianTradeDetailFeign;

    @ApiOperation("根据ID删除美容师流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.beauticianTradeDetailFeign.deleteByPrimaryKey(id);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据订单编号删除流水")
    @RequestMapping(value = "/deleteTradeDetailByOrderNo/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> deleteTradeDetailByOrderNo(@PathVariable("id") String id) {
        ResponseMessage<Integer> resultCount = this.beauticianTradeDetailFeign.deleteTradeDetailByOrderNo(id);
        return resultCount;
    }

    @ApiOperation("添加美容师流水")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> insertSelective(@RequestBody BeauticianTradeDetail record) {
        int resultCount = this.beauticianTradeDetailFeign.insertSelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("通过ID更新美容师流水")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelective(@RequestBody BeauticianTradeDetail record) {
        int resultCount = this.beauticianTradeDetailFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }

    @ApiOperation("根据ID查询美容师流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<BeauticianTradeDetail> selectByPrimaryKey(@PathVariable("id") Integer id) {
        BeauticianTradeDetail beauticianTradeDetail = this.beauticianTradeDetailFeign.selectByPrimaryKey(id);
        return new ResponseMessage<>(beauticianTradeDetail);
    }

    @ApiOperation("分页和条件查询美容师流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BeauticianTradeDetail>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                   @RequestBody BeauticianTradeDetail record) {
        PageInfo<BeauticianTradeDetail> result = this.beauticianTradeDetailFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    /**
     * 会员(美容师或店长)提现到银行卡
     *
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "会员(美容师或店长)提现到银行卡", notes = "传递会员ID,银行卡ID以及提现金额即可（以分为单位）")
    @PostMapping("/withdrawalsByMember")
    @Deprecated
    public ResponseMessage withdrawalsByMember(@RequestBody WithdrawsVo vo) {
        return null;
    }

    @ApiOperation("日订单数和日收入")
    @RequestMapping(value = "/dayOrderAndAccount/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(@PathVariable("id") Integer id) {
        return this.beauticianTradeDetailFeign.dayOrderAndAccount(id);
    }

    /**
     * 根据订单编号和类型查询
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "通过订单编号和交易类型查询美容师交易流水")
    @RequestMapping(value = "/queryByOrderNoAndType")
    public ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(@RequestParam(value = "orderNo") String orderNo,
                                                                        @RequestParam(value = "type") Integer type) {
        return this.beauticianTradeDetailFeign.queryByOrderNoAndType(orderNo, type);
    }

    /**
     * app门店端的营业统计中的员工业绩(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    @Deprecated
    @ApiOperation("app门店端的营业统计中的员工业绩(v1.1.0)")
    @PostMapping(value = "/1.1.0/queryMemberPerformance")
    public ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                  @RequestBody QueryMemberPerformanceVo vo) {
        return this.beauticianTradeDetailFeign.queryMemberPerformanceV110(pageNo, pageSize, vo);
    }

    /**
     * app门店端的营业统计中的员工业绩(v1.1.1)
     *
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    @ApiOperation("app门店端的营业统计中的员工业绩(v1.1.1)")
    @PostMapping(value = "/1.1.1/queryMemberPerformance")
    public ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV111(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                  @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                  @RequestBody QueryMemberPerformanceVo vo) {
        return this.beauticianTradeDetailFeign.queryMemberPerformanceV111(pageNo, pageSize, vo);
    }


    /**
     * 分页和类型查询美容师流水(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @ApiOperation("分页和类型查询美容师流水(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectListByConditionsVo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BeauticianTradeDetail>> selectListByConditionsV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                       @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                       @RequestBody BeauticianTradeDetailVo record) {
        return this.beauticianTradeDetailFeign.selectListByConditionsVoV110(pageNo, pageSize, record);
    }

    /**
     * 美容师流水数据统计vo(v1.1.0)
     *
     * @param id
     * @return
     */
    @ApiOperation("美容师流水数据统计vo(v1.1.0)")
    @GetMapping(value = "/1.1.0/queryBeauticianTradeStatistical/{id}")
    public ResponseMessage<BeauticianTradeStatisticalVo> queryBeauticianTradeStatisticalV110(@ApiParam(value = "美容师id") @PathVariable("id") Integer id) {
        return beauticianTradeDetailFeign.queryBeauticianTradeStatisticalV110(id);
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
        return this.beauticianTradeDetailFeign.selectVoByPrimaryKeyV110(id);
    }

    /**
     * 美容师提现到银行卡(v1.1.0)
     *
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "美容师提现到银行卡(v1.1.0)")
    @PostMapping("/1.1.0/withdrawalsByBeautician")
    public ResponseMessage withdrawalsByBeauticianV110(@RequestBody WithdrawsVo vo) {
        Optional.ofNullable(vo).filter(x -> x.getMemberId() != null).orElseThrow(() -> new ServerException(FinancialConstant.Param.ERROR_CODE, FinancialConstant.Param.NOT_MEMBERID));
        Optional.ofNullable(vo).filter(x -> x.getBeauticianId() != null).orElseThrow(() -> new ServerException(FinancialConstant.Param.ERROR_CODE, FinancialConstant.Param.NOT_BEAUTICIANID));
        Optional.ofNullable(vo).filter(x -> x.getWithdrawAmount() != null).orElseThrow(() -> new ServerException(FinancialConstant.Param.ERROR_CODE, FinancialConstant.Param.NOT_WITHDRAWAMOUNT));
        Optional.ofNullable(vo).filter(x -> x.getBankCardId() != null).orElseThrow(() -> new ServerException(FinancialConstant.Param.ERROR_CODE, FinancialConstant.Param.NOT_BANKCARDID));
        Optional.ofNullable(vo).filter(x -> x.getWithdrawAmount() != null && x.getWithdrawAmount() != 0).orElseThrow(() -> new ServerException(FinancialConstant.Param.ERROR_CODE, FinancialConstant.Param.NOT_CASH));
        return this.beauticianTradeDetailFeign.withdrawalsByBeauticianV110(vo);
    }

}
