package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.StoreBannerApiHystrix;
import com.union.aimei.common.model.store.StoreBanner;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺图片
 *
 * @author liurenkai
 * @time 2018/4/11 14:25
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreBannerApiHystrix.class)
public interface StoreBannerFeign {
    /**
     * 添加店铺图片表
     *
     * @param storeBanner
     * @return
     */
    @PostMapping(value = "/storeBanner/insert")
    int insert(@RequestBody StoreBanner storeBanner);

    /**
     * 删除店铺图片表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeBanner/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺图片表
     *
     * @param storeBanner
     * @return
     */
    @PutMapping(value = "/storeBanner/edit")
    int edit(@RequestBody StoreBanner storeBanner);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBanner
     */
    @GetMapping(value = "/storeBanner/queryById/{id}")
    StoreBanner queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询店铺图片表
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param storeBanner 查询条件
     * @return
     */
    @PostMapping(value = "/storeBanner/front/findByPage")
    PageInfo<StoreBanner> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                     Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                     Integer pageSize, @RequestBody StoreBanner storeBanner);
}