package com.union.aimei.common.model.rule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 规则策略
 *
 * @author liurenkai
 * @time 2018/5/10 17:26
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "规则策略")
public class RuleStrategy implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("行为ID")
    private String actionId;

    @ApiModelProperty("开始策略条件")
    private Integer startStrategyCond;

    @ApiModelProperty("结束策略条件")
    private Integer endStrategyCond;

    @ApiModelProperty("策略值")
    private String strategyValue;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}