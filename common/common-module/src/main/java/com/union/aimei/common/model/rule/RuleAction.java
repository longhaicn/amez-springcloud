package com.union.aimei.common.model.rule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 规则行为
 *
 * @author liurenkai
 * @time 2018/5/10 17:25
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "规则行为")
public class RuleAction implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("规则项ID")
    private Integer itemId;

    @ApiModelProperty("行为代码")
    private String actionCode;

    @ApiModelProperty("行为名称")
    private String actionName;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}