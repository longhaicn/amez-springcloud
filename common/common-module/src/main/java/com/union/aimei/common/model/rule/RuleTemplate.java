package com.union.aimei.common.model.rule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 规则模板
 *
 * @author liurenkai
 * @time 2018/5/10 17:26
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "规则模板")
public class RuleTemplate implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("模板代码")
    private String templateCode;

    @ApiModelProperty("模板名称")
    private String templateName;

    @ApiModelProperty("软删除标记，1-正常，0-删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}