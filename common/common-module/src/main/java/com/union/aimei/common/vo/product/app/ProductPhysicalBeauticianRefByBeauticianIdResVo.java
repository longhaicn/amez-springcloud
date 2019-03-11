package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 产品-美容师-关联结果（根据美容师ID）
 *
 * @author liurenkai
 * @time 2018/3/14 16:54
 */
@Data
@EqualsAndHashCode
@ApiModel("产品-美容师-关联结果（根据美容师ID）")
public class ProductPhysicalBeauticianRefByBeauticianIdResVo implements Serializable {

    @ApiModelProperty("产品ID")
    private Integer id;

    @ApiModelProperty("产品名称")
    private String physicalName;

    @ApiModelProperty("产品编码")
    private String physicalCode;

    @ApiModelProperty("封面图")
    private String coverImg;

    @ApiModelProperty("库存总数")
    private Integer inventoryTotal;

    @ApiModelProperty("库存可消耗数")
    private Integer inventoryConsumable;

    @ApiModelProperty("库存订单预约数")
    private Integer inventoryOrderReservation;

}
