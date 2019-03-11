package com.union.aimei.common.vo.system.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 保存装修模版的基本数据ro
 *
 * @author caizhaoming
 * @create 2018-08-23 17:24
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "保存装修模版的基本数据ro")
public class BaseHomeTemplateRo implements Serializable {

    @ApiModelProperty("首页模板-轮播图、导航按钮、底部菜单")
    private Map<String, BaseHomeTemplateBaseRo> baseHomeTemplateMap;

    @ApiModelProperty("首页模板-活动集合数据")
    private List<BaseHomeFloorRo> baseHomeFloorList;

    private static final long serialVersionUID = 1L;
}
