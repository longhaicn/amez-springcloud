package com.union.aimei.common.feign.app.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.hystrix.ProductPhysicalBeauticianRefApiHystrix;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.vo.product.app.PhysicalBeauticianRefListInventoryByProductIdVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByBeauticianIdResVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByRefIdVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:17
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductPhysicalBeauticianRefApiHystrix.class)
public interface ProductPhysicalBeauticianRefFeign {
    /**
     * 添加产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @PostMapping(value = "/productPhysicalBeauticianRef/insert")
    int insert(@RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef);

    /**
     * 删除产品-美容师-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productPhysicalBeauticianRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @PutMapping(value = "/productPhysicalBeauticianRef/edit")
    int edit(@RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysicalBeauticianRef
     */
    @GetMapping(value = "/productPhysicalBeauticianRef/queryById/{id}")
    ProductPhysicalBeauticianRef queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询产品-美容师-关联
     *
     * @param pageNo                       分页索引
     * @param pageSize                     每页数量
     * @param productPhysicalBeauticianRef 查询条件
     * @return
     */
    @PostMapping(value = "/productPhysicalBeauticianRef/front/findByPage")
    ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                               @RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef);

    /**
     * 根据关联ID查询产品-美容师-关联
     *
     * @param refIdVo
     * @return
     */
    @PostMapping("/productPhysicalBeauticianRef/findByRefId")
    ResponseMessage<ProductPhysicalBeauticianRef> findByRefId(@RequestBody ProductPhysicalBeauticianRefByRefIdVo refIdVo);

    /**
     * 分页查询产品-美容师-关联（根据美容师ID）
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    @PostMapping("/productPhysicalBeauticianRef/findByPageForBeauticianId/{beauticianId}")
    ResponseMessage<PageInfo<ProductPhysicalBeauticianRefByBeauticianIdResVo>> findByPageForBeauticianId(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                         @PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 根据项目ID查询存在可消耗库存的产品-美容师-关联列表
     *
     * @param productIdVo 条件
     * @return
     */
    @PostMapping("/productPhysicalBeauticianRef/1.1.1/listInventoryByProductId")
    ResponseMessage<List<ProductPhysicalBeauticianRef>> listInventoryByProductIdV111(@RequestBody PhysicalBeauticianRefListInventoryByProductIdVo productIdVo);


}