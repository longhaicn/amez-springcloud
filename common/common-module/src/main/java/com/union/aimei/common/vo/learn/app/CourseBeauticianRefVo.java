package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 美容师报名课程数据vo
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("美容师报名课程数据vo")
public class CourseBeauticianRefVo implements Serializable {


    @ApiModelProperty("学员名字")
    private String beauticianName;

    @ApiModelProperty("手机号")
    private String mobilePhone;

    @ApiModelProperty("性别，0-男、1-女")
    private Boolean gender;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("支付交易记录refid")
    private Integer tradeRefId;

    @ApiModelProperty("会员memberId")
    private Integer memberId;


    @ApiModelProperty("评测分数")
    private Integer evaluateScore;

    @ApiModelProperty("评测时间")
    private Date evaluateTime;

    @ApiModelProperty("评测答案（中间用小写逗号分隔开）")
    private String evaluateAnswer;

    @ApiModelProperty("课程名字")
    private String courseName;

}
