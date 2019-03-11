package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 根据项目ID查询最近时间，星级最高的美容师结果
 *
 * @author liurenkai
 * @time 2018/5/29 11:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("根据项目ID查询最近时间，星级最高的美容师结果")
public class BeauticianNearestByProductIdResVo extends BeauticianListDisplayResVo {

    @ApiModelProperty("距离，M/米为单位（非数据库字段）")
    private Long distance;

    @ApiModelProperty("服务半径")
    private Integer serviceRadius;

    @ApiModelProperty("服务日期")
    private String serviceDate;

    @ApiModelProperty("服务时间")
    private String serviceTime;

    @ApiModelProperty("挂靠门店ID")
    private Integer affiliatedStoreId;

}
