package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 试题答案
 *
 * @author caizhaoming
 * @create 2018-05-18 15:17
 **/
@Data
@EqualsAndHashCode
@ApiModel("试题答案")
public class CourseAnswerVo implements Serializable {

    @ApiModelProperty("题目id")
    private Integer id;

    @ApiModelProperty("答案(0-A，1-B，2-C，3-D)")
    private Byte answer;


}
