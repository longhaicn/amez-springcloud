package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.store.service.StoreCouponsProductService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 店铺优惠券-商品-关联controller
 *
 * @author liurenkai
 * @time 2017/12/22 15:43
 */
@Api(tags = "店铺优惠券-商品-关联")
@RestController
@RequestMapping(value = "storeCouponsProduct")
public class StoreCouponsProductController {
    @Resource
    private StoreCouponsProductService storeCouponsProductService;

    /**
     * 前端分页查询店铺优惠券-商品-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param storeCouponsProduct 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据店铺优惠券ID查询店铺优惠券-商品-关联")
    @PostMapping("/front/findByPage")
    public PageInfo<StoreCouponsProduct> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                            @ApiParam(value = "查询条件") @RequestBody StoreCouponsProduct storeCouponsProduct) {
        return this.storeCouponsProductService.findByPageForFront(pageNo, pageSize, storeCouponsProduct);
    }

    /**
     * 根据店铺优惠券ID查询店铺优惠券-商品-关联
     *
     * @param storeCouponsId 店铺优惠券ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店铺优惠券ID查询店铺优惠券-商品-关联")
    @GetMapping("/findListByStoreCouponsId/{storeCouponsId}")
    ResponseMessage<List<StoreCouponsProduct>> findListByStoreCouponsId(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "storeCouponsId") int storeCouponsId) {
        return this.storeCouponsProductService.findListByStoreCouponsId(storeCouponsId);
    }
}