package com.union.aimei.common.vo.system.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 保存装修模版的楼层数据ro
 *
 * @author caizhaoming
 * @create 2018-05-23 17:24
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "保存装修模版的楼层数据ro")
public class BaseHomeFloorPageRo implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("h5跳转页面的唯一标识")
    private String jumpCode;

    @ApiModelProperty("首页楼层图片")
    private String indexFloorImg;

    @ApiModelProperty("楼层列表数据ro")
    private List<BaseHomeFloorListRo> baseHomeFloorListRoList;

}
