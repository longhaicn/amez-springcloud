package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 课程学习条件判断依据
 *
 * @author caizhaoming
 * @create 2018-05-08 18:11
 **/
@Data
@EqualsAndHashCode
@ApiModel("课程学习条件判断依据")
public class CourseConditionMessage implements Serializable {


    @ApiModelProperty("是否满足报名的条件（0-满足，1-不满足）")
    private Integer isApply;

    @ApiModelProperty("不满足的信息")
    private String applyMessage;

    /**
     * 是否满足报名的条件（0-满足)
     */
    public static final Integer IS_APPLY_SUCCESS = 0;
    /**
     * 是否满足报名的条件（1-不满足)
     */
    public static final Integer IS_APPLY_NO_SUCCESS = 1;

    /**
     * 提示信息的开头 (需要)
     */
    public static final String MESSAGE_NO_BEFORE = "需要 " ;
    /**
     * 提示信息的开头 (条件)
     */
    public static final String CONDITION_BEFORE = " 条件" ;

}
