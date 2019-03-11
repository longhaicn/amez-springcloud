package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.StoreOpenCityApiHystrix;
import com.union.aimei.common.model.store.StoreOpenCity;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门店开通城市
 *
 * @author liurenkai
 * @time 2018/1/13 14:07
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreOpenCityApiHystrix.class)
public interface StoreOpenCityFeign {
    /**
     * 添加门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @PostMapping(value = "/storeOpenCity/insert")
    int insert(@RequestBody StoreOpenCity storeOpenCity);

    /**
     * 删除门店开通城市
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeOpenCity/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @PutMapping(value = "/storeOpenCity/edit")
    int edit(@RequestBody StoreOpenCity storeOpenCity);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreOpenCity
     */
    @GetMapping(value = "/storeOpenCity/queryById/{id}")
    StoreOpenCity queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询门店开通城市
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeOpenCity 查询条件
     * @return
     */
    @PostMapping(value = "/storeOpenCity/front/findByPage")
    PageInfo<StoreOpenCity> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                               @RequestBody StoreOpenCity storeOpenCity);

    /**
     * 查询所有门店开通城市
     *
     * @return
     */
    @PostMapping(value = "/storeOpenCity/listAll")
    ResponseMessage<List<StoreOpenCity>> listAll();

}