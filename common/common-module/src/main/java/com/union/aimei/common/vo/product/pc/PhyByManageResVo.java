package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 产品管理返回结果
 *
 * @author liurenkai
 * @time 2018/4/3 15:20
 */
@Data
@EqualsAndHashCode
@ApiModel("产品管理返回结果")
public class PhyByManageResVo implements Serializable {

    @ApiModelProperty("产品ID")
    private Integer id;

    @ApiModelProperty("产品名称")
    private String physicalName;

    @ApiModelProperty("产品编码")
    private String physicalCode;

    @ApiModelProperty("封面图")
    private String coverImg;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("库存总数")
    private Integer inventoryTotal;

    @ApiModelProperty("库存可消耗数")
    private Integer inventoryConsumable;

    @ApiModelProperty("库存订单预约数")
    private Integer inventoryOrderReservation;

    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("分类代码")
    private String categoryCode;

    @ApiModelProperty("分类名称")
    private String categoryName;

}
