package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreCouponsFeign;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.store.app.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 店铺优惠券
 *
 * @author liurenkai
 * @time 2017/12/22 16:19
 */
@Component(value = "app-StoreCouponsFeign")
public class StoreCouponsApiHystrix implements StoreCouponsFeign {

    @Override
    public PageInfo<StoreCoupons> findByPageForFront(Integer pageNo, Integer pageSize, StoreCoupons storeCoupons) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<StoreCoupons>> findByPageForProductId(Integer pageNo, Integer pageSize, CouponsByProductIdVo productIdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage add(StoreCouponsVo storeCouponsVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage isEnabled(int id, int isEnabled) {
        return null;
    }

    @Override
    public ResponseMessage<StoreCoupons> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForStoreResultVo>> findByPageForMemberIdForStore(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForStoreVo storeCouponsByMemberIdForStoreVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForProductResultVo>> findByPageForMemberIdForProduct(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForProductVo storeCouponsByMemberIdForProductVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreCouponsByMemberIdForReceivedResultVo>> findByPageForMemberIdForReceived(Integer pageNo, Integer pageSize, StoreCouponsByMemberIdForReceivedVo storeCouponsByMemberIdForReceivedVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> findCountByMemberIdForReceived(Integer memberId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<CouponsByProductForOrderResVo> findByProductForBestForOrder(StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<CouponsByProductForOrderResVo>> findByPageForProductForOrder(Integer pageNo, Integer pageSize, StoreCouponsByProductForBestForOrderVo storeCouponsByProductForBestForOrderVo) {
        return HystrixResponse.invokeFail();
    }
}