package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 课程类返回vo
 *
 * @author caizhaoming
 * @create 2018-05-14 17:24
 **/
@Data
@EqualsAndHashCode
@ApiModel("课程类返回vo")
public class CourseBeauticianRefResultVo implements Serializable {

    @ApiModelProperty("课程名字")
    private String courseName;

    @ApiModelProperty("培训开始时间")
    private String trainingBegin;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("美容师手机号")
    private String mobilePhone;

    @ApiModelProperty("会员id")
    private Integer memberId;

    private static final long serialVersionUID = 1L;

}
