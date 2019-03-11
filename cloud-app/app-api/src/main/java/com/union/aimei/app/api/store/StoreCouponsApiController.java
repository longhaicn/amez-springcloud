package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreCouponsFeign;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺优惠券
 *
 * @author liurenkai
 * @time 2017/12/22 15:43
 */
@Api(tags = "店铺优惠券")
@RestController
@RequestMapping(value = "storeCoupons")
public class StoreCouponsApiController {
    @Resource
    private StoreCouponsFeign storeCouponsFeign;

    /**
     * 前端分页查询店铺优惠券表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param storeCoupons 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺优惠券表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreCoupons>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      @ApiParam(value = "查询条件") @RequestBody StoreCoupons storeCoupons) {
        return new ResponseMessage<>(this.storeCouponsFeign.findByPageForFront(pageNo, pageSize, storeCoupons));
    }

    /**
     * 根据商品ID分页查询优惠券
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param productIdVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品ID分页查询优惠券")
    @PostMapping("/findByPageForProductId")
    public ResponseMessage<PageInfo<StoreCoupons>> findByPageForProductId(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                          @ApiParam(value = "查询条件") @RequestBody CouponsByProductIdVo productIdVo) {
        return this.storeCouponsFeign.findByPageForProductId(pageNo, pageSize, productIdVo);
    }

    /**
     * 新增店铺优惠券
     *
     * @param storeCouponsVo 店铺优惠券vo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增店铺优惠券")
    @PostMapping(value = "/add")
    public ResponseMessage add(@RequestBody StoreCouponsVo storeCouponsVo) {
        return this.storeCouponsFeign.add(storeCouponsVo);
    }

    /**
     * 修改店铺优惠券软删除标记
     *
     * @param id        店铺优惠券ID
     * @param isEnabled 软删除标记
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改店铺优惠券软删除标记")
    @PutMapping(value = "/isEnabled/{id}/{isEnabled}")
    public ResponseMessage isEnabled(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "id") int id,
                                     @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled) {
        return this.storeCouponsFeign.isEnabled(id, isEnabled);
    }

    /**
     * 根据ID查询店铺优惠券
     *
     * @param id 店铺优惠券ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询店铺优惠券")
    @GetMapping("/findById/{id}")
    public ResponseMessage<StoreCoupons> findById(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "id") int id) {
        return this.storeCouponsFeign.findById(id);
    }

    /**
     * 根据会员ID查询店铺的店铺优惠券
     *
     * @param pageNo                           分页索引
     * @param pageSize                         每页数量
     * @param storeCouponsByMemberIdForStoreVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据会员ID查询店铺的店铺优惠券")
    @PostMapping("/findByPageForMemberIdForStore")
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForStoreResultVo>> findByPageForMemberIdForStore(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                           @ApiParam(value = "查询条件") @RequestBody StoreCouponsByMemberIdForStoreVo storeCouponsByMemberIdForStoreVo) {
        return this.storeCouponsFeign.findByPageForMemberIdForStore(pageNo, pageSize, storeCouponsByMemberIdForStoreVo);
    }

    /**
     * 根据会员ID查询服务的店铺优惠券
     *
     * @param pageNo                             分页索引
     * @param pageSize                           每页数量
     * @param storeCouponsByMemberIdForProductVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据会员ID查询服务的店铺优惠券")
    @PostMapping("/findByPageForMemberIdForProduct")
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForProductResultVo>> findByPageForMemberIdForProduct(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                               @ApiParam(value = "查询条件") @RequestBody StoreCouponsByMemberIdForProductVo storeCouponsByMemberIdForProductVo) {
        return this.storeCouponsFeign.findByPageForMemberIdForProduct(pageNo, pageSize, storeCouponsByMemberIdForProductVo);
    }

    /**
     * 根据会员ID查询领取的店铺优惠券
     *
     * @param pageNo                              分页索引
     * @param pageSize                            每页数量
     * @param storeCouponsByMemberIdForReceivedVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据会员ID查询领取的店铺优惠券")
    @PostMapping("/findByPageForMemberIdForReceived")
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForReceivedResultVo>> findByPageForMemberIdForReceived(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                                 @ApiParam(value = "查询条件") @RequestBody StoreCouponsByMemberIdForReceivedVo storeCouponsByMemberIdForReceivedVo) {
        return this.storeCouponsFeign.findByPageForMemberIdForReceived(pageNo, pageSize, storeCouponsByMemberIdForReceivedVo);
    }

    /**
     * 根据会员ID查询领取的店铺优惠券总数
     *
     * @param memberId 会员ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据会员ID查询领取的店铺优惠券总数")
    @GetMapping("/findCountByMemberIdForReceived/{memberId}")
    public ResponseMessage<Integer> findCountByMemberIdForReceived(@ApiParam(value = "会员ID") @PathVariable(value = "memberId") Integer memberId) {
        return this.storeCouponsFeign.findCountByMemberIdForReceived(memberId);
    }

    /**
     * 根据商品查询领取的最佳店铺优惠券（提交订单）
     *
     * @param storeCouponsByProductForBestForOrderVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品查询领取的最佳店铺优惠券（提交订单）")
    @PostMapping("/findByProductForBestForOrder")
    public ResponseMessage<CouponsByProductForOrderResVo> findByProductForBestForOrder(@ApiParam("查询条件") @RequestBody StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo) {
        return this.storeCouponsFeign.findByProductForBestForOrder(storeCouponsByProductForBestForOrderVo);
    }

    /**
     * 根据商品分页查询领取的店铺优惠券（提交订单）
     *
     * @param pageNo                                 分页索引
     * @param pageSize                               每页数量
     * @param storeCouponsByProductForBestForOrderVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据商品分页查询领取的店铺优惠券（提交订单）")
    @PostMapping("/findByPageForProductForOrder")
    public ResponseMessage<PageInfo<CouponsByProductForOrderResVo>> findByPageForProductForOrder(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                 @ApiParam("查询条件") @RequestBody StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo) {
        return this.storeCouponsFeign.findByPageForProductForOrder(pageNo, pageSize, storeCouponsByProductForBestForOrderVo);
    }

}