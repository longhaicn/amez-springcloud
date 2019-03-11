package com.union.aimei.common.feign.pc.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.hystrix.StoreTradeStatisticsHystrix;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(name = "pc-financial-service", fallback = StoreTradeStatisticsHystrix.class)
public interface StoreTradeStatisticsFeign {
    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody StoreTradeStatistics record);

    /**
     * 基本操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    StoreTradeStatistics selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody StoreTradeStatistics record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<StoreTradeStatistics> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody StoreTradeStatistics record);

    /**
     * 批量打款
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/batchMoney/{ids}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<String> batchMoney(@PathVariable("ids") String ids);


    /**
     * 判断统计数据是否存在,如果存在,则更新,否则插入
     * @param list
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/saveOrUpdateStoreTradeStatistics", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<String> saveOrUpdateStoreTradeStatistics(@RequestBody List<StoreTradeStatistics> list);

    /**
     * 批量打款（V1.1.0）
     * @param idList
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/1.1.0/batchMoney", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage batchMoneyV110(@RequestBody List<Integer> idList);

    /**
     * 根据条件获取列表
     *
     * @param storeTradeStatistics
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/findListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<List<StoreTradeStatistics>> findListByConditions(@RequestBody StoreTradeStatistics storeTradeStatistics);

    /**
     * 批量更新数据
     *
     * @param list
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/updateBatch", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage updateBatch(@RequestBody List<StoreTradeStatistics> list);


    /**
     * 店铺流水统计允许对账确认调度
     *
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/storeTradeStatisticsButtonJobs", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage storeTradeStatisticsButtonJobs();

    /**
     * 店铺流水统计调度
     *
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/storeTradeStatisticsJobs", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage storeTradeStatisticsJobs();
}