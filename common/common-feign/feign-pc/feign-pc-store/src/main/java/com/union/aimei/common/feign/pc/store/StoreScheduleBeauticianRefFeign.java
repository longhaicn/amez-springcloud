package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreScheduleBeauticianRefApiHystrix;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreScheduleBeauticianRefApiHystrix.class)
public interface StoreScheduleBeauticianRefFeign {
    /**
     * 添加店铺排班-美容师-关联
     *
     * @param storeScheduleBeauticianRef
     * @return
     */
    @PostMapping(value = "/storeScheduleBeauticianRef/insert")
    int insert(@RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef);

    /**
     * 删除店铺排班-美容师-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeScheduleBeauticianRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺排班-美容师-关联
     *
     * @param storeScheduleBeauticianRef
     * @return
     */
    @PutMapping(value = "/storeScheduleBeauticianRef/edit")
    int edit(@RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreScheduleBeauticianRef
     */
    @GetMapping(value = "/storeScheduleBeauticianRef/queryById/{id}")
    StoreScheduleBeauticianRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询店铺排班-美容师-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param storeScheduleBeauticianRef 查询条件
     * @return
     */
    @PostMapping(value = "/storeScheduleBeauticianRef/front/findByPage")
    PageInfo<StoreScheduleBeauticianRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                    Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                    Integer pageSize, @RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef);
}