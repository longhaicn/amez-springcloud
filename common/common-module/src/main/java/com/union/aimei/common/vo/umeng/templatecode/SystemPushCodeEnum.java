package com.union.aimei.common.vo.umeng.templatecode;

/**
 * @author houji
 * @time 2018/6/7 15:56
 * @description 消息推送-系统消息模板Code
 */
public enum SystemPushCodeEnum {
    /**
     * 后台消息推送模板
     */
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

    SystemPushCodeEnum(String name, String value) {
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
