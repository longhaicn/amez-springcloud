package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.vo.store.app.*;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.common.utils.ResponseMessage;

/**
 * 优惠券
 *
 * @author liurenkai
 * @time 2017/12/26 11:08
 */
public interface StoreCouponsService {
    /**
     * 前端分页查询优惠券
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param storeCoupons 查询条件
     * @return
     */
    PageInfo<StoreCoupons> findByPageForFront(Integer pageNo, Integer pageSize, StoreCoupons storeCoupons);

    /**
     * 根据商品ID查询优惠券
     *
     * @param pageNo      分页索引
     * @param pageSize    每页数量
     * @param productIdVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreCoupons>> findByPageForProductId(Integer pageNo, Integer pageSize, CouponsByProductIdVo productIdVo);

    /**
     * 新增优惠券
     *
     * @param storeCouponsVo 优惠券vo
     * @return
     */
    ResponseMessage add(StoreCouponsVo storeCouponsVo);

    /**
     * 修改优惠券软删除标记
     *
     * @param id        优惠券ID
     * @param isEnabled 软删除标记
     * @return
     */
    ResponseMessage isEnabled(int id, int isEnabled);

    /**
     * 根据ID查询优惠券
     *
     * @param id 优惠券ID
     * @return
     */
    ResponseMessage<StoreCoupons> findById(int id);

    /**
     * 根据会员ID查询店铺的优惠券
     *
     * @param pageNo                           分页索引
     * @param pageSize                         每页数量
     * @param storeCouponsByMemberIdForStoreVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreCouponsByMemberIdForStoreResultVo>> findByPageForMemberIdForStore(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForStoreVo storeCouponsByMemberIdForStoreVo);

    /**
     * 根据会员ID查询服务的优惠券
     *
     * @param pageNo                             分页索引
     * @param pageSize                           每页数量
     * @param storeCouponsByMemberIdForProductVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreCouponsByMemberIdForProductResultVo>> findByPageForMemberIdForProduct(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForProductVo storeCouponsByMemberIdForProductVo);

    /**
     * 根据会员ID查询领取的优惠券
     *
     * @param pageNo                              分页索引
     * @param pageSize                            每页数量
     * @param storeCouponsByMemberIdForReceivedVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreCouponsByMemberIdForReceivedResultVo>> findByPageForMemberIdForReceived(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForReceivedVo storeCouponsByMemberIdForReceivedVo);

    /**
     * 根据会员ID查询领取的优惠券总数
     *
     * @param memberId 会员ID
     * @return
     */
    ResponseMessage<Integer> findCountByMemberIdForReceived(Integer memberId);

    /**
     * 根据商品查询领取的最佳优惠券（提交订单）
     *
     * @param storeCouponsByProductForBestForOrderVo 查询条件
     * @return
     */
    ResponseMessage<CouponsByProductForOrderResVo> findByProductForBestForOrder(StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo);

    /**
     * 根据商品分页查询领取的优惠券（提交订单）
     *
     * @param pageNo                                 分页索引
     * @param pageSize                               每页数量
     * @param storeCouponsByProductForBestForOrderVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<CouponsByProductForOrderResVo>> findByPageForProductForOrder(Integer pageNo, Integer pageSize, StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo);

}