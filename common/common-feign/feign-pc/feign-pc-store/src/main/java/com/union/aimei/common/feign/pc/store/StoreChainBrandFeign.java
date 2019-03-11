package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreChainBrandApiHystrix;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreChainBrandApiHystrix.class)
public interface StoreChainBrandFeign {
    /**
     * 添加门店连锁品牌
     *
     * @param storeChainBrand
     * @return
     */
    @PostMapping(value = "/storeChainBrand/insert")
    int insert(@RequestBody StoreChainBrand storeChainBrand);


    /**
     * 删除门店连锁品牌
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeChainBrand/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改门店连锁品牌
     *
     * @param storeChainBrand
     * @return
     */
    @PutMapping(value = "/storeChainBrand/edit")
    int edit(@RequestBody StoreChainBrand storeChainBrand);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreChainBrand
     */
    @GetMapping(value = "/storeChainBrand/queryById/{id}")
    StoreChainBrand queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询门店连锁品牌
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param storeChainBrand 查询条件
     * @return
     */
    @PostMapping(value = "/storeChainBrand/front/findByPage")
    PageInfo<StoreChainBrand> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                 @RequestBody StoreChainBrand storeChainBrand);

    /**
     * 根据品牌ID累积店铺总数
     *
     * @param brandId 品牌ID
     * @param number  累积数
     * @return
     */
    @PutMapping("/storeChainBrand/accumStoreTotalByBrandId/{brandId}/{number}")
    ResponseMessage accumStoreTotalByBrandId(@PathVariable(value = "brandId") int brandId,
                                             @PathVariable(value = "number") int number);

    /**
     * 根据品牌ID累积商品总数
     *
     * @param brandId 品牌ID
     * @param number  累积数
     * @return
     */
    @PutMapping("/storeChainBrand/accumProductTotalByBrandId/{brandId}/{number}")
    ResponseMessage accumProductTotalByBrandId(@PathVariable(value = "brandId") int brandId,
                                               @PathVariable(value = "number") int number);

    /**
     * 新增门店连锁品牌, 限定 品牌所属公司下的所有品牌名称不可重复
     *
     * @param storeChainBrand 数据
     * @return
     */
    @PostMapping(value = "/storeChainBrand/insertLimitBrandOwnershipCompany")
    ResponseMessage insertLimitBrandOwnershipCompany(@RequestBody StoreChainBrand storeChainBrand);

    /**
     * 修改门店连锁品牌, 限定 品牌所属公司下的所有品牌名称不可重复
     *
     * @param storeChainBrand 数据
     * @return
     */
    @PostMapping(value = "/storeChainBrand/editLimitBrandOwnershipCompany")
    ResponseMessage editLimitBrandOwnershipCompany(@RequestBody StoreChainBrand storeChainBrand);


    /**
     * 判断校验品牌名字是否重复
     *
     * @param brandName
     * @param brandId
     * @return
     */
    @GetMapping(value = "/storeChainBrand/findLimitBrandCompany/{brandName}/{brandId}")
    ResponseMessage findLimitBrandCompany(@ApiParam(value = "品牌名") @PathVariable(value = "brandName") String brandName,
                                          @ApiParam(value = "品牌id") @PathVariable(value = "brandId") int brandId);


}