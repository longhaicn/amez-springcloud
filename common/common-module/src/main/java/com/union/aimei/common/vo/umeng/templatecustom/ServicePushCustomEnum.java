package com.union.aimei.common.vo.umeng.templatecustom;


/**
 * @author houji
 * @time 2018/6/7 15:56
 * @description 消息推送-服务消息内容
 */
public enum ServicePushCustomEnum {

    /**
     * 服务消息推送模板
     */
    PAY_SUCCESS_TO_BEAUTICIAN("用户订单付款成功推送消息给美容师","type", 1,"id",1),
    PAY_SUCCESS_TO_STORE("用户订单付款成功推送消息给店长","type",1,"id",1),
    SERVICE_BEFORE_TO_USER("服务开始前30分钟推送消息给用户","type",1,"id",1),
    SERVICE_BEFORE_TO_BEAUTICIAN("服务开始前30分钟推送消息给美容师","type",1,"id",1),
    SERVICE_BEFORE_TO_STORE("服务开始前30分钟推送消息给美容师","type",1,"id",1),
    SERVICE_EVALUATION_TO_USER("服务完成推送消息给用户订单评价提醒","type",1,"id",1),
    SERVICE_EVALUATION_TO_BEAUTICIAN("用户主动评价后推送消息给美容师进行查看评价","type",1,"id",1),
    SERVICE_EVALUATION_TO_STORE("用户主动评价后推送消息给店长查看评价(门店自营项目)","type",1,"id",1),
    USER_REFUND_TO_BEAUTICIAN("用户发起退款推送消息给美容师进行查看","type",1,"id",1),
    USER_REFUND_TO_STORE("用户发起退款推送消息给店长进行查看(门店自营项目)","type",1,"id",1),
    APPROVAL_REFUND_TO_USER("门店/邦女郎 同意退款推送消息给用户","type",1,"id",1),
    REFUSES_REFUND_TO_USER("门店/邦女郎 拒绝退款推送消息给用户","type",1,"id",1),
    USER_CANCEL_REFUND_TO_BEAUTICIAN("用户撤销退款申请推送消息给美容师","type",1,"id",1),
    USER_CANCEL_REFUND_TO_STORE("用户撤销退款申请推送消息给店长","type",1,"id",1),

    ;

    /**
     * 描述
     */
    private String description;
    /**
     * 消息类型type类型key-value(不可改变)
     */
    private String typeKey;
    private int typeValue;
    /**
     * 订单的orderId的key-value
     */
    private String orderIdKey;
    private int orderIdValue;

    ServicePushCustomEnum(String description,String typeKey,int typeValue,String orderIdKey,int orderIdValue) {
        this.description = description;
        this.typeKey = typeKey;
        this.typeValue = typeValue;
        this.orderIdKey = orderIdKey;
        this.orderIdValue = orderIdValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        //ServicePushCodeEnum.PAY_SUCCESS_TO_BEAUTICIAN.getTitle();
    }
}
