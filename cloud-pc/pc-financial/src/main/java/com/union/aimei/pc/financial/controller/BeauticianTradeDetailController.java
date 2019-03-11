package com.union.aimei.pc.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.BatchMoneyVo;
import com.union.aimei.common.vo.financial.WithdrawsVo;
import com.union.aimei.pc.financial.service.BeauticianTradeDetailService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * @author dell
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

    @ApiOperation("添加美容师流水")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody BeauticianTradeDetail record) {
        int resultCount = this.beauticianTradeDetailService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新美容师流水")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody BeauticianTradeDetail record) {
        int resultCount = this.beauticianTradeDetailService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询美容师流水")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BeauticianTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id) {
        BeauticianTradeDetail beauticianTradeDetail = this.beauticianTradeDetailService.selectByPrimaryKey(id);
        return beauticianTradeDetail;
    }

    @ApiOperation("分页和条件查询美容师流水")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BeauticianTradeDetail> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BeauticianTradeDetail record) {
        PageInfo<BeauticianTradeDetail> result = this.beauticianTradeDetailService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("分页和条件查询提现列表")
    @RequestMapping(value = "/withdrawList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<BeauticianTradeDetail> withdrawList(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody WithdrawsVo record) {
        PageInfo<BeauticianTradeDetail> result = this.beauticianTradeDetailService.withdrawList(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("批量打款")
    @RequestMapping(value = "/batchMoney/{ids}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<String> batchMoney(@PathVariable("ids") String ids) {
        return this.beauticianTradeDetailService.batchMoney(ids);
    }

    @ApiOperation("日订单数和日收入")
    @RequestMapping(value = "/dayOrderAndAccount/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(@PathVariable("id") Integer id) {
        return this.beauticianTradeDetailService.dayOrderAndAccount(id);
    }

    /**
     * 根据订单编号和类型查询
     *
     * @return
     */
    @RequestMapping(value = "/queryByOrderNoAndType")
    public ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(@RequestParam(value = "orderNo") String orderNo,
                                                                        @RequestParam(value = "type") Integer type) {
        return beauticianTradeDetailService.queryByOrderNoAndType(orderNo, type);
    }

    @ApiOperation("批量打款")
    @RequestMapping(value = "/1.1.1/batchMoney", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<String> batchMoneyV111(@RequestBody List<BatchMoneyVo> batchMoneyVos) {
        return this.beauticianTradeDetailService.batchMoneyV111(batchMoneyVos);
    }


}