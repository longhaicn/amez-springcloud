package com.union.aimei.common.model.order;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实物订单产品信息表
 *
 * @author gaowei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value="实物订单产品信息表")
public class OrderGoodsInfo {

    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("实物订单ID")
    private Integer orderGoodsBaseId;

    @ApiModelProperty("实物产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("产品名称")
    private String physicalName;

    @ApiModelProperty("封面图")
    private String coverImg;

    @ApiModelProperty("产品图")
    private String physicalImg;

    @ApiModelProperty("数量")
    private Integer nums;

    @ApiModelProperty("单价")
    private Integer salePrice;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    private static final long serialVersionUID = 1L;
}
