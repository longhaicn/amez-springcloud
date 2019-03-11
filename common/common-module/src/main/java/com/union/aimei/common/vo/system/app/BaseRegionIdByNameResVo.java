package com.union.aimei.common.vo.system.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据名称查询ID结果（省，市，区）
 *
 * @author liurenkai
 * @time 2018/6/8 9:51
 */
@Data
@EqualsAndHashCode
@ApiModel("根据名称查询ID结果（省，市，区）")
public class BaseRegionIdByNameResVo implements Serializable {

    @ApiModelProperty("省ID")
    private Integer provinceId;

    @ApiModelProperty("市ID")
    private Integer cityId;

    @ApiModelProperty("区ID")
    private Integer areaId;

}
