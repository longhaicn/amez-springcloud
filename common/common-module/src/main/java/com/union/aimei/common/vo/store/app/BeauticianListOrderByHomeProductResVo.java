package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询上门服务接单中的美容师列表结果
 *
 * @author liurenkai
 * @time 2018/6/12 18:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("查询上门服务接单中的美容师列表结果")
public class BeauticianListOrderByHomeProductResVo extends BeauticianListDisplayResVo {

    @ApiModelProperty("距离，M/米为单位")
    private Long distance;

    @ApiModelProperty("开始营业时间，HH:mm")
    private String startBusinessHour;

    @ApiModelProperty("结束营业时间，HH:mm")
    private String endBusinessHour;

    @ApiModelProperty("服务半径")
    private Integer serviceRadius;

    @ApiModelProperty("挂靠门店ID")
    private Integer affiliatedStoreId;

}
