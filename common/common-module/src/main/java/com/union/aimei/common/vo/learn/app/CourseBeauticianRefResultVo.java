package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 课程-美容师学习关联表(返回)
 *
 * @author caizhaoming
 * @create 2018-05-21 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("课程-美容师学习关联表(返回)")
public class CourseBeauticianRefResultVo implements Serializable {

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("培训日期")
    private String traininDate;

    @ApiModelProperty("年份")
    private String yearStr;

}
