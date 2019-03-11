package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品-运费模板-关联
 *
 * @author liurenkai
 * @time 2018/3/12 18:07
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "产品-运费模板-关联")
public class PhysicalFreightTemplateRef implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("运费模板ID")
    private Integer templateId;

    @ApiModelProperty("产品ID")
    private Integer physicalId;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}