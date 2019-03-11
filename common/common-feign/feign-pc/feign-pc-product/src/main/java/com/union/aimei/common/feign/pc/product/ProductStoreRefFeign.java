package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductStoreRefApiHystrix;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByBatchVo;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByStoreIdListVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:17
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductStoreRefApiHystrix.class)
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
     * @param pageSize        每页显示数量
     * @param productStoreRef 查询条件
     * @return
     */
    @PostMapping(value = "/productStoreRef/front/findByPage")
    PageInfo<ProductStoreRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                 @RequestBody ProductStoreRef productStoreRef);

    /**
     * 根据storeIdList查询商品(服务)productIdList
     *
     * @param productStoreRefByStoreIdListVo
     * @return
     */
    @PostMapping(value = "/productStoreRef/findByStoreIdList")
    List<Integer> findByStoreIdList(@RequestBody ProductStoreRefByStoreIdListVo productStoreRefByStoreIdListVo);

    /**
     * 根据商品ID删除项目-门店-关联
     *
     * @param productId
     * @return
     */
    @DeleteMapping(value = "/productStoreRef/deleteByProductId/{productId}")
    ResponseMessage deleteByProductId(@PathVariable(value = "productId") int productId);

    /**
     * 根据店铺ID删除项目-门店-关联
     *
     * @param storeId 店铺ID
     * @return
     */
    @DeleteMapping("/productStoreRef/deleteByStoreId/{storeId}")
    ResponseMessage deleteByStoreId(@PathVariable(value = "storeId") int storeId);

    /**
     * 批量添加项目-门店-关联
     *
     * @param productStoreRefByBatchVo
     * @return
     */
    @PostMapping("/productStoreRef/addBatch")
    ResponseMessage addBatch(@RequestBody ProductStoreRefByBatchVo productStoreRefByBatchVo);

    /**
     * 门店商品下架
     *
     * @param storeId 门店ID
     * @return
     */
    @PutMapping("/productStoreRef/store/offShelves/{storeId}")
    ResponseMessage storeByOffShelves(@PathVariable(value = "storeId") int storeId);


    /**
     * 门店冻结或者解冻
     *
     * @param storeId  门店ID
     * @param isFreeze 是否冻结，true-冻结，false-解冻
     * @return
     */
    @PutMapping("/productStoreRef/freezeByStoreId/{storeId}/{isFreeze}")
    ResponseMessage freezeByStoreId(@PathVariable(value = "storeId") int storeId, @PathVariable(value = "isFreeze") boolean isFreeze);

}