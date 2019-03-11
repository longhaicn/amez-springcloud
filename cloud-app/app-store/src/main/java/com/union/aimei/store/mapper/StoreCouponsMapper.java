package com.union.aimei.store.mapper;

import com.union.aimei.common.vo.store.app.CouponsByProductForOrderResVo;
import com.union.aimei.common.vo.store.app.StoreCouponsByMemberIdForProductResultVo;
import com.union.aimei.common.vo.store.app.StoreCouponsByMemberIdForReceivedResultVo;
import com.union.aimei.common.vo.store.app.StoreCouponsByMemberIdForStoreResultVo;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 优惠券
 *
 * @author liurenkai
 * @time 2017/12/22 14:15
 */
public interface StoreCouponsMapper extends BaseMapper<StoreCoupons> {

    /**
     * 根据商品ID查询优惠券
     *
     * @param condMap 条件
     * @return
     */
    List<StoreCoupons> selectListByProductId(Map<String, Object> condMap);

    /**
     * 根据会员ID查询店铺的优惠券
     *
     * @param condMap 条件
     * @return
     */
    List<StoreCouponsByMemberIdForStoreResultVo> selectListByMemberIdForStore(Map<String, Object> condMap);

    /**
     * 根据会员ID查询商品的优惠券
     *
     * @param condMap 条件
     * @return
     */
    List<StoreCouponsByMemberIdForProductResultVo> selectListByMemberIdForProduct(Map<String, Object> condMap);

    /**
     * 根据会员ID查询领取的优惠券（店铺）
     *
     * @param condMap 条件
     * @return
     */
    List<StoreCouponsByMemberIdForReceivedResultVo> selectListByMemberIdForReceived(Map<String, Object> condMap);

    /**
     * 根据会员ID查询领取的优惠券（商品）
     *
     * @param condMap 条件
     * @return
     */
    List<StoreCouponsByMemberIdForReceivedResultVo> selectListByMemberIdForReceivedForProduct(Map<String, Object> condMap);

    /**
     * 根据会员ID查询领取的优惠券总数
     *
     * @param condMap 条件
     * @return
     */
    int selectCountByMemberIdForReceived(Map<String, Object> condMap);

    /**
     * 根据商品查询领取的最佳优惠券（提交订单）
     *
     * @param condMap 条件
     * @return
     */
    CouponsByProductForOrderResVo selectByProductForBestForOrder(Map<String, Object> condMap);

    /**
     * 根据商品分页查询领取的优惠券（提交订单）
     *
     * @param condMap 条件
     * @return
     */
    List<CouponsByProductForOrderResVo> selectListByProductForOrder(Map<String, Object> condMap);

}