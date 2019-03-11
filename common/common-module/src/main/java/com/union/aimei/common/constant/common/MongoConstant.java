package com.union.aimei.common.constant.common;

/**
 * mongo的collectionName
 *
 * @author czm
 * @version 1.0
 * @create 2018-08-24 10:57
 **/
public interface MongoConstant {

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
