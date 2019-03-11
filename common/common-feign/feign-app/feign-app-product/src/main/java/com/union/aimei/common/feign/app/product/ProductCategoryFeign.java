package com.union.aimei.common.feign.app.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.hystrix.ProductCategoryApiHystrix;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/2/27 14:38
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductCategoryApiHystrix.class)
public interface ProductCategoryFeign {
    /**
     * 添加商品分类
     *
     * @param productCategory
     * @return
     */
    @PostMapping(value = "/productCategory/insert")
    int insert(@RequestBody ProductCategory productCategory);

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productCategory/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改商品分类
     *
     * @param productCategory
     * @return
     */
    @PutMapping(value = "/productCategory/edit")
    int edit(@RequestBody ProductCategory productCategory);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCategory
     */
    @GetMapping(value = "/productCategory/queryById/{id}")
    ProductCategory queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询商品分类
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productCategory 查询条件
     * @return
     */
    @PostMapping(value = "/productCategory/front/findByPage")
    ResponseMessage<PageInfo<ProductCategory>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestBody ProductCategory productCategory);

    /**
     * 批量根据ID查询商品分类(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @PostMapping("/productCategory/1.1.0/findListByIdBatch")
    ResponseMessage<List<ProductCategory>> findListByIdBatchV110(@ApiParam(value = "批量ID") @RequestBody IdBatchVo idBatchVo);
}