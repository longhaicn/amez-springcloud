package com.union.aimei.common.vo.store.app;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据项目ID查询最近时间，星级最高的美容师条件
 *
 * @author liurenkai
 * @time 2018/5/29 11:02
 */
@Data
@EqualsAndHashCode
@ApiModel("根据项目ID查询最近时间，星级最高的美容师条件")
public class BeauticianNearestByProductIdVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("服务所需耗时，分钟为单位")
    private Integer serverNeedTime;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("地图坐标")
    private BaiDuMapApi.Point point;

}
