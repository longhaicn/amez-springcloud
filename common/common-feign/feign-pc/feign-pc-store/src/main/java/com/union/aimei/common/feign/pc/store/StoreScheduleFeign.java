package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreScheduleApiHystrix;
import com.union.aimei.common.model.store.StoreSchedule;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreScheduleApiHystrix.class)
public interface StoreScheduleFeign {
    /**
     * 添加店铺排班
     *
     * @param storeSchedule
     * @return
     */
    @PostMapping(value = "/storeSchedule/insert")
    int insert(@RequestBody StoreSchedule storeSchedule);

    /**
     * 删除店铺排班
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeSchedule/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺排班
     *
     * @param storeSchedule
     * @return
     */
    @PutMapping(value = "/storeSchedule/edit")
    int edit(@RequestBody StoreSchedule storeSchedule);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreSchedule
     */
    @GetMapping(value = "/storeSchedule/queryById/{id}")
    StoreSchedule queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询店铺排班
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeSchedule 查询条件
     * @return
     */
    @PostMapping(value = "/storeSchedule/front/findByPage")
    PageInfo<StoreSchedule> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                       Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                       Integer pageSize, @RequestBody StoreSchedule storeSchedule);
}