package com.union.aimei.store.util;

/**
 * 店铺优惠券号码工具类
 *
 * @author liurenkai
 * @time 2017/12/22 11:05
 */
public class StoreCouponNumberUtils {

    /**
     * 生成
     *
     * @return
     */
    public static String get() {
        return String.valueOf(System.currentTimeMillis());
    }
}
