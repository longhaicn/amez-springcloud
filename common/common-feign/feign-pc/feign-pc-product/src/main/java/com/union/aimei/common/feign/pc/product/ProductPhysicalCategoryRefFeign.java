package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductPhysicalCategoryRefApiHystrix;
import com.union.aimei.common.model.product.ProductPhysicalCategoryRef;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 产品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:17
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductPhysicalCategoryRefApiHystrix.class)
public interface ProductPhysicalCategoryRefFeign {
    /**
     * 添加产品-分类-关联
     *
     * @param productPhysicalCategoryRef
     * @return
     */
    @PostMapping(value = "/productPhysicalCategoryRef/insert")
    int insert(@RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef);

    /**
     * 删除产品-分类-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productPhysicalCategoryRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改产品-分类-关联
     *
     * @param productPhysicalCategoryRef
     * @return
     */
    @PutMapping(value = "/productPhysicalCategoryRef/edit")
    int edit(@RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysicalCategoryRef
     */
    @GetMapping(value = "/productPhysicalCategoryRef/queryById/{id}")
    ProductPhysicalCategoryRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询产品-分类-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param productPhysicalCategoryRef 查询条件
     * @return
     */
    @PostMapping(value = "/productPhysicalCategoryRef/front/findByPage")
    PageInfo<ProductPhysicalCategoryRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                    Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                    Integer pageSize, @RequestBody ProductPhysicalCategoryRef productPhysicalCategoryRef);
}