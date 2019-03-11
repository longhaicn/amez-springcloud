package com.union.aimei.store.constant;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreCoupons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 条件常量
 *
 * @author liurenkai
 * @time 2018/4/26 10:59
 */
public class CondConstant {

    /**
     * 商品优惠券
     *
     * @param isNotStart 未开始
     * @param isActive   活动中
     * @param isOver     已结束
     * @return
     */
    public static Map<String, Object> couponByProduct(boolean isNotStart, boolean isActive, boolean isOver) {
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.put("allService", StoreCoupons.SupportServiceType.ALL);
        condMap.put("someService", StoreCoupons.SupportServiceType.SOME);
        List<Integer> couponStatusList = new ArrayList<>(10);
        if (isNotStart) {
            couponStatusList.add(StoreCoupons.CouponStatus.NOT_START);
        }
        if (isActive) {
            couponStatusList.add(StoreCoupons.CouponStatus.ACTIVE);
        }
        if (isOver) {
            couponStatusList.add(StoreCoupons.CouponStatus.OVER);
        }
        condMap.put("couponStatusList", couponStatusList);
        return condMap;
    }

}
