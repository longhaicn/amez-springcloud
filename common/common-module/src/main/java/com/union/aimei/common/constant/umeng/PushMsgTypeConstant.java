package com.union.aimei.common.constant.umeng;

/**
 * @author GaoWei
 * @time 2018/6/6 14:35
 * @description 短信码常量枚举类
 */
public enum PushMsgTypeConstant {

    /**
     * 推送消息类型枚举
     */
    SERVICE_ORDER_TYPE("推送服务订单消息的type",1),
    PROJECT_APPLY_TYPE("美容师-门店挂靠申请操作",2),
    COURSE_TYPE("推送课程消息type",3),
    MAKE_MONEY_BEAUTICIAN_TYPE("后台给美容师打款type",4),
    MAKE_MONEY_STORE_TYPE("后台给门店打款type",5),
    STORE_BEAUTICIAN_APPLY_TYPE("推送门店-美容师挂靠(邀请)消息type",6),
    ACTIVITY_TYPE("推送课程消息的type",7)
    ;


    PushMsgTypeConstant(String pushDescript, int type) {
        this.pushDescript = pushDescript;
        this.type = type;
    }

    private String pushDescript;
    private int type;

    public String getPushDescript() {
        return pushDescript;
    }

    public void setPushDescript(String pushDescript) {
        this.pushDescript = pushDescript;
    }

    public static void main(String[] args) {

    }
}
