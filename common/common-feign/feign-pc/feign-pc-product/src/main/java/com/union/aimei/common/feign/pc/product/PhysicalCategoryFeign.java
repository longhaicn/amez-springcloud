package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.PhysicalCategoryApiHystrix;
import com.union.aimei.common.model.product.PhysicalCategory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = PhysicalCategoryApiHystrix.class)
public interface PhysicalCategoryFeign {
    /**
     * 添加产品分类
     *
     * @param physicalCategory
     * @return
     */
    @PostMapping(value = "/physicalCategory/insert")
    int insert(@RequestBody PhysicalCategory physicalCategory);

    /**
     * 删除产品分类
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/physicalCategory/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改产品分类
     *
     * @param physicalCategory
     * @return
     */
    @PutMapping(value = "/physicalCategory/edit")
    int edit(@RequestBody PhysicalCategory physicalCategory);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnphysicalCategory
     */
    @GetMapping(value = "/physicalCategory/queryById/{id}")
    PhysicalCategory queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询产品分类
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param physicalCategory 查询条件
     * @return
     */
    @PostMapping(value = "/physicalCategory/front/findByPage")
    PageInfo<PhysicalCategory> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                          Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                          Integer pageSize, @RequestBody PhysicalCategory physicalCategory);
}