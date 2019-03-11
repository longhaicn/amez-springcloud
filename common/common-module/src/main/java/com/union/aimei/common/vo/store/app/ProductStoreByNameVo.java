package com.union.aimei.common.vo.store.app;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品与店铺（名称）
 *
 * @author liurenkai
 * @time 2018/1/10 14:58
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "商品与店铺（名称）")
public class ProductStoreByNameVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "地图坐标")
    private BaiDuMapApi.Point point;
}
