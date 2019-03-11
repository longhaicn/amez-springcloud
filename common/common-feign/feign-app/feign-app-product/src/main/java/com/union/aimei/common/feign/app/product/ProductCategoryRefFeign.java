package com.union.aimei.common.feign.app.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.hystrix.ProductCategoryRefApiHystrix;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 商品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:38
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductCategoryRefApiHystrix.class)
public interface ProductCategoryRefFeign {
    /**
     * 添加商品-分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @PostMapping(value = "/productCategoryRef/insert")
    int insert(@RequestBody ProductCategoryRef productCategoryRef);

    /**
     * 删除商品-分类-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productCategoryRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改商品-分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @PutMapping(value = "/productCategoryRef/edit")
    int edit(@RequestBody ProductCategoryRef productCategoryRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCategoryRef
     */
    @GetMapping(value = "/productCategoryRef/queryById/{id}")
    ProductCategoryRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询商品-分类-关联
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param productCategoryRef 查询条件
     * @return
     */
    @PostMapping(value = "/productCategoryRef/front/findByPage")
    PageInfo<ProductCategoryRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                            Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                            Integer pageSize, @RequestBody ProductCategoryRef productCategoryRef);

    /**
     * 根据项目ID查询项目-分类-关联
     *
     * @param productId 项目ID
     * @return
     */
    @GetMapping("/productCategoryRef/getByProductId/{productId}")
    ResponseMessage<ProductCategoryRef> getByProductId(@PathVariable(value = "productId") int productId);

}