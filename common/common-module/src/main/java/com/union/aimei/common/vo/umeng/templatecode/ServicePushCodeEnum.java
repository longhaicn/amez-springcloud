package com.union.aimei.common.vo.umeng.templatecode;

/**
 * @author houji
 * @time 2018/6/7 15:56
 * @description 消息推送-服务消息模板整体Code
 */
public enum ServicePushCodeEnum {
    /**
     * 服务消息推送模板枚举
     */
    PAY_SUCCESS_TO_BEAUTICIAN("用户订单付款成功推送消息给美容师","SERVICE_001"),
    PAY_SUCCESS_TO_STORE("用户订单付款成功推送消息给店长","SERVICE_002"),
    SERVICE_BEFORE_TO_USER("服务开始前30分钟推送消息给用户","SERVICE_003"),
    SERVICE_BEFORE_TO_BEAUTICIAN("服务开始前30分钟推送消息给美容师","SERVICE_004"),
    SERVICE_BEFORE_TO_STORE("服务开始前30分钟推送消息给美容师","SERVICE_005"),
    SERVICE_EVALUATION_TO_USER("服务完成推送消息给用户订单评价提醒","SERVICE_006"),
    SERVICE_EVALUATION_TO_BEAUTICIAN("用户主动评价后推送消息给美容师进行查看评价","SERVICE_007"),
    SERVICE_EVALUATION_TO_STORE("用户主动评价后推送消息给店长查看评价(门店自营项目)","SERVICE_008"),
    USER_REFUND_TO_BEAUTICIAN("用户发起退款推送消息给美容师进行查看","SERVICE_009"),
    USER_REFUND_TO_STORE("用户发起退款推送消息给店长进行查看(门店自营项目)","SERVICE_010"),
    APPROVAL_REFUND_TO_USER("门店/邦女郎 同意退款推送消息给用户","SERVICE_011"),
    REFUSES_REFUND_TO_USER("门店/邦女郎 拒绝退款推送消息给用户","SERVICE_012"),
    USER_CANCEL_REFUND_TO_BEAUTICIAN("用户撤销退款申请推送消息给美容师","SERVICE_013"),
    USER_CANCEL_REFUND_TO_STORE("用户撤销退款申请推送消息给店长","SERVICE_014"),

    ;



    private String name;
    private String value;

    ServicePushCodeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }


    public static void main(String[] args) {
        //ServicePushCodeEnum.PAY_SUCCESS_TO_BEAUTICIAN.getTitle();
    }
}
