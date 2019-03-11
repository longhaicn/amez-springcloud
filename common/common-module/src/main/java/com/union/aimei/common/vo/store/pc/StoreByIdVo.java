package com.union.aimei.common.vo.store.pc;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author houji
 * @date 2018/3/2  16:53
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺实体临时类")
public class StoreByIdVo  implements Serializable {

    @ApiModelProperty("店铺id")
    private Integer id;

    @ApiModelProperty(value = "地图坐标")
    private BaiDuMapApi.Point point;

    @ApiModelProperty("距离,M/米为单位")
    private Long distance;
}
