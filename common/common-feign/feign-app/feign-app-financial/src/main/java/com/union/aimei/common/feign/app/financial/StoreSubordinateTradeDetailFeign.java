package com.union.aimei.common.feign.app.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.hystrix.StoreSubordinateTradeDetailHystrix;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceResponseVo;
import com.union.aimei.common.vo.financial.QueryProjectPerformanceVo;
import com.union.aimei.common.vo.financial.QueryStorePerformanceResponseVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author liufeihua
 */
@FeignClient(name = "app-financial-service", fallback = StoreSubordinateTradeDetailHystrix.class)
public interface StoreSubordinateTradeDetailFeign
/**
 * 基础操作
 *
 * @param id
 * @return
 */{
    @RequestMapping(value = "/storeSubordinateTradeDetails/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeSubordinateTradeDetails/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody StoreSubordinateTradeDetail record);
    /**
     * 基础操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeSubordinateTradeDetails/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    StoreSubordinateTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeSubordinateTradeDetails/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody StoreSubordinateTradeDetail record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeSubordinateTradeDetails/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<StoreSubordinateTradeDetail> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody StoreSubordinateTradeDetail record);

    /**
     * app门店端的营业统计-挂靠
     *
     * @param vo
     * @return
     */
    @PostMapping(value = "/storeSubordinateTradeDetails/queryStorePerformance")
    ResponseMessage<QueryStorePerformanceResponseVo> queryStorePerformance(QueryProjectPerformanceVo vo);

    /**
     * app门店端挂靠的营业统计中的项目业绩
     *
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    @PostMapping(value = "/storeSubordinateTradeDetails/queryProjectPerformance")
    ResponseMessage<PageInfo<QueryProjectPerformanceResponseVo>> queryProjectPerformance(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                         @RequestBody QueryProjectPerformanceVo vo);

    /**
     * 添加店铺挂靠流水(v1.1.0)
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeSubordinateTradeDetails/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage insertSelectiveV110(@RequestBody StoreSubordinateTradeDetail record);

    /**
     * 根据ID更新店铺挂靠流水(v1.1.0)
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeSubordinateTradeDetails/1.1.0/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    ResponseMessage updateByPrimaryKeySelectiveV110(@RequestBody StoreSubordinateTradeDetail record);

}