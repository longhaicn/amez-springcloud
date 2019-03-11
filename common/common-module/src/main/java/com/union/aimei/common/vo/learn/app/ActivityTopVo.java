package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author houji
 * @date 2018/5/23  17:35
 */
@Data
@EqualsAndHashCode
@ApiModel("门店或美容师报名活动置顶数据vo")
public class ActivityTopVo  implements Serializable {

    @ApiModelProperty("主键自增")
    private Integer id;

    @ApiModelProperty("置顶banner图")
    private String bannerImg;

    @ApiModelProperty("是否置顶(0--不置顶 1--置顶，默认0)")
    private Byte topStatus;

    @ApiModelProperty("活动类型(0-- 美容师 1--门店端),唯一必传参数")
    private Integer type;

    @ApiModelProperty("活动状态(0--创建未开启 1--活动报名中  2--活动进行中 3--活动结束，默认0)")
    private Integer status;


}
