package com.union.aimei.common.constant.base;

/**
 * @author GaoWei
 * @time 2018/6/6 14:35
 * @description 短信码常量枚举类
 */
public enum SmsConstant {

    /**
     * 用户登录验证码
     */
    MEMBER_LOGIN("用户登录验证码", "SMS_136399709"),
    /**
     * 找回密码验证码
     */
    RETRIEVE_PASSWORD("找回密码验证码", "SMS_136399711"),
    /**
     * 修改登录密码验证码
     */
    MODIFY_LOGIN_PASSWORD("修改登录密码验证码", "SMS_136383291"),
    /**
     * 修改支付密码验证码
     */
    MODIFY_PAY_PASSWORD("修改支付密码验证码", "SMS_136393208"),
    /**
     * 店铺开通通知
     */
    SHOP_OPENING("店铺开通通知", "SMS_136398147"),
    /**
     * 店长注册手机
     */
    STORE_HEAD_REGISTERED_MOBILE("店长注册手机", "SMS_136398152"),
    /**
     * 店长账号注册成功
     */
    STORE_HEAD_REGISTERED_SUCCESS("店长账号注册成功", "SMS_136393225"),
    /**
     * 店铺冻结通知
     */
    STORE_FREEZING("店铺冻结通知", "SMS_136383310"),
    /**
     * 店铺关闭通知
     */
    STORE_CLOSE("店铺关闭通知", "SMS_136383318"),
    /**
     * 支付成功通知用户
     */
    PAY_SUCCESS("支付成功通知用户", "SMS_136388194"),
    /**
     * 支付成功通知美容师
     */
    PAY_SUCCESS_NOTIFY_BEAUTICIAN("支付成功通知美容师", "SMS_136383320"),
    /**
     * 支付成功通知门店(门店自营项目)
     */
    PAY_SUCCESS_NOTIFY_STORE_FOR_STORE_SELL("支付成功通知门店(门店自营项目)", "SMS_136398166"),
    /**
     * 服务开始通知用户
     */
    SERVICE_START("服务开始通知用户", "SMS_136383325"),
    /**
     * 服务开始提醒美容师
     */
    SERVICE_START_NOTIFY_BEAUTICIAN("服务开始提醒美容师", "SMS_136393241"),
    /**
     * 服务开始提醒门店
     */
    SERVICE_START_NOTIFY_STORE("服务开始提醒门店", "SMS_136393244"),
    /**
     * 退款提醒美容师
     */
    REFUND_NOTIFY_BEAUTICIAN("退款提醒美容师", "SMS_136393248"),
    /**
     * 退款提醒-门店(门店自营项目)
     */
    REFUND_NOTIFY_STORE_FOR_STORE_SELL("退款提醒-门店(门店自营项目)", "SMS_136388204"),
    /**
     * 退款成功通知-用户
     */
    REFUND_SUCCESS_NOTIFY_CUSTOMER("退款成功通知-用户", "SMS_136393251"),
    /**
     * 退款失败通知
     */
    REFUND_FAIL_NOTIFY_CUSTOMER("退款失败通知", "SMS_136383341"),
    /**
     * 退款撤销通知美容师
     */
    REFUND_CANCEL_NOTIFY_BEAUTICIAN("退款撤销通知美容师", "SMS_136393254"),
    /**
     * 退款撤销通知门店(门店自营项目)
     */
    REFUND_CANCEL_NOTIFY_STORE_FOR_STORE_SELL("退款撤销通知门店(门店自营项目)", "SMS_136398181"),
    /**
     * 参加活动提醒-门店
     */
    JOIN_TRAINING_COURSE_NOTIFY_STORE("参加活动提醒-门店", "SMS_136393292"),
    /**
     * 参加培训课程提醒
     */
    JOIN_TRAINING_COURSE_NOTIFY_CUSTOMER("参加培训课程提醒", "SMS_136393285"),
    /**
     * 后台给店铺月账单打款
     */
    MAKE_MONEY_TO_STORE("后台给店铺月账单打款", "SMS_136398204"),
    /**
     * 后台给美容师提现申请打款
     */
    MAKE_MONEY_TO_BEAUTICIAN("后台给美容师提现申请打款", "SMS_136388218"),
    /**
     * 参加活动提醒-美容师
     */
    JOIN_TRAINING_ACTIVITY_NOTIFY_CUSTOMER("参加活动提醒-美容师", "SMS_136398209");

    SmsConstant(String smsName, String smsCode) {
        this.smsName = smsName;
        this.smsCode = smsCode;
    }

    private String smsName;
    private String smsCode;

    public String getSmsCode() {
        return smsCode;
    }

    public String getSmsName() {
        return smsName;
    }

}
