package com.union.aimei.common.vo.store.app;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺详情
 *
 * @author liurenkai
 * @time 2018/1/25 15:49
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺详情")
public class StoreByDetailVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("地图坐标")
    private BaiDuMapApi.Point point;

}
