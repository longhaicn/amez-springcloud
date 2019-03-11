package com.union.aimei.common.constant.common;

/**
 * redis常量
 *
 * @author liurenkai
 * @time 2018/8/15 11:14
 */
public interface RedisConstant {

    /**
     * 门店
     */
    interface Store {
        /**
         * 门店开通城市
         */
        String STORE_OPEN_CITY = "STORE_OPEN_CITY";
    }


    /**
     * 首页模版
     */
    interface BaseHomeTemplate {
        /**
         * 使用类型 用户端，
         */
        String BASE_HOME_TEMPLATE_USER_TYPE_USER = "BASE_HOME_USER_TYPE_USER";
        /**
         * 使用类型 帮女郎，
         */
        String BASE_HOME_TEMPLATE_USER_TYPE_HELP_GIRL = "BASE_HOME_USER_TYPE_HELP_GIRL";
        /**
         * 使用类型 门店端
         */
        String BASE_HOME_TEMPLATE_USER_TYPE_STORE_SIDE = "BASE_HOME_USER_TYPE_STORE_SIDE";
    }


}
