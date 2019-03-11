package com.union.aimei.common.feign.pc.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.hystrix.StoreSubordinateTradeDetailHystrix;
import com.union.aimei.common.model.financial.StoreSubordinateTradeDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author dell
 */
@FeignClient(name = "pc-financial-service", fallback = StoreSubordinateTradeDetailHystrix.class)
public interface StoreSubordinateTradeDetailFeign {
    /**
     * 基本操作
     * @param id
     * @return
     */
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
     * 基本操作
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
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeSubordinateTradeDetails/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<StoreSubordinateTradeDetail> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody StoreSubordinateTradeDetail record);
}