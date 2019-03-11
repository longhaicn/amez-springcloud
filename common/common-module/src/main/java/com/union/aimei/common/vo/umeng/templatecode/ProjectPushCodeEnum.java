package com.union.aimei.common.vo.umeng.templatecode;

/**
 * @author houji
 * @time 2018/6/7 15:56
 * @description 消息推送-项目消息模板Code
 */
public enum ProjectPushCodeEnum {

    /**
     * 邦女郎进行项目申请操作推送消息给店长
     */
    BEAUTICIAN_APPLY_PROJECT_TO_STORE("邦女郎进行项目申请操作推送消息给店长", "PROJECT_001"),
    /**
     * 邦女郎处理门店项目邀约 （同意）推送消息给店长
     */
    BEAUTICIAN_AGREE_PROJECT_TO_STORE("邦女郎处理门店项目邀约 （同意）推送消息给店长", "PROJECT_002"),
    /**
     * 邦女郎处理门店项目邀约 （不同意）推送消息给店长
     */
    BEAUTICIAN_NOT_AGREE_PROJECT_TO_STORE("邦女郎处理门店项目邀约 （不同意）推送消息给店长", "PROJECT_003"),
    /**
     * 门店对邦女郎进行项目邀约推送消息给美容师
     */
    STORE_INVITES_TO_BEAUTICIAN("门店对邦女郎进行项目邀约推送消息给美容师", "PROJECT_004"),
    /**
     * 门店处理邦女郎项目申请结果（同意）推送消息给美容师
     */
    STORE_AGREE_APPLY_TO_STORE("门店处理邦女郎项目申请结果（同意）推送消息给美容师", "PROJECT_005"),
    /**
     * 门店处理邦女郎项目申请结果（不同意）推送消息给美容师
     */
    STORE_NOT_AGREE_APPLY_TO_STORE("门店处理邦女郎项目申请结果（不同意）推送消息给美容师", "PROJECT_006"),
    /**
     * 平台处理邦女郎的课程评测推送送消息给美容师(最新修改)
     */
    PLATFORM_AGREE_COURSE_TO_BEAUTICIAN("平台处理邦女郎的课程评测推送送消息给美容师", "SYSTEM_021"),;

    private String name;
    private String value;

    ProjectPushCodeEnum(String name, String value) {
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
