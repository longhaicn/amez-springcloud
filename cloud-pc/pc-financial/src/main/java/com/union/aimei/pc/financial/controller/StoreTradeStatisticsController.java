package com.union.aimei.pc.financial.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.pc.financial.service.StoreTradeStatisticsService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author dell
 */
@Api(tags = "店铺流水统计", description = "api")
@RestController
@RequestMapping("/storeTradeStatistics")
public class StoreTradeStatisticsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public PageInfo<StoreTradeStatistics> selectListByConditions(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody StoreTradeStatistics record) {
        PageInfo<StoreTradeStatistics> result = this.storeTradeStatisticsService.selectListByConditions(pageNo, pageSize, record);
        return result;
    }

    @ApiOperation("批量打款")
    @RequestMapping(value = "/batchMoney/{ids}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<String> batchMoney(@PathVariable("ids") String ids) {
        return this.storeTradeStatisticsService.batchMoney(ids);
    }

    @ApiOperation("判断统计数据是否存在,如果存在,则更新,否则插入")
    @RequestMapping(value = "/saveOrUpdateStoreTradeStatistics", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<String> saveOrUpdateStoreTradeStatistics(@RequestBody List<StoreTradeStatistics> list) {
        return this.storeTradeStatisticsService.saveOrUpdateStoreTradeStatistics(list);
    }

    @ApiOperation("批量打款（V1.1.0）")
    @RequestMapping(value = "/1.1.0/batchMoney", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage batchMoneyV110(@RequestBody List<Integer> idList) {
        return this.storeTradeStatisticsService.batchMoneyV110(idList);
    }

    @ApiOperation("根据条件获取列表")
    @RequestMapping(value = "/findListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<List<StoreTradeStatistics>> findListByConditions(@RequestBody StoreTradeStatistics storeTradeStatistics) {
        return this.storeTradeStatisticsService.findListByConditions(storeTradeStatistics);
    }

    @ApiOperation("批量更新数据")
    @RequestMapping(value = "/updateBatch", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage updateBatch(@RequestBody List<StoreTradeStatistics> list) {
        return this.storeTradeStatisticsService.updateBatch(list);
    }

    @ApiOperation("店铺流水统计调度")
    @RequestMapping(value = "/storeTradeStatisticsJobs", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage storeTradeStatisticsJobs() {
        return this.storeTradeStatisticsService.storeTradeStatisticsJobs();
    }


    @ApiOperation("店铺流水统计允许对账确认调度")
    @RequestMapping(value = "/storeTradeStatisticsButtonJobs", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage storeTradeStatisticsButtonJobs() {
        return this.storeTradeStatisticsService.storeTradeStatisticsButtonJobs();
    }


}