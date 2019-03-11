package com.union.aimei.common.feign.app.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.hystrix.ProductStoreRefApiHystrix;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.app.ProductStoreRefByByProductIdForOrderVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:17
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductStoreRefApiHystrix.class)
public interface ProductStoreRefFeign {
    /**
     * 添加项目-门店-关联
     *
     * @param productStoreRef
     * @return
     */
    @PostMapping(value = "/productStoreRef/insert")
    int insert(@RequestBody ProductStoreRef productStoreRef);

    /**
     * 删除项目-门店-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productStoreRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改项目-门店-关联
     *
     * @param productStoreRef
     * @return
     */
    @PutMapping(value = "/productStoreRef/edit")
    int edit(@RequestBody ProductStoreRef productStoreRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductStoreRef
     */
    @GetMapping(value = "/productStoreRef/queryById/{id}")
    ProductStoreRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询项目-门店-关联
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productStoreRef 查询条件
     * @return
     */
    @PostMapping(value = "/productStoreRef/front/findByPage")
    ResponseMessage<PageInfo<ProductStoreRef>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                  @RequestBody ProductStoreRef productStoreRef);

    /**
     * 根据商品ID查询项目-门店-关联（提交订单）
     *
     * @param pageNo                                 分页索引
     * @param pageSize                               每页数量
     * @param productStoreRefByByProductIdForOrderVo 查询条件
     * @return
     */
    @PostMapping("/productStoreRef/findByPageByProductIdForOrder")
    ResponseMessage<PageInfo<ProductStoreRef>> findByPageByProductIdForOrder(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                             @RequestBody ProductStoreRefByByProductIdForOrderVo productStoreRefByByProductIdForOrderVo);

    /**
     * 根据ID查询项目-门店-关联
     *
     * @param id
     * @return
     */
    @GetMapping("/productStoreRef/findById/{id}")
    ResponseMessage<ProductStoreRef> findById(@PathVariable(value = "id") int id);

}