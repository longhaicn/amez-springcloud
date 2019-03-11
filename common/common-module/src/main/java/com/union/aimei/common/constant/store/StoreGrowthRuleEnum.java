package com.union.aimei.common.constant.store;

/**
 * 店铺成长值枚举
 *
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public enum StoreGrowthRuleEnum {

    //通过APP每日成功登录后自动增加
    DAILY_LOGIN("每日登录", GrowthRuleConstant.StoreEnumConstant.DAILY_LOGIN),

    //门店通过APP填写店铺资质认证信息，运营人员审核通过以后获得
    VERIFIED("实名认证", GrowthRuleConstant.StoreEnumConstant.VERIFIED),

    //门店通过APP成功报名后自动获得
    SIGN_ACTIVITY("报名参加活动", GrowthRuleConstant.StoreEnumConstant.SIGN_ACTIVITY),

    //门店通过项目招募邀约兼职邦女郎，邦女郎成功通过申请，门店自动获得成长值
    SUCCESS_RECRUIT("成功项目招募", GrowthRuleConstant.StoreEnumConstant.SUCCESS_RECRUIT),

    //用户对订单进行1星评价时，自动扣减成长值
    ORDER_BAD_REVIEW("用户订单差评", GrowthRuleConstant.StoreEnumConstant.ORDER_BAD_REVIEW),

    //用户对订单进行5星评价时，自动获取成长值
    ORDER_PRAISE("用户订单好评", GrowthRuleConstant.StoreEnumConstant.ORDER_PRAISE),

    //门店发布自营项目，平台通过审核后，门店自动获得成长值
    SELF_SUPPORT("成功发布自营项目", GrowthRuleConstant.StoreEnumConstant.SELF_SUPPORT);


    private String message;
    private String code;

    StoreGrowthRuleEnum(String message, String code) {
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
