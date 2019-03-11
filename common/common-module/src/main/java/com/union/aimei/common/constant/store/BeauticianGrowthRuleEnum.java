package com.union.aimei.common.constant.store;

/**
 * 美容师成长值枚举
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public enum BeauticianGrowthRuleEnum {

    //通过APP每日成功登录后自动增加
    DAILY_LOGIN("每日登录", GrowthRuleConstant.BeauticianEnumConstant.DAILY_LOGIN),

    //邦女郎通过APP填写实名认证信息，运营人员审核通过以后获得
    VERIFIED("实名认证", GrowthRuleConstant.BeauticianEnumConstant.VERIFIED),

    //邦女郎通过APP成功报名后自动获得
    SIGN_COURSE("报名参加课程", GrowthRuleConstant.BeauticianEnumConstant.SIGN_COURSE),

    //邦女郎通过APP成功报名后自动获得
    SIGN_ACTIVITY("报名参加活动", GrowthRuleConstant.BeauticianEnumConstant.SIGN_ACTIVITY),

    //门店通过邦女郎的项目申请后自动获得
    SUCCESS_PRODUCT("成功申请项目", GrowthRuleConstant.BeauticianEnumConstant.SUCCESS_PRODUCT),

    //用户对订单进行1星评价时，自动扣减成长值
    ORDER_BAD_REVIEW("用户订单差评", GrowthRuleConstant.BeauticianEnumConstant.ORDER_BAD_REVIEW),

    //用户对订单进行5星评价时，自动获取成长值
    ORDER_PRAISE("用户订单好评", GrowthRuleConstant.BeauticianEnumConstant.ORDER_PRAISE);

    private String message;
    private String code;

    BeauticianGrowthRuleEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
