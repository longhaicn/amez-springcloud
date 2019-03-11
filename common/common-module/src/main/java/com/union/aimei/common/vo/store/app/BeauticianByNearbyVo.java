package com.union.aimei.common.vo.store.app;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询附近的美容师条件
 *
 * @author liurenkai
 * @time 2018/5/25 9:47
 */
@Data
@EqualsAndHashCode
@ApiModel("查询附近的美容师条件")
public class BeauticianByNearbyVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("地图坐标")
    private BaiDuMapApi.Point point;

}
