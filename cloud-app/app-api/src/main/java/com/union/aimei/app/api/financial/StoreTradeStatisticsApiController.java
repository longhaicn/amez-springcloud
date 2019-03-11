package com.union.aimei.app.api.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.StoreTradeStatisticsFeign;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsAwaitVo;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liufeihua
 */
@Api(tags = "店铺流水统计", description = "api")
@RestController
@RequestMapping("/storeTradeStatistics")
public class StoreTradeStatisticsApiController {

    @Autowired
    private StoreTradeStatisticsFeign storeTradeStatisticsFeign;

    @ApiOperation("分页和条件查询店铺流水统计(V1.1.0)")
    @RequestMapping(value = "/1.1.0/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreTradeStatistics>> selectListByConditionsV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                      @RequestBody StoreTradeStatistics record) {
        PageInfo<StoreTradeStatistics> result = this.storeTradeStatisticsFeign.selectListByConditions(pageNo, pageSize, record);
        return new ResponseMessage<>(result);
    }

    @ApiOperation("通过ID更新店铺流水统计(v1.1.0)")
    @RequestMapping(value = "/1.1.0/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<Integer> updateByPrimaryKeySelectiveV110(@RequestBody StoreTradeStatistics record) {
        int resultCount = this.storeTradeStatisticsFeign.updateByPrimaryKeySelective(record);
        return new ResponseMessage<>(resultCount);
    }


    @ApiOperation("对账确认接口(v1.1.0)")
    @RequestMapping(value = "/1.1.0/checkForConfirmation/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage checkForConfirmationV110(@PathVariable("id") Integer id) {
        return this.storeTradeStatisticsFeign.checkForConfirmationV110(id);
    }

    @ApiOperation("根据店铺统计id查询体现表数据(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectStoreshipWithdrawalByStoreTradeId/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<StoreshipWithdrawal> selectStoreshipWithdrawalByStoreTradeIdV110(@PathVariable("id") Integer id) {
        return this.storeTradeStatisticsFeign.selectStoreshipWithdrawalByStoreTradeIdV110(id);
    }

    @ApiOperation("查询已结算财务对账列表vo(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectListByConditionsVo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreTradeStatisticsVo>> selectListByConditionsVoV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                          @RequestBody StoreTradeStatistics record) {
        return this.storeTradeStatisticsFeign.selectListByConditionsVoV110(pageNo, pageSize, record);
    }

    @ApiOperation("根据店铺id 查询待结算的对账数据(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectBySettlementAndStoreId/{storeId}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<StoreTradeStatisticsAwaitVo> selectBySettlementAndStoreIdV110(@ApiParam(value = "店铺id") @PathVariable("storeId") Integer storeId) {
        return this.storeTradeStatisticsFeign.selectBySettlementAndStoreIdV110(storeId);
    }


}