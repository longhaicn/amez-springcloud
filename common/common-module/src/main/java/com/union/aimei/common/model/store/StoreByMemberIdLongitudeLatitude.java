package com.union.aimei.common.model.store;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author caizhaoming
 * @date 2018/4/19  16:14
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "收藏店铺的实体类")
public class StoreByMemberIdLongitudeLatitude implements Serializable {

    @ApiModelProperty("用户id")
    private Integer memberId;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty(value = "地图坐标")
    private BaiDuMapApi.Point point;

    @ApiModelProperty("门店模糊查询字段")
    private String searchStr;



}
