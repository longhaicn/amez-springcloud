package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.StoreExtendApiHystrix;
import com.union.aimei.common.model.store.StoreExtend;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺扩展
 *
 * @author liurenkai
 * @time 2018/4/11 14:30
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreExtendApiHystrix.class)
public interface StoreExtendFeign {
    /**
     * 添加店铺扩展
     *
     * @param storeExtend
     * @return
     */
    @PostMapping(value = "/storeExtend/insert")
    int insert(@RequestBody StoreExtend storeExtend);

    /**
     * 删除店铺扩展
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeExtend/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺扩展
     *
     * @param storeExtend
     * @return
     */
    @PutMapping(value = "/storeExtend/edit")
    int edit(@RequestBody StoreExtend storeExtend);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreExtend
     */
    @GetMapping(value = "/storeExtend/queryById/{id}")
    StoreExtend queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询店铺扩展
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param storeExtend 查询条件
     * @return
     */
    @PostMapping(value = "/storeExtend/front/findByPage")
    PageInfo<StoreExtend> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                     Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                     Integer pageSize, @RequestBody StoreExtend storeExtend);
}