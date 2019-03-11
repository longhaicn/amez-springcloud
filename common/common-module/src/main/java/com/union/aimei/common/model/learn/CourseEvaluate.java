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
@ApiModel(value = "课程试题")
public class CourseEvaluate implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("题目")
    private String questionsTitle;

    @ApiModelProperty("选项1")
    private String questionsOne;

    @ApiModelProperty("选项2")
    private String questionsTwo;

    @ApiModelProperty("选项3")
    private String questionsThree;

    @ApiModelProperty("选项4")
    private String questionsFour;

    @ApiModelProperty("答案(0-A，1-B，2-C，3-D)")
    private Byte answer;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("索引")
    private Integer index;

    /**
     * 是否删除 true-否
     */
    public static final Boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final Boolean IS_ENABLED_FALSE = false;

    private static final long serialVersionUID = 1L;
}