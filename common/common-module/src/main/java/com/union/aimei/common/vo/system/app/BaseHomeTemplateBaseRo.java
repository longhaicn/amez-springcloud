package com.union.aimei.common.vo.system.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 首页模板基础数据ro
 *
 * @author caizhaoming
 * @time 2018/08/23 10:45
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "首页模板基础数据ro")
public class BaseHomeTemplateBaseRo implements Serializable {

    @ApiModelProperty("首页模板ID")
    private Integer id;

    @ApiModelProperty("模板内容")
    private String templateContent;

    private static final long serialVersionUID = 1L;
}