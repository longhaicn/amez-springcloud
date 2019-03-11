package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.PhysicalCategoryRefApiHystrix;
import com.union.aimei.common.model.product.PhysicalCategoryRef;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = PhysicalCategoryRefApiHystrix.class)
public interface PhysicalCategoryRefFeign {
    /**
     * 添加产品-产品分类-关联
     *
     * @param physicalCategoryRef
     * @return
     */
    @PostMapping(value = "/physicalCategoryRef/insert")
    int insert(@RequestBody PhysicalCategoryRef physicalCategoryRef);

    /**
     * 删除产品-产品分类-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/physicalCategoryRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改产品-产品分类-关联
     *
     * @param physicalCategoryRef
     * @return
     */
    @PutMapping(value = "/physicalCategoryRef/edit")
    int edit(@RequestBody PhysicalCategoryRef physicalCategoryRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnphysicalCategoryRef
     */
    @GetMapping(value = "/physicalCategoryRef/queryById/{id}")
    PhysicalCategoryRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询产品-产品分类-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param physicalCategoryRef 查询条件
     * @return
     */
    @PostMapping(value = "/physicalCategoryRef/front/findByPage")
    PageInfo<PhysicalCategoryRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                             Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                             Integer pageSize, @RequestBody PhysicalCategoryRef physicalCategoryRef);
}