package com.union.aimei.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsAwaitVo;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsVo;
import com.union.aimei.financial.service.StoreTradeStatisticsService;
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
public class StoreTradeStatisticsController {

    @Autowired
    private StoreTradeStatisticsService storeTradeStatisticsService;

    @ApiOperation("根据ID删除店铺流水统计")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public int deleteByPrimaryKey(@PathVariable("id") Integer id) {
        int resultCount = this.storeTradeStatisticsService.deleteByPrimaryKey(id);
        return resultCount;
    }

    @ApiOperation("添加店铺流水统计")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int insertSelective(@RequestBody StoreTradeStatistics record) {
        int resultCount = this.storeTradeStatisticsService.insertSelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID更新店铺流水统计")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public int updateByPrimaryKeySelective(@RequestBody StoreTradeStatistics record) {
        int resultCount = this.storeTradeStatisticsService.updateByPrimaryKeySelective(record);
        return resultCount;
    }

    @ApiOperation("根据ID查询店铺流水统计")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public StoreTradeStatistics selectByPrimaryKey(@PathVariable("id") Integer id) {
        StoreTradeStatistics storeTradeStatistics = this.storeTradeStatisticsService.selectByPrimaryKey(id);
        return storeTradeStatistics;
    }

    @ApiOperation("分页和条件查询店铺流水统计")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public PageInfo<StoreTradeStatistics> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                 @RequestBody StoreTradeStatistics record) {
        PageInfo<StoreTradeStatistics> result = this.storeTradeStatisticsService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("条件查询店铺流水统计(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<List<StoreTradeStatistics>> selectListByConditionsV110(@RequestBody StoreTradeStatistics record) {
        return this.storeTradeStatisticsService.selectListByConditionsV110(record);
    }

    @ApiOperation("查询已结算财务对账列表vo(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectListByConditionsVo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<PageInfo<StoreTradeStatisticsVo>> selectListByConditionsVoV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                          @RequestBody StoreTradeStatistics record) {
        return this.storeTradeStatisticsService.selectListByConditionsVoV110(pageNo, pageSize, record);
    }

    @ApiOperation("根据店铺id 查询待结算的对账数据(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectBySettlementAndStoreId/{storeId}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<StoreTradeStatisticsAwaitVo> selectBySettlementAndStoreIdV110(@ApiParam(value = "店铺id") @PathVariable("storeId") Integer storeId) {
        return this.storeTradeStatisticsService.selectBySettlementAndStoreIdV110(storeId);
    }

    @ApiOperation("对账确认接口(v1.1.0)")
    @RequestMapping(value = "/1.1.0/checkForConfirmation/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage checkForConfirmationV110(@PathVariable("id") Integer id) {
        return this.storeTradeStatisticsService.checkForConfirmationV110(id);
    }

    @ApiOperation("根据店铺统计id查询体现表数据(v1.1.0)")
    @RequestMapping(value = "/1.1.0/selectStoreshipWithdrawalByStoreTradeId/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<StoreshipWithdrawal> selectStoreshipWithdrawalByStoreTradeIdV110(@PathVariable("id") Integer id) {
        return this.storeTradeStatisticsService.selectStoreshipWithdrawalByStoreTradeIdV110(id);
    }


}