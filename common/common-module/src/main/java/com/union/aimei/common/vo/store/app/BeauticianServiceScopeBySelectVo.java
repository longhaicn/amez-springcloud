package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 选择美容师服务范围条件
 *
 * @author liurenkai
 * @time 2018/5/19 17:39
 */
@Data
@EqualsAndHashCode
@ApiModel("选择美容师服务范围条件")
public class BeauticianServiceScopeBySelectVo implements Serializable {

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("市ID")
    private Integer cityId;

    @ApiModelProperty("经度")
    private Integer longitude;

    @ApiModelProperty("纬度")
    private Integer latitude;

    @ApiModelProperty("半径")
    private Integer radius;

}