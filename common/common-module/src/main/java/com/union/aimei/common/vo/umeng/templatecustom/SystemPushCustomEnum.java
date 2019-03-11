package com.union.aimei.common.vo.umeng.templatecustom;

/**
 * @author houji
 * @time 2018/6/7 15:56
 * @description 消息推送-服务消息内容
 */
public enum SystemPushCustomEnum {

    /**
     * 系统消息推送模板
     */
    MAKEMONEY_TO_BEAUTICIAN("后台给美容师提现申请打款推送消息给美容师","type",1,"id",1),
    MAKEMONEY_TO_STORE("后台给店铺月账单打款推送消息给店长","type",1,"id",1),
    BEAUTICIAN_ENTER_SUCCESS_TO_STORE("邦女郎输入店铺码成功入驻门店推送消息给店长","type",1,"id",1),
    BEAUTICIAN_HAND_APPLY_TO_STORE("邦女郎挂靠申请推送消息给店长","type",1,"id",1),
    BEAUTICIAN_AGREE_HAND_TO_STORE("邦女郎处理门店挂靠邀约推送消息给店长","type",1,"id",1),
    BEAUTICIAN_CHANGE_HAND_TO_STORE("邦女郎挂靠更改申请推送消息给店长","type",1,"id",1),
    STORE_ACTION_HAND_TO_BEAUTICIAN("门店处理邦女郎挂靠申请推送消息给美容师","type",1,"id",1),
    STORE_APPLY_HAND_TO_BEAUTICIAN("门店邀请邦女郎挂靠推送消息给美容师","type",1,"id",1),
    STORE_AGREE_CHANGE_HAND_TO_BEAUTICIAN("门店处理邦女郎挂靠更改申请（同意）推送消息给美容师","type",1,"id",1),
    STORE_NOTAGREE_CHANGE_HAND_TO_BEAUTICIAN("门店处理邦女郎挂靠更改申请（不同意）推送消息给美容师","type",1,"id",1),
    PLATFORM_AGREE_CHANGE_HAND_TO_BEAUTICIAN("平台处理邦女郎挂靠更改申请推送消息给美容师","type",1,"id",1),
    COURSE_BEFORE_TO_BEAUTICIAN("培训课程开始前一天推送消息给美容师","type",1,"id",1),
    ACTIVITY_BEFORE_TO_BEAUTICIAN("活动开始前一天推送消息给美容师","type",1,"id",1),
    ACTIVITY_BEFORE_TO_STORE("活动开始前一天推送消息给店长","type",1,"id",1),
    ;


    private String description;
    private String key1;
    private String key2;
    private int value1;
    private int value2;

    SystemPushCustomEnum(String description, String key1, int value1, String key2, int value2) {
        this.description = description;
        this.key1 = key1;
        this.value1 = value1;
        this.key2 = key2;
        this.value2 = value2;
    }

    public String getKey1() {
        return key1;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public String getKey2() {
        return key2;
    }


    public static void main(String[] args) {
        //ServicePushCodeEnum.PAY_SUCCESS_TO_BEAUTICIAN.getTitle();
    }
}
