package com.union.aimei.common.constant.store;

/**
 * 成长规则常量
 *
 * @author caizhaoming
 * @create 2018-06-21 11:01
 **/
public class GrowthRuleConstant {

    public static int CONDITION_TYPE_DEFAULT = 0;
    public static String BREQUIRED_PARAMETER_MISSING = "必传参数缺失，请仔细检查";
    public static int REQUIRED_PARAMETER_CODE = 500;

    /**
     * 保存 2xx
     */
    public interface Save {
        int GROWTH_RULE_CODE = 201;
        String GROWTH_RULE_CODE_MESSAGE = "编码重复";
        String GROWTH_RULE_DATA_ERROR = "编码重复，数据错误";
        String GROWTH_RULE_DATA_GET_ERROR = "编码数据错误";
        String THE_NUMBER_OF_LIMITS_IS_FULL = "限制次数已满，无法增加成长值";
        String LIMIT_MONTHLY_LIMIT_IS_FULL = "限制每月上限已满，无法增加成长值";
        String LIMIT_DAILY_LIMIT_IS_FULL = "限制每日上限已满，无法增加成长值";
        String THE_CODE_WAS_NOT_FOUND = "未找到该成长值编码，可能未生效或已删除";
        String THIS_DATA_HAS_BEEN_ADDED_TO_THE_GROWTH = "该数据已添加过成长值，无法重复添加";
        String LACK_GROWTH_TYPE_MESSAGE = "缺少成长规则类型参数";
    }

    /**
     * 修改 3xx
     */
    public interface Edit {
        int LACK_ID = 301;
        String LACK_ID_MESSAGE = "缺少id参数";
    }

    /**
     * 参数
     */
    public interface Param {
        String TOTAL_GROWTH_VALUE = "totalGrowthValue";
    }


    /**
     * 店铺枚举常量
     */
    public interface StoreEnumConstant {
        /**
         * 每日登录
         */
        String DAILY_LOGIN = "MRDL";
        /**
         * 实名认证
         */
        String VERIFIED = "SMRZ";
        /**
         * 报名参加活动
         */
        String SIGN_ACTIVITY = "BMCJHD";
        /**
         * 成功项目招募
         */
        String SUCCESS_RECRUIT = "CGSQZM";
        /**
         * 用户订单差评
         */
        String ORDER_BAD_REVIEW = "YHDDCP";
        /**
         * 用户订单好评
         */
        String ORDER_PRAISE = "YHDDHP";
        /**
         * 成功发布自营项目
         */
        String SELF_SUPPORT = "CGFBZYXM";
    }

    /**
     * 美容师枚举常量
     */
    public interface BeauticianEnumConstant {
        /**
         * 每日登录
         */
        String DAILY_LOGIN = "MRDL";
        /**
         * 实名认证
         */
        String VERIFIED = "SMRZ";
        /**
         * 报名参加课程
         */
        String SIGN_COURSE = "BMCJKC";
        /**
         * 报名参加活动
         */
        String SIGN_ACTIVITY = "BMCJHD";
        /**
         * 成功申请项目
         */
        String SUCCESS_PRODUCT = "CGSQXM";
        /**
         * 用户订单差评
         */
        String ORDER_BAD_REVIEW = "YHDDCP";
        /**
         * 用户订单好评
         */
        String ORDER_PRAISE = "YHDDHP";
    }

}
