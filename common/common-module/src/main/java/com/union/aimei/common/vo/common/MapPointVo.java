package com.union.aimei.common.vo.common;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 地图坐标条件
 *
 * @author liurenkai
 * @time 2018/5/28 14:59
 */
@Data
@EqualsAndHashCode
@ApiModel("地图坐标条件")
public class MapPointVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("地图坐标")
    private BaiDuMapApi.Point point;

}
