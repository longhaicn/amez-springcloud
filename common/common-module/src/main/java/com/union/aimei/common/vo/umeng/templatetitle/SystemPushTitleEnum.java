package com.union.aimei.common.vo.umeng.templatetitle;

/**
 * @author houji
 * @time 2018/6/7 15:56
 * @description 消息推送-项目消息消息title的key-value
 */
public enum SystemPushTitleEnum {

    /**
     * 系统消息
     */
    MAKE_MONEY_TO_BEAUTICIAN_KEY_VALUE("后台给美容师提现申请打款推送消息给美容师",null,null),
    MAKE_MONEY_TO_STORE_KEY_VALUE("后台给店铺月账单打款推送消息给店长",null,null),
    BEAUTICIAN_ENTER_SUCCESS_TO_STORE_KEY_VALUE("邦女郎输入店铺码成功入驻门店推送消息给店长","beauticianname","美容师名字"),
    BEAUTICIAN_HAND_APPLY_TO_STORE_KEY_VALUE("邦女郎挂靠申请推送消息给店长","beauticianname","美容师名字"),
    BEAUTICIAN_AGREE_HAND_TO_STORE_KEY_VALUE("邦女郎处理门店挂靠邀约推送消息给店长","beauticianname","美容师名字"),
    BEAUTICIAN_CHANGE_HAND_TO_STORE_KEY_VALUE("邦女郎挂靠更改申请推送消息给店长","beauticianname","美容师名字"),
    STORE_ACTION_HAND_TO_BEAUTICIAN_KEY_VALUE("门店处理邦女郎挂靠申请推送消息给美容师","beauticianname","美容师名字"),
    STORE_APPLY_HAND_TO_BEAUTICIAN_KEY_VALUE("门店邀请邦女郎挂靠推送消息给美容师",null,null),
    STORE_AGREE_CHANGE_HAND_TO_BEAUTICIAN_KEY_VALUE("门店处理邦女郎挂靠更改申请（同意）推送消息给美容师",null,null),
    STORE_NOT_AGREE_CHANGE_HAND_TO_BEAUTICIAN_KEY_VALUE("门店处理邦女郎挂靠更改申请（不同意）推送消息给美容师",null,null),
    PLATFORM_AGREE_CHANGE_HAND_TO_BEAUTICIAN_KEY_VALUE("平台处理邦女郎挂靠更改申请推送消息给美容师",null,null),
    COURSE_BEFORE_TO_BEAUTICIAN_ONE_KEY_VALUE("培训课程开始前一天推送消息给美容师(第一个key-value)","coursename","课程名字"),
    COURSE_BEFORE_TO_BEAUTICIAN_TWO_KEY_VALUE("培训课程开始前一天推送消息给美容师(第二个key-value)","coursetime","课程开始时间"),
    ACTIVITY_BEFORE_TO_BEAUTICIAN_ONE_KEY_VALUE("活动开始前一天推送消息给美容师(第一个key-value)","activityname","活动名字"),
    ACTIVITY_BEFORE_TO_BEAUTICIAN_TWO_KEY_VALUE("活动开始前一天推送消息给美容师(第二个key-value)","activitytime","活动开始时间"),
    ACTIVITY_BEFORE_TO_STORE_ONE_KEY_VALUE("活动开始前一天推送消息给店长(第一个key-value)","activityname","活动名字"),
    ACTIVITY_BEFORE_TO_STORE_TWO_KEY_VALUE("活动开始前一天推送消息给店长(第二个key-value)","activitytime","活动开始时间"),
    ;



    private String description;
    private String key;
    private String value;

    SystemPushTitleEnum(String description, String key, String value) {
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
