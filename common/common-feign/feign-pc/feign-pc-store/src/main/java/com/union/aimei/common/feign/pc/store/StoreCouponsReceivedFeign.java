package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreCouponsReceivedApiHystrix;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreCouponsReceivedApiHystrix.class)
public interface StoreCouponsReceivedFeign {
    /**
     * 添加店铺优惠券领取
     *
     * @param storeCouponsReceived
     * @return
     */
    @PostMapping(value = "/storeCouponsReceived/insert")
    int insert(@RequestBody StoreCouponsReceived storeCouponsReceived);

    /**
     * 删除店铺优惠券领取
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeCouponsReceived/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺优惠券领取
     *
     * @param storeCouponsReceived
     * @return
     */
    @PutMapping(value = "/storeCouponsReceived/edit")
    int edit(@RequestBody StoreCouponsReceived storeCouponsReceived);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCouponsReceived
     */
    @GetMapping(value = "/storeCouponsReceived/queryById/{id}")
    StoreCouponsReceived queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询店铺优惠券领取
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeCouponsReceived 查询条件
     * @return
     */
    @PostMapping(value = "/storeCouponsReceived/front/findByPage")
    PageInfo<StoreCouponsReceived> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                              Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                              Integer pageSize, @RequestBody StoreCouponsReceived storeCouponsReceived);
}