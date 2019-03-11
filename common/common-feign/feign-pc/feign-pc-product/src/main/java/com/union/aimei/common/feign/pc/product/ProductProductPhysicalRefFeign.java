package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductProductPhysicalRefApiHystrix;
import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.vo.product.pc.ProductProductPhysicalRefByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:18
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductProductPhysicalRefApiHystrix.class)
public interface ProductProductPhysicalRefFeign {
    /**
     * 添加项目-产品-关联
     *
     * @param productProductPhysicalRef
     * @return
     */
    @PostMapping(value = "/productProductPhysicalRef/insert")
    int insert(@RequestBody ProductProductPhysicalRef productProductPhysicalRef);

    /**
     * 删除项目-产品-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productProductPhysicalRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改项目-产品-关联
     *
     * @param productProductPhysicalRef
     * @return
     */
    @PutMapping(value = "/productProductPhysicalRef/edit")
    int edit(@RequestBody ProductProductPhysicalRef productProductPhysicalRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductProductPhysicalRef
     */
    @GetMapping(value = "/productProductPhysicalRef/queryById/{id}")
    ProductProductPhysicalRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询项目-产品-关联
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页显示数量
     * @param productProductPhysicalRef 查询条件
     * @return
     */
    @PostMapping(value = "/productProductPhysicalRef/front/findByPage")
    PageInfo<ProductProductPhysicalRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                   Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                   Integer pageSize, @RequestBody ProductProductPhysicalRef productProductPhysicalRef);

    /**
     * 根据商品ID删除项目-产品-关联
     *
     * @param productId 商品ID
     * @return
     */
    @DeleteMapping(value = "/productProductPhysicalRef/deleteByProductId/{productId}")
    ResponseMessage deleteByProductId(@PathVariable(value = "productId") int productId);

    /**
     * 批量添加项目-产品-关联
     *
     * @param productProductPhysicalRefByBatchVo
     * @return
     */
    @PostMapping(value = "/productProductPhysicalRef/addBatch")
    ResponseMessage addBatch(@RequestBody ProductProductPhysicalRefByBatchVo productProductPhysicalRefByBatchVo);

    /**
     * 保存项目-产品-关联
     *
     * @param productProductPhysicalRef
     * @return
     */
    @PostMapping(value = "/productProductPhysicalRef/save")
    ResponseMessage<ProductProductPhysicalRef> save(@RequestBody ProductProductPhysicalRef productProductPhysicalRef);

}