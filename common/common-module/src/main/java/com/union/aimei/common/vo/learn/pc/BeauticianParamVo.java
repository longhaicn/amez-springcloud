package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 课程-美容师-关联vo
 *
 * @author caizhaoming
 * @create 2018-05-17 10:10
 **/
@Data
@EqualsAndHashCode
@ApiModel("课程-美容师-关联vo")
public class BeauticianParamVo implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("模糊查询学员名字")
    private String searchBeauticianName;

    @ApiModelProperty("模糊查询手机号")
    private String searchMobilePhone;


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

    @ApiModelProperty("评测时间")
    private Date evaluateTime;

    @ApiModelProperty("学习通过状态（0-未通过、1-已通过、2-初始化状态）")
    private Byte learningStatus;

    @ApiModelProperty("签到状态（0-未签到、1-已签到）")
    private Byte signStatus;

    @ApiModelProperty("评测分数")
    private Integer evaluateScore;

    @ApiModelProperty("评测答案（中间用小写逗号分隔开）")
    private String evaluateAnswer;

    @ApiModelProperty("是否为超出的人数 0-否 1-是")
    private Boolean isTrainingOut;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("是否做了调度操作 0-否 1-是")
    private Byte isScheduling;

    @ApiModelProperty("支付交易记录refid")
    private Integer tradeRefId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("id集合")
    private List<Integer> idList;


    private static final long serialVersionUID = 1L;

}
