package com.union.aimei.common.vo.system.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "楼层管理表")
public class BaseHomeFloorRo implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("h5跳转页面的唯一标识")
    private String jumpCode;

    @ApiModelProperty("首页楼层图片")
    private String indexFloorImg;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("是否展示 0-否，1-是")
    private Integer isShow;

    private static final long serialVersionUID = 1L;
}