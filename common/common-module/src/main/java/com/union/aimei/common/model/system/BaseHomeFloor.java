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
@ApiModel(value = "楼层管理表")
public class BaseHomeFloor implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("区域id")
    private Integer areaId;

    @ApiModelProperty("h5跳转页面的唯一标识")
    private String jumpCode;

    @ApiModelProperty("首页楼层图片")
    private String indexFloorImg;

    @ApiModelProperty("楼层标题名称")
    private String title;

    @ApiModelProperty("活动列表图片")
    private String listFloorImg;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("类型 0-楼层 1-活动")
    private Integer floorType;

    @ApiModelProperty("是否展示 0-否，1-是")
    private Integer isShow;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 类型 0-楼层
     */
    public static final Integer FLOOR_TYPE_FLOOR = 0;
    /**
     * 类型 1-活动
     */
    public static final Integer FLOOR_TYPE_ACTIVE = 1;

    /**
     * 是否删除 true-否
     */
    public static final Boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final boolean IS_ENABLED_FALSE = false;

    private static final long serialVersionUID = 1L;
}