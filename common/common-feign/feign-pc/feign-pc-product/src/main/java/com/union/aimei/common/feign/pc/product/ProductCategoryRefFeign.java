package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductCategoryRefApiHystrix;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 商品-商品分类-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:15
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductCategoryRefApiHystrix.class)
public interface ProductCategoryRefFeign {
    /**
     * 添加商品-商品分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @PostMapping(value = "/productCategoryRef/insert")
    int insert(@RequestBody ProductCategoryRef productCategoryRef);

    /**
     * 删除商品-商品分类-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productCategoryRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改商品-商品分类-关联
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
     * 前端分页查询商品-商品分类-关联
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param productCategoryRef 查询条件
     * @return
     */
    @PostMapping(value = "/productCategoryRef/front/findByPage")
    PageInfo<ProductCategoryRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                    @RequestBody ProductCategoryRef productCategoryRef);

    /**
     * 新增商品-商品分类-关联
     *
     * @param productCategoryRef 商品-商品分类-关联
     * @return
     */
    @PostMapping(value = "/productCategoryRef/add")
    ResponseMessage add(@RequestBody ProductCategoryRef productCategoryRef);

}