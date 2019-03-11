package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 批量更新课程-美容师-关联数据
 *
 * @author caizhaoming
 * @create 2018-05-17 10:38
 **/
@Data
@EqualsAndHashCode
@ApiModel("批量更新课程-美容师-关联数据")
public class UpdateBeauticianVo implements Serializable {


    @ApiModelProperty("关联表id")
    private List<Integer> beauticianIdList;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("操作类型 0-未通过、1-已通过、2-未签到、3-已签到、4-删除")
    private Integer type;

    @ApiModelProperty("学习通过状态（0-未通过、1-已通过、2-初始化状态）")
    private Byte learningStatus;

    @ApiModelProperty("签到状态（0-未签到、1-已签到）")
    private Byte signStatus;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("美容师培训通过的结束时间")
    private Date beautiTrainingEnd;

    @ApiModelProperty("是否做了保存美容师项目开通权限的操作(针对已学习完) 0-否 1-是")
    private Byte isScheduling;


    /**
     * 操作类型 0-未通过
     */
    public static final int TYPE_LEARNING_NO = 0;
    /**
     * 操作类型 1-已通过
     */
    public static final int TYPE_LEARNING_YES = 1;
    /**
     * 操作类型 2-未签到
     */
    public static final int TYPE_LEARNING_SIGN_NO = 2;
    /**
     * 操作类型 3-已签到
     */
    public static final int TYPE_LEARNING_SIGN_YES = 3;
    /**
     * 操作类型 4-删除
     */
    public static final int TYPE_LEARNING_IS_ENABLE = 4;


}
