package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.StoreCouponsApiHystrix;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺优惠券
 *
 * @author liurenkai
 * @time 2017/12/22 15:43
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreCouponsApiHystrix.class)
public interface StoreCouponsFeign {

    /**
     * 前端分页查询店铺优惠券
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param storeCoupons 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺优惠券")
    @PostMapping("/storeCoupons/front/findByPage")
    PageInfo<StoreCoupons> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                              @ApiParam(value = "查询条件") @RequestBody StoreCoupons storeCoupons);

    /**
     * 根据商品ID分页查询优惠券
     *
     * @param pageNo      分页索引
     * @param pageSize    每页数量
     * @param productIdVo 查询条件
     * @return
     */
    @PostMapping("/storeCoupons/findByPageForProductId")
    ResponseMessage<PageInfo<StoreCoupons>> findByPageForProductId(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                   @RequestBody CouponsByProductIdVo productIdVo);

    /**
     * 新增店铺优惠券
     *
     * @param storeCouponsVo 店铺优惠券vo
     * @return
     */
    @PostMapping(value = "/storeCoupons/add")
    ResponseMessage add(@RequestBody StoreCouponsVo storeCouponsVo);

    /**
     * 修改店铺优惠券软删除标记
     *
     * @param id        店铺优惠券ID
     * @param isEnabled 软删除标记
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改店铺优惠券软删除标记")
    @PutMapping(value = "/storeCoupons/isEnabled/{id}/{isEnabled}")
    ResponseMessage isEnabled(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "id") int id,
                              @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled);

    /**
     * 根据ID查询店铺优惠券
     *
     * @param id 店铺优惠券ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询店铺优惠券")
    @GetMapping("/storeCoupons/findById/{id}")
    ResponseMessage<StoreCoupons> findById(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "id") int id);

    /**
     * 根据会员ID查询店铺的店铺优惠券
     *
     * @param pageNo                           分页索引
     * @param pageSize                         每页数量
     * @param storeCouponsByMemberIdForStoreVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据会员ID查询店铺的店铺优惠券")
    @PostMapping("/storeCoupons/findByPageForMemberIdForStore")
    ResponseMessage<PageInfo<StoreCouponsByMemberIdForStoreResultVo>> findByPageForMemberIdForStore(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                    @ApiParam(value = "查询条件") @RequestBody StoreCouponsByMemberIdForStoreVo storeCouponsByMemberIdForStoreVo);

    /**
     * 根据会员ID查询服务的店铺优惠券
     *
     * @param pageNo                             分页索引
     * @param pageSize                           每页数量
     * @param storeCouponsByMemberIdForProductVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据会员ID查询服务的店铺优惠券")
    @PostMapping("/storeCoupons/findByPageForMemberIdForProduct")
    ResponseMessage<PageInfo<StoreCouponsByMemberIdForProductResultVo>> findByPageForMemberIdForProduct(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                        @ApiParam(value = "查询条件") @RequestBody StoreCouponsByMemberIdForProductVo storeCouponsByMemberIdForProductVo);

    /**
     * 根据会员ID查询领取的店铺优惠券
     *
     * @param pageNo                              分页索引
     * @param pageSize                            每页数量
     * @param storeCouponsByMemberIdForReceivedVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据会员ID查询领取的店铺优惠券")
    @PostMapping("/storeCoupons/findByPageForMemberIdForReceived")
    ResponseMessage<PageInfo<StoreCouponsByMemberIdForReceivedResultVo>> findByPageForMemberIdForReceived(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                          @ApiParam(value = "查询条件") @RequestBody StoreCouponsByMemberIdForReceivedVo storeCouponsByMemberIdForReceivedVo);

    /**
     * 根据会员ID查询领取的店铺优惠券总数
     *
     * @param memberId 会员ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据会员ID查询领取的店铺优惠券总数")
    @GetMapping("/storeCoupons/findCountByMemberIdForReceived/{memberId}")
    ResponseMessage<Integer> findCountByMemberIdForReceived(@ApiParam(value = "会员ID") @PathVariable(value = "memberId") Integer memberId);


    /**
     * 根据商品查询领取的最佳店铺优惠券（提交订单）
     *
     * @param storeCouponsByProductForBestForOrderVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品查询领取的最佳店铺优惠券（提交订单）")
    @PostMapping("/storeCoupons/findByProductForBestForOrder")
    ResponseMessage<CouponsByProductForOrderResVo> findByProductForBestForOrder(@ApiParam("查询条件") @RequestBody StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo);


    /**
     * 根据商品分页查询领取的店铺优惠券（提交订单）
     *
     * @param pageNo                                 分页索引
     * @param pageSize                               每页数量
     * @param storeCouponsByProductForBestForOrderVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品分页查询领取的店铺优惠券（提交订单）")
    @PostMapping("/storeCoupons/findByPageForProductForOrder")
    ResponseMessage<PageInfo<CouponsByProductForOrderResVo>> findByPageForProductForOrder(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                          @ApiParam("查询条件") @RequestBody StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo);

}