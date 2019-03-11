package com.union.aimei.common.constant.store;

/**
 * @author caizhaoming
 * 店铺-美容师等级常量
 * @create 2018-06-25 16:15
 **/
public class StoreBeauticianGradeConstant {

    public static int CONDITION_TYPE_DEFAULT = 0;

    /**
     * 删除 5xx
     */
    public interface Delete {
        int DELETE_ERROR = 501;
        String DELETE_ERROR_MESSAGE_NOT_DELETE = "该等级下已有美容师，不可删除";
    }


}
