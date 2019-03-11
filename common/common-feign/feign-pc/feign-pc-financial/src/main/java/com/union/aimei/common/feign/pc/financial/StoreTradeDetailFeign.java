package com.union.aimei.common.feign.pc.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.hystrix.StoreTradeDetailHystrix;
import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.financial.StoreTradeStatistics;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-financial-service", fallback = StoreTradeDetailHystrix.class)
public interface StoreTradeDetailFeign {
    /**
     * 基本操作
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
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    StoreTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody StoreTradeDetail record);

    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<StoreTradeDetail> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody StoreTradeDetail record);

    /**
     * 统计店铺数据
     *
     * @param statisticsYearMonth
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/selectStoreListByConditions/{statisticsYearMonth}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    PageInfo<StoreTradeStatistics> selectStoreListByConditions(@PathVariable("statisticsYearMonth") String statisticsYearMonth);


    /**
     * 添加店铺流水
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeTradeDetails/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage insertSelectiveV110(@RequestBody StoreTradeDetail record);

}