package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 试卷答题入参vo
 *
 * @author caizhaoming
 * @create 2018-05-18 15:17
 **/
@Data
@EqualsAndHashCode
@ApiModel("试卷答题入参vo")
public class CourseEvaluateParamVo implements Serializable {

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

    @ApiModelProperty("id集合")
    private Set<Integer> idSet;

    /**
     * 是否删除 true-否
     */
    public static final Boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final Boolean IS_ENABLED_FALSE = false;


}
