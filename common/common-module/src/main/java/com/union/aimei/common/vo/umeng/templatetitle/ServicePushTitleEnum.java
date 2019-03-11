package com.union.aimei.common.vo.umeng.templatetitle;

/**
 * @author houji
 * @time 2018/6/7 15:56
 * @description 消息推送-服务消息title的key-value
 */
public enum ServicePushTitleEnum {

    /**
     * 服务消息推送模板
     */
    PAY_SUCCESS_TO_BEAUTICIAN_KEY_VALUE("用户订单付款成功推送消息给美容师key",null,null),
    PAY_SUCCESS_TO_STORE_KEY_VALUE("用户订单付款成功推送消息给店长",null,null),
    SERVICE_BEFORE_TO_USER_KEY_VALUE("服务开始前30分钟推送消息给用户",null,null),
    SERVICE_BEFORE_TO_BEAUTICIAN_KEY_VALUE("服务开始前30分钟推送消息给美容师",null,null),
    SERVICE_BEFORE_TO_STORE_KEY_VALUE("服务开始前30分钟推送消息给美容师",null,null),
    SERVICE_EVALUATION_TO_USER_KEY_VALUE("服务完成推送消息给用户订单评价提醒",null,null),
    SERVICE_EVALUATION_TO_BEAUTICIAN_KEY_VALUE("用户主动评价后推送消息给美容师进行查看评价",null,null),
    SERVICE_EVALUATION_TO_STORE_KEY_VALUE("用户主动评价后推送消息给店长查看评价(门店自营项目)",null,null),
    USER_REFUND_TO_BEAUTICIAN_KEY_VALUE("用户发起退款推送消息给美容师进行查看",null,null),
    USER_REFUND_TO_STORE_KEY_VALUE("用户发起退款推送消息给店长进行查看(门店自营项目)",null,null),
    APPROVAL_REFUND_TO_USER_KEY_VALUE("门店/邦女郎 同意退款推送消息给用户",null,null),
    REFUSES_REFUND_TO_USER_KEY_VALUE("门店/邦女郎 拒绝退款推送消息给用户",null,null),
    USER_CANCEL_REFUND_TO_BEAUTICIAN_KEY_VALUE("用户撤销退款申请推送消息给美容师","orderno","你的订单编号"),
    USER_CANCEL_REFUND_TO_STORE_KEY_VALUE("用户撤销退款申请推送消息给店长","orderno","你的订单编号"),

    ;

    private String description;
    private String key;
    private String value;

    ServicePushTitleEnum(String description,String key, String value) {
        this.description = description;
        this.key =  key;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }


    public static void main(String[] args) {
        //ServicePushCodeEnum.PAY_SUCCESS_TO_BEAUTICIAN.getTitle();
    }
}
