package com.union.aimei.common.model.learn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "课程-美容师-关联")
public class CourseBeauticianRef implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("支付交易记录refid")
    private Integer tradeRefId;

    @ApiModelProperty("会员id")
    private Integer memberId;

    @ApiModelProperty("学员名字")
    private String beauticianName;

    @ApiModelProperty("手机号")
    private String mobilePhone;

    @ApiModelProperty("性别，0-男、1-女")
    private Boolean gender;

    @ApiModelProperty("学籍号")
    private String schoolRoll;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("美容师培训通过的结束时间")
    private Date beautiTrainingEnd;

    @ApiModelProperty("学习通过状态（0-未通过、1-已通过、2-初始化状态）")
    private Byte learningStatus;

    @ApiModelProperty("签到状态（0-未签到、1-已签到）")
    private Byte signStatus;

    @ApiModelProperty("评测分数")
    private Integer evaluateScore;

    @ApiModelProperty("评测时间")
    private Date evaluateTime;

    @ApiModelProperty("评测答案（中间用小写逗号分隔开）")
    private String evaluateAnswer;

    @ApiModelProperty("是否为超出的人数 0-否 1-是")
    private Boolean isTrainingOut;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("是否做了保存美容师项目开通权限的操作(针对已学习完) 0-否 1-是")
    private Byte isScheduling;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;


    /**
     * 是否做了保存美容师项目开通权限的操作(针对已学习完) 0-否
     */
    public static final byte IS_SCHEDULING_NO = 0;
    /**
     * 是否做了保存美容师项目开通权限的操作(针对已学习完) 1-是
     */
    public static final byte IS_SCHEDULING_YES = 1;

    /**
     * 学习通过状态 0-未通过
     */
    public static final byte LEARNING_STATUS_NO = 0;
    /**
     * 学习通过状态 1-已通过
     */
    public static final byte LEARNING_STATUS_YES = 1;
    /**
     * 签到状态 0-未签到
     */
    public static final byte SIGN_STATUS_NO = 0;
    /**
     * 签到状态 1-已签到
     */
    public static final byte SIGN_STATUS_YES = 1;

    /**
     * 是否删除 true-否
     */
    public static final Boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final Boolean IS_ENABLED_FALSE = false;


    /**
     * 是否为超出的人数 1-是
     */
    public static final Boolean IS_TRAINING_OUT_TURE = true;
    /**
     * 是否为超出的人数 0-否
     */
    public static final Boolean IS_TRAINING_OUT_FALSE = false;

    private static final long serialVersionUID = 1L;
}