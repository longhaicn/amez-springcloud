package com.union.aimei.common.vo.umeng;

import com.google.gson.JsonObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author houji
 * @date 2018/6/11  12:01
 */
@Data
@EqualsAndHashCode
@ApiModel("推送参数")
public class TemplateParamsVo {

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
    private JsonObject customs;

    /**
     * 当推送消息为服务消息时
     */
    private static final int ORDER_TYPE =1;
    /**
     * 当推送项目消息(PROJECT_001,PROJECT_0012,PROJECT_003,PROJECT_004,PROJECT_005,PROJECT_006)时,邦女郎-门店项目操作
     */
    public final static int PRODUCTSTOREREFID_TYPE  = 2;
    /**
     * 当推送项目消息code为PROJECT_007时//课程
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
     * 推送系统消息，门店-美容师挂靠处理
     */
    public final static int STORE_BEAUTICIAN_REF = 6;
    /**
     * 推送系统消息，课程
     */
    public final static int ACTIVITY_TYPE  = 7;


}
