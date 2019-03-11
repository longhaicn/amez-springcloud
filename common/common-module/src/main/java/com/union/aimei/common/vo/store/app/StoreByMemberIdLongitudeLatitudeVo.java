package com.union.aimei.common.vo.store.app;

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
public class StoreByMemberIdLongitudeLatitudeVo implements Serializable {

    @ApiModelProperty("用户id")
    private Integer memberId;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty(value = "地图坐标，如：{ 'x': '114.119675', 'y': '22.544228' } ")

    private BaiDuMapApi.Point point;

    @ApiModelProperty("门店模糊查询字段")
    private String searchStr;

}
