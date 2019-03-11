package com.union.aimei.common.vo.store.app;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 精选店铺条件
 *
 * @author liurenkai
 * @time 2018/4/27 14:46
 */
@Data
@EqualsAndHashCode
@ApiModel("精选店铺条件")
public class StoreBySelectVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("地图坐标（非数据库字段）")
    private BaiDuMapApi.Point point;

}
