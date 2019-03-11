package com.union.aimei.common.model.rule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 规则等级
 *
 * @author liurenkai
 * @time 2018/5/10 17:26
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "规则等级")
public class RuleLevel implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("规则项ID")
    private Integer itemId;

    @ApiModelProperty("等级代码")
    private String levelCode;

    @ApiModelProperty("等级名称")
    private String levelName;

    @ApiModelProperty("等级LOGO")
    private String levelLogo;

    @ApiModelProperty("开始等级值")
    private Integer startLevelValue;

    @ApiModelProperty("结束等级值")
    private Integer endLevelValue;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}