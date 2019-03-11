package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 品牌商品结果（店铺优惠券）
 *
 * @author liurenkai
 * @time 2018/1/11 16:01
 */
@Data
@EqualsAndHashCode
@ApiModel("品牌商品结果（店铺优惠券）")
public class ProductByStoreCouponsForBrandResultVo implements Serializable {

    @ApiModelProperty("商品id")
    private Integer id;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("销售价")
    private Integer salePrice;

}
