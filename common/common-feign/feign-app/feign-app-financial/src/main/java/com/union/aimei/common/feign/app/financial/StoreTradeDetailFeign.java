package com.union.aimei.common.feign.app.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.hystrix.StoreTradeDetailHystrix;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author liufeihua
 */
@FeignClient(name = "app-financial-service", fallback = StoreTradeDetailHystrix.class)
public interface StoreTradeDetailFeign {

    /**
     * 基础操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody StoreTradeDetail record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody StoreTradeDetail record);

    /**
     * 基础操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/1.1.0/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    StoreTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id);

    /**
     * 分页和条件查询店铺流水（已结算）(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/1.1.0/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<StoreTradeDetail> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody StoreTradeDetail record);

    /**
     * 分页和条件查询店铺流水（待结算）(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/1.1.0/selectListBySettlementStatus", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<PageInfo<StoreTradeDetail>> selectListBySettlementStatusV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                 @RequestBody StoreTradeDetail record);

    /**
     * 通过店铺ID查询店铺资产信息
     *
     * @param storeId
     * @return
     */
    @GetMapping(value = "/storeTradeDetails/queryStoreAssertInfo/{storeId}")
    ResponseMessage<StoreAssertVo> queryStoreAssertInfo(@PathVariable(value = "storeId") Integer storeId);

    /**
     * 查询店铺年月账单信息
     * @param storeId
     * @param yearMonth
     * @return
     */
    @GetMapping(value = "/storeTradeDetails/queryStoreMonthAssertInfo/{storeId}/{yearMonth}")
    ResponseMessage<List<StoreMonthBillVo>> queryStoreMonthBillInfo(@PathVariable(value = "storeId") Integer storeId,
                                                                    @PathVariable(value = "yearMonth") String yearMonth);

    /**
     * app门店端的营业统计中的项目业绩
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    @PostMapping(value = "/storeTradeDetails/queryProjectPerformance")
    ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                         @RequestBody QueryProjectPerformanceVo vo);

    /**
     * app门店端的营业统计
     * @param vo
     * @return
     */
    @PostMapping(value = "/storeTradeDetails/queryStorePerformance")
    ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(QueryProjectPerformanceVo vo);


    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/dayOrderAndAccount/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<Map<String, Object>> dayOrderAndAccount(@PathVariable("id") Integer id);

    /**
     * 添加店铺流水(v1.1.0)
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage insertSelectiveV110(@RequestBody StoreTradeDetail record);

    /**
     * 根据ID更新店铺流水(v1.1.0)
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/1.1.0/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    ResponseMessage updateByPrimaryKeySelectiveV110(@RequestBody StoreTradeDetail record);

    /**
     * 根据ID查询店铺流水(v1.1.0)
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/storeTradeDetails/selectByPrimaryKeyV110/{id}")
    ResponseMessage<QueryStoreTradeDetailVo> selectByPrimaryKeyV110(@PathVariable(value = "id") int id);
}