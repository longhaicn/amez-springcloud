package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 试卷答题vo
 *
 * @author caizhaoming
 * @create 2018-05-18 15:17
 **/
@Data
@EqualsAndHashCode
@ApiModel("试卷答题vo")
public class CourseEvaluateVo implements Serializable {

    @ApiModelProperty("题目答案")
    private List<CourseAnswerVo> courseAnswerVoList;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("课程美容师管理表id")
    private Integer courseBeauticianId;


}
