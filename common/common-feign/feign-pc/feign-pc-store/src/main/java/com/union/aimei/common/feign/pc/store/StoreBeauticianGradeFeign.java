package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreBeauticianGradeApiHystrix;
import com.union.aimei.common.model.store.StoreBeauticianGrade;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-25 11:43
 **/
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreBeauticianGradeApiHystrix.class)
public interface StoreBeauticianGradeFeign {
    /**
     * 添加店铺-美容师等级
     *
     * @param storeBeauticianGrade
     * @return
     */
    @PostMapping(value = "/storeBeauticianGrade/insert")
    int insert(@RequestBody StoreBeauticianGrade storeBeauticianGrade);

    /**
     * 删除店铺-美容师等级
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeBeauticianGrade/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺-美容师等级
     *
     * @param storeBeauticianGrade
     * @return
     */
    @PutMapping(value = "/storeBeauticianGrade/edit")
    int edit(@RequestBody StoreBeauticianGrade storeBeauticianGrade);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianGrade
     */
    @GetMapping(value = "/storeBeauticianGrade/queryById/{id}")
    StoreBeauticianGrade queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询店铺-美容师等级
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeBeauticianGrade 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeauticianGrade/front/findByPage")
    PageInfo<StoreBeauticianGrade> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                              Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                              Integer pageSize, @RequestBody StoreBeauticianGrade storeBeauticianGrade);
}