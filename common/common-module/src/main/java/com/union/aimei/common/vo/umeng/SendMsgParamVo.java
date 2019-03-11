package com.union.aimei.common.vo.umeng;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @author houji
 * @date 2018/6/1  14:02
 */
@Data
@EqualsAndHashCode
@ApiModel(value="推送消息所需参数")
public class SendMsgParamVo {

    @ApiModelProperty("推送消息模板Code(必填)")
    private String templateCode;

    @ApiModelProperty("推送会员memberId,必填")
    private Integer memberId;

    @ApiModelProperty("订单编号(当推送Code为SERVICE_013,SERVICE_014必填)")
    private String orderNo;

    @ApiModelProperty("美容师姓名(当推送Code为" +
            "PROJECT_001,PROJECT_001，" +
            "PROJECT_003，SYSTEM_004，" +
            "SYSTEM_005，SYSTEM_006，" +
            "SYSTEM_007必填)")
    private String beauticianName;

    @ApiModelProperty("课程名字,(推送的Code为SYSTEM_012时，必填)")
    private String courseName;

    @ApiModelProperty("课程开始时间,(推送的Code为SYSTEM_012时，必填)")
    private String courseTime;

    @ApiModelProperty("活动名字,当推送code为(SYSTEM_013,SYSTEM_014)必填")
    private String activityName;

    @ApiModelProperty("活动开始时间yyyy-MM-dd hh:mm:ss,当推送code为(SYSTEM_013,SYSTEM_014)必填")
    private String activityTime;

    /**
     * 一：推送服务消息
     *      1.推送内容参数统一格式{type:ORDER_TYPE,id:你的订单id}
     *
     * 二：推送项目消息
     *      1.当推送的项目消息Code值为(PROJECT_001,PROJECT_0012,PROJECT_003,PROJECT_004,PROJECT_005,PROJECT_006)时，
     *       推送的内容参数格式{type:PRODUCTSTOREREFID_TYPE,id:你的邦女郎-门店项目操作id}
     *     2.推送项目消息的Code值为(PROJECT_007),
     *       推送的内容参数格式{"type":COURSE_TYPE,"id":你的课程id}
     *
     * 三：推送系统消息
     *      1.推送Code为(SYSTEM_001),推送内容格式:{"type",MAKE_MONEY_BEAUTICIAN_TYPE,"id":美容师的id}
     *      2.推送Code为(SYSTEM_002),推送内容格式：{"type",MAKE_MONEY_STORE_TYPE,"id":你的门店id,"date":"值（201805,201806）"}
     *      3.推送Code为(SYSTEM_003至SYSTEM_011,推送内容格式：{"type":STORE_BEAUTICIAN_REF，"id":门店美容师的RefId})
     *      4.推送Code为(SYSTEM_012),推送内容格式：{"type",COURSE_TYPE,"id":课程id}
     *      5.推送Code为(SYSTEM_013,SYSTEM_014),推送内容格式：{"type",ACTIVITY_TYPE,"id":你的活动id}
     */
    @ApiModelProperty("推送内容参数(必填)")
    private Map<String,Object> customs;

    @ApiModelProperty("跳转类型(系统消息招募挂靠跳转参数)")
    private Integer target;

    @ApiModelProperty("参数(系统消息招募挂靠内容参数)")
    private Map<String,Object> param;

    /**
     * 当推送消息为服务消息时
     */
    public static final int ORDER_TYPE =1;
    /**
     * 当推送项目消息(PROJECT_001,PROJECT_0012,PROJECT_003,PROJECT_004,PROJECT_005,PROJECT_006)时,邦女郎-门店项目操作
     */
    public final static int PRODUCTSTOREREFID_TYPE  = 2;

    /**
     * 推送系统消息，门店-美容师挂靠处理
     */
    public final static int STORE_BEAUTICIAN_REF = 6;
    /**
     * 推送系统消息，课程
     */
    public final static int ACTIVITY_TYPE  = 7;


    /**
     * 邦女郎进行项目申请操作推送消息给店长
     */
    public final static int BEAUTICIAN_APPLY_PROJECT_TO_STORE = 201;
    /**
     * 邦女郎处理门店项目邀约 （同意）推送消息给店长
     */
    public final static int BEAUTICIAN_AGREE_PROJECT_TO_STORE = 202;
    /**
     * 邦女郎处理门店项目邀约 （不同意）推送消息给店长
     */
    public final static int BEAUTICIAN_NOT_AGREE_PROJECT_TO_STORE = 203;
    /**
     * 门店对邦女郎进行项目邀约推送消息给美容师
     */
    public final static int STORE_INVITES_TO_BEAUTICIAN = 204;
    /**
     * 门店处理邦女郎项目申请结果（同意）推送消息给美容师
     */
    public final static int STORE_AGREE_APPLY_TO_STORE = 205;
    /**
     * 门店处理邦女郎项目申请结果（不同意）推送消息给美容师
     */
    public final static int STORE_NOT_AGREE_APPLY_TO_STORE = 206;
    /**
     * 平台处理邦女郎的课程评测推送送消息给美容师
     */
    public final static int PLATFORM_AGREE_COURSE_TO_BEAUTICIAN = 221;


    /**
     * 邦女郎输入店铺码成功入驻门店推送消息给店长
     */
    public final static int BEAUTICIAN_ENTER_SUCCESS_TO_STORE = 103;
    /**
     * 邦女郎挂靠申请推送消息给店长
     */
    public final static int BEAUTICIAN_HAND_APPLY_TO_STORE = 104;
    /**
     * 邦女郎处理门店挂靠邀约推送消息给店长(同意)
     */
    public final static int BEAUTICIAN_AGREE_HAND_TO_STORE = 105;
    /**
     * 邦女郎处理门店挂靠邀约推送消息给店长(不同意)
     */
    public final static int BEAUTICIAN_NOT_AGREE_HAND_TO_STORE = 121;
    /**
     * 邦女郎挂靠更改申请推送消息给店长
     */
    public final static int BEAUTICIAN_CHANGE_HAND_TO_STORE = 106;
    /**
     * 门店处理邦女郎挂靠申请（同意）
     */
    public final static int STORE_AGREE_APPLY_TO_BEAUTICIAN = 115;
    /**
     * 门店处理邦女郎挂靠申请（不同意）
     */
    public final static int STORE_NOAGREE_APPLY_TO_BEAUTICIAN=116;
    /**
     * 门店邀请邦女郎挂靠推送消息给美容师
     */
    public final static int STORE_APPLY_HAND_TO_BEAUTICIAN = 108;
    /**
     * 门店解除邦女郎挂靠推送消息给美容师
     */
    public final static int STORE_RELIEVE_HAND_TO_BEAUTICIAN = 119;
    /**
     * 门店解除邦女郎入驻推送消息给美容师
     */
    public final static int STORE_RELIEVE_ENTER_TO_BEAUTICIAN = 120;
    /**
     * 门店处理邦女郎挂靠更改申请（同意）推送消息给美容师
     */
    public final static int STORE_AGREE_CHANGE_HAND_TO_BEAUTICIAN = 109;
    /**
     * 门店处理邦女郎挂靠更改申请（不同意）推送消息给美容师
     */
    public final static int STORE_NOTAGREE_CHANGE_HAND_TO_BEAUTICIAN = 110;
    /**
     * 平台处理邦女郎挂靠(申请)解除（同意）
     */
    public final static int PLATFORM_AGREE_REMOVE_TO_BEAUTICIAN = 117;
    /**
     * 平台处理邦女郎挂靠(申请)解除（不同意）
     */
    public final static int PLATFORM_NOAGREE_REMOVE_TO_BEAUTICIAN = 118;
    /**
     * 当推送系统消息课程评测
     */
    public final static int COURSE_TYPE  = 3;
    /**
     * 推送系统消息,后台给美容师提现申请打款
     */
    public final static int MAKE_MONEY_BEAUTICIAN_TYPE = 4;
    /**
     * 推送系统消息,后台给门店提现申请打款
     */
    public final static int MAKE_MONEY_STORE_TYPE = 5;
    /**
     * 培训课程开始前一天推送消息给美容师
     */
    public final static int COURSE_ONE_DAY_TYPE = 112;
    /**
     * 活动开始前一天推送消息给美容师
     */
    public final static int ACTIVITY_BEAUTICIAN_ONE_DAY_TYPE = 113;
    /**
     * 活动开始前一天推送消息给门店
     */
    public final static int ACTIVITY_STORE_ONE_DAY_TYPE = 114;

}
