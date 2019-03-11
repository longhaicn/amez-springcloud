package com.union.aimei.common.vo.system.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据名称查询ID条件（省，市，县）
 *
 * @author liurenkai
 * @time 2018/6/8 9:51
 */
@Data
@EqualsAndHashCode
@ApiModel("根据名称查询ID条件（省，市，县）")
public class BaseRegionIdByNameVo implements Serializable {

    @ApiModelProperty("省名称")
    private String provinceName;

    @ApiModelProperty("市名称")
    private String cityName;

    @ApiModelProperty("区名称")
    private String areaName;

}
