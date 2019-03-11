package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 自营商品结果（店铺优惠券）
 *
 * @author liurenkai
 * @time 2018/1/11 16:01
 */
@Data
@EqualsAndHashCode
@ApiModel("自营商品结果（店铺优惠券）")
public class ProductByStoreCouponsForSelfResultVo implements Serializable {

    @ApiModelProperty("商品id")
    private Integer id;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("商品分类名称")
    private String categoryName;

    @ApiModelProperty("销售价")
    private Integer salePrice;

}
