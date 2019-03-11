package com.union.aimei.common.feign.app.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.hystrix.StoreTradeStatisticsHystrix;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsAwaitVo;
import com.union.aimei.common.vo.financial.StoreTradeStatisticsVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author liufeihua
 */
@FeignClient(name = "app-financial-service", fallback = StoreTradeStatisticsHystrix.class)
public interface StoreTradeStatisticsFeign {
    /**
     * 基础操作
     *
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
     * 基础操作
     *
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
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<StoreTradeStatistics> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestBody StoreTradeStatistics record);

    /**
     * 条件查询店铺流水统计(v1.1.0)
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/1.1.0/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<List<StoreTradeStatistics>> selectListByConditionsV110(@RequestBody StoreTradeStatistics record);

    /**
     * 查询财务对账列表vo(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/1.1.0/selectListByConditionsVo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<PageInfo<StoreTradeStatisticsVo>> selectListByConditionsVoV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                   @RequestBody StoreTradeStatistics record);

    /**
     * 根据店铺id 查询待结算的对账数据(v1.1.0)
     *
     * @param storeId
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/1.1.0/selectBySettlementAndStoreId/{storeId}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<StoreTradeStatisticsAwaitVo> selectBySettlementAndStoreIdV110(@PathVariable("storeId") Integer storeId);

    /**
     * 对账确认接口(v1.1.0)
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/1.1.0/checkForConfirmation/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage checkForConfirmationV110(@PathVariable("id") Integer id);

    /**
     * 根据店铺统计id查询体现表数据(v1.1.0)
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeTradeStatistics/1.1.0/selectStoreshipWithdrawalByStoreTradeId/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<StoreshipWithdrawal> selectStoreshipWithdrawalByStoreTradeIdV110(@PathVariable("id") Integer id);

}