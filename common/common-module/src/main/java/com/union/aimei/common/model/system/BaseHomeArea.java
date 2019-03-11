package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "首页区域表")
public class BaseHomeArea implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("省id")
    private Integer provinceId;

    @ApiModelProperty("市id")
    private Integer cityId;

    @ApiModelProperty("区id")
    private Integer areaId;

    @ApiModelProperty("省名称")
    private String provinceName;

    @ApiModelProperty("市名称")
    private String cityName;

    @ApiModelProperty("县城市")
    private String areaName;

    @ApiModelProperty("数据类型 0-基本数据 1-楼层数据")
    private Byte dataType;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 数据类型 0-基本数据
     */
    public static final byte DATA_TYPE_BASE = 0 ;
    /**
     * 数据类型 1-楼层数据
     */
    public static final byte DATA_TYPE_FLOOR = 1 ;

    /**
     * 是否删除 true-否
     */
    public static final Boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final Boolean IS_ENABLED_FALSE = false;

    private static final long serialVersionUID = 1L;
}