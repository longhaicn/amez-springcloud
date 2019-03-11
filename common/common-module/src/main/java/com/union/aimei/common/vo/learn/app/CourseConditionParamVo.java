package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 查询课程学习条件vo
 *
 * @author caizhaoming
 * @create 2018-05-08 17:58
 **/
@Data
@EqualsAndHashCode
@ApiModel("查询课程学习条件vo")
public class CourseConditionParamVo implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("ID集合")
    private List<Integer> courseIdList;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("条件名字描述")
    private String conditionName;

    @ApiModelProperty("条件判断（固定值直接录入，")
    private String conditionalData;

    @ApiModelProperty("判断依据，0-并且，1-或者，2-不等，3-以上，4-以下")
    private Byte conditionalAccording;

    @ApiModelProperty("条件类型，0-星级，1-等级，2-经验，3-新人分数")
    private Byte conditionalType;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;


}
