package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.StoreCouponsProductApiHystrix;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2017/12/22 15:43
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreCouponsProductApiHystrix.class)
public interface StoreCouponsProductFeign {

    /**
     * 前端分页查询优惠券-服务-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param storeCouponsProduct 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据店铺优惠券ID查询优惠券-服务-关联")
    @PostMapping("/storeCouponsProduct/front/findByPage")
    PageInfo<StoreCouponsProduct> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @ApiParam(value = "查询条件") @RequestBody StoreCouponsProduct storeCouponsProduct);

    /**
     * 根据店铺优惠券ID查询优惠券-服务-关联
     *
     * @param storeCouponsId 店铺优惠券ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店铺优惠券ID查询优惠券-服务-关联")
    @GetMapping("/storeCouponsProduct/findListByStoreCouponsId/{storeCouponsId}")
    ResponseMessage<List<StoreCouponsProduct>> findListByStoreCouponsId(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "storeCouponsId") int storeCouponsId);
}