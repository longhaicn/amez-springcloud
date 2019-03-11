package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据优惠券id获取的服务
 *
 * @author caizhaoming
 * @time 2018/04/18 16:41
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "根据优惠券id获取的服务")
public class ProductByCouponsId implements Serializable {


    @ApiModelProperty(value = "服务id")
    private String productId;

    @ApiModelProperty(value = "服务名字")
    private String productName;

    @ApiModelProperty(value = "原价")
    private Integer originalPrice;

    @ApiModelProperty(value = "销售价")
    private Integer salePrice;


}
