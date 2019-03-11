package com.union.aimei.common.model.product;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品收藏入参
 *
 * @author caizhaoming
 * @time 2018/4/20 10:04
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "商品收藏入参")
public class ProductCollectionParam implements Serializable {

    @ApiModelProperty("会员id")
    private Integer memberId;

    @ApiModelProperty("商品名字筛选")
    private String searchStr;

    @ApiModelProperty(value = "地图坐标")
    private BaiDuMapApi.Point point;

}