package com.union.aimei.common.constant.umeng;

/**
 * @author houji
 * @date 2018/8/1  16:40
 * @description umeng推送模板常量
 */
public enum PushTemplateCodeConstant {

    //项目消息模板Code
    BEAUTICIAN_APPLY_PROJECT_TO_STORE("邦女郎进行项目申请操作推送消息给店长","PROJECT_001"),
    BEAUTICIAN_AGREE_PROJECT_TO_STORE("邦女郎处理门店项目邀约 （同意）推送消息给店长","PROJECT_002"),
    BEAUTICIAN_NOT_AGREE_PROJECT_TO_STORE("邦女郎处理门店项目邀约 （不同意）推送消息给店长","PROJECT_003"),
    STORE_INVITES_TO_BEAUTICIAN("门店对邦女郎进行项目邀约推送消息给美容师","PROJECT_004"),
    STORE_AGREE_APPLY_TO_STORE("门店处理邦女郎项目申请结果（同意）推送消息给美容师","PROJECT_005"),
    STORE_NOT_AGREE_APPLY_TO_STORE("门店处理邦女郎项目申请结果（不同意）推送消息给美容师","PROJECT_006"),
    PLATFORM_AGREE_COURSE_TO_BEAUTICIAN("平台处理邦女郎的课程评测推送送消息给美容师","SYSTEM_021"),


    //服务消息模板Code
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


    //系统消息模板Code
    MAKEMONEY_TO_BEAUTICIAN("后台给美容师提现申请打款推送消息给美容师","SYSTEM_001"),
    MAKEMONEY_TO_STORE("后台给店铺月账单打款推送消息给店长","SYSTEM_002"),
    BEAUTICIAN_ENTER_SUCCESS_TO_STORE("邦女郎输入店铺码成功入驻门店推送消息给店长","SYSTEM_003"),
    BEAUTICIAN_HAND_APPLY_TO_STORE("邦女郎挂靠申请推送消息给店长","SYSTEM_004"),
    BEAUTICIAN_AGREE_HAND_TO_STORE("邦女郎处理门店挂靠邀约推送消息给店长","SYSTEM_005"),
    BEAUTICIAN_NOT_AGREE_HAND_TO_STORE("邦女郎处理门店挂靠邀约推送消息给店长","SYSTEM_021"),
    BEAUTICIAN_CHANGE_HAND_TO_STORE("邦女郎挂靠更改申请推送消息给店长","SYSTEM_006"),
    /*STORE_ACTION_HAND_TO_BEAUTICIAN("门店处理邦女郎挂靠申请推送消息给美容师","SYSTEM_007"),*/
    STORE_AGREE_APPLY_TO_BEAUTICIAN("门店处理邦女郎挂靠申请（同意）","SYSTEM_015"),
    STORE_NOAGREE_APPLY_TO_BEAUTICIAN("门店处理邦女郎挂靠申请（不同意）","SYSTEM_016"),
    STORE_APPLY_HAND_TO_BEAUTICIAN("门店邀请邦女郎挂靠推送消息给美容师","SYSTEM_008"),
    STORE_RELIEVE_HAND_TO_BEAUTICIAN("门店解除邦女郎挂靠推送消息给美容师","SYSTEM_019"),
    STORE_RELIEVE_ENTER_TO_BEAUTICIAN("门店解除邦女郎入驻推送消息给美容师","SYSTEM_020"),
    STORE_AGREE_CHANGE_HAND_TO_BEAUTICIAN("门店处理邦女郎挂靠更改申请（同意）推送消息给美容师","SYSTEM_009"),
    STORE_NOTAGREE_CHANGE_HAND_TO_BEAUTICIAN("门店处理邦女郎挂靠更改申请（不同意）推送消息给美容师","SYSTEM_010"),
    /*PLATFORM_AGREE_CHANGE_HAND_TO_BEAUTICIAN("平台处理邦女郎挂靠更改申请推送消息给美容师","SYSTEM_011"),*/
    PLATFORM_AGREE_REMOVE_TO_BEAUTICIAN("平台处理邦女郎挂靠(申请)解除（同意）","SYSTEM_017"),
    PLATFORM_NOAGREE_REMOVE_TO_BEAUTICIAN("平台处理邦女郎挂靠(申请)解除（不同意）","SYSTEM_018"),
    COURSE_BEFORE_TO_BEAUTICIAN("培训课程开始前一天推送消息给美容师","SYSTEM_012"),
    ACTIVITY_BEFORE_TO_BEAUTICIAN("活动开始前一天推送消息给美容师","SYSTEM_013"),
    ACTIVITY_BEFORE_TO_STORE("活动开始前一天推送消息给店长","SYSTEM_014"),

    ;

    private String name;
    private String value;

    PushTemplateCodeConstant(String name, String value) {
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
