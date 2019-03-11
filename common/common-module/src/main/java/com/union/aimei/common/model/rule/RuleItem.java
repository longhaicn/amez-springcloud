package com.union.aimei.common.model.rule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 规则项
 *
 * @author liurenkai
 * @time 2018/5/10 17:26
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "规则项")
public class RuleItem implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("模板ID")
    private Integer templateId;

    @ApiModelProperty("项代码")
    private String itemCode;

    @ApiModelProperty("项名称")
    private String itemName;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}