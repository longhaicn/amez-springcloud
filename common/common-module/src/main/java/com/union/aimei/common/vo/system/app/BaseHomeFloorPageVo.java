package com.union.aimei.common.vo.system.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 保存装修模版的楼层数据vo
 *
 * @author caizhaoming
 * @create 2018-05-23 17:24
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "保存装修模版的楼层数据vo")
public class BaseHomeFloorPageVo implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("区域id")
    private Integer areaId;

    @ApiModelProperty("h5跳转页面的唯一标识")
    private String jumpCode;

    @ApiModelProperty("首页楼层图片")
    private String indexFloorImg;

    @ApiModelProperty("活动列表图片")
    private String listFloorImg;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("类型 0-楼层 1-活动")
    private Integer floorType;

    @ApiModelProperty("是否展示 0-否1-是")
    private Integer isShow;

    @ApiModelProperty("楼层列表数据vo")
    private List<BaseHomeFloorListVo> baseHomeFloorListVoList;

}
