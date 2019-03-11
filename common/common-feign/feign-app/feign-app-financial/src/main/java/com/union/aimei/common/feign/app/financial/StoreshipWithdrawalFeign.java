package com.union.aimei.common.feign.app.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.hystrix.StoreshipWithdrawalHystrix;
import com.union.aimei.common.model.financial.StoreshipWithdrawal;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author liufeihua
 */
@FeignClient(name = "app-financial-service", fallback = StoreshipWithdrawalHystrix.class)
public interface StoreshipWithdrawalFeign {
    /**
     * 基础操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeshipWithdrawals/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeshipWithdrawals/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody StoreshipWithdrawal record);
    /**
     * 基础操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/storeshipWithdrawals/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    StoreshipWithdrawal selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeshipWithdrawals/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody StoreshipWithdrawal record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeshipWithdrawals/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<StoreshipWithdrawal> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody StoreshipWithdrawal record);

    /**
     * 根据条件查询列表（V1.1.0）
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/storeshipWithdrawals/1.1.0/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<List<StoreshipWithdrawal>> selectListByConditionsV110(@RequestBody StoreshipWithdrawal record);
}