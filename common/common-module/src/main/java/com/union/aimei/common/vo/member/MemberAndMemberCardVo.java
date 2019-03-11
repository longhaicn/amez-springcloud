package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author houji
 * @date 2018/3/7  15:49
 */
@Data
@EqualsAndHashCode
@ApiModel(value="会员卡和会员新增统计")
public class MemberAndMemberCardVo implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("统计的天数")
    private Integer dayCount;

    @ApiModelProperty("统计类型(0--平台 1--店铺)")
    private Integer type;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("消费类型 0:充值，1：消费")
    private Integer consType;
}
