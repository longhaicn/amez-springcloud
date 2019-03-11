package com.union.aimei.pc.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.BeauticianTradeDetailFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.BatchMoneyVo;
import com.union.aimei.common.vo.financial.WithdrawsVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseMessage<PageInfo<BeauticianTradeDetail>> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody BeauticianTradeDetail record) {
        PageInfo<BeauticianTradeDetail> result = this.beauticianTradeDetailFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    @ApiOperation("分页和条件查询提现列表")
    @RequestMapping(value = "/withdrawList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<BeauticianTradeDetail>> withdrawList(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                         @RequestBody WithdrawsVo record) {
        PageInfo<BeauticianTradeDetail> result = this.beauticianTradeDetailFeign.withdrawList(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    /**
     * 你的提现金额${account}元,已汇入你尾号${number}的银行卡,预计1-2个工作日到账，以实际到账时间为准~
     * @param batchMoneyVos
     * @return
     */
    @ApiOperation("批量打款")
    @RequestMapping(value = "/batchMoney", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<String> batchMoney(@RequestBody List<BatchMoneyVo> batchMoneyVos) {
        return this.beauticianTradeDetailFeign.batchMoneyV111(batchMoneyVos);
    }

    @ApiOperation("日订单数和日收入")
    @RequestMapping(value = "/dayOrderAndAccount/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(@PathVariable("id") Integer id) {
        return this.beauticianTradeDetailFeign.dayOrderAndAccount(id);
    }
}