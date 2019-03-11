package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductCityApiHystrix;
import com.union.aimei.common.model.product.ProductCity;
import com.union.aimei.common.vo.product.pc.ProductCityByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 项目城市
 *
 * @author liurenkai
 * @time 2018/2/26 15:06
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductCityApiHystrix.class)
public interface ProductCityFeign {
    /**
     * 添加项目城市
     *
     * @param productCity
     * @return
     */
    @PostMapping(value = "/productCity/insert")
    int insert(@RequestBody ProductCity productCity);

    /**
     * 删除项目城市
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productCity/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改项目城市
     *
     * @param productCity
     * @return
     */
    @PutMapping(value = "/productCity/edit")
    int edit(@RequestBody ProductCity productCity);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCity
     */
    @GetMapping(value = "/productCity/queryById/{id}")
    ProductCity queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询项目城市
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param productCity 查询条件
     * @return
     */
    @PostMapping(value = "/productCity/front/findByPage")
    PageInfo<ProductCity> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                     Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                     Integer pageSize, @RequestBody ProductCity productCity);

    /**
     * 根据商品ID删除项目城市
     *
     * @param productId 商品ID
     * @return
     */
    @DeleteMapping(value = "/productCity/deleteByProductId/{productId}")
    ResponseMessage deleteByProductId(@PathVariable(value = "productId") int productId);

    /**
     * 批量添加项目城市
     *
     * @param productCityByBatchVo
     * @return
     */
    @PostMapping("/productCity/addBatch")
    ResponseMessage addBatch(@RequestBody ProductCityByBatchVo productCityByBatchVo);

}