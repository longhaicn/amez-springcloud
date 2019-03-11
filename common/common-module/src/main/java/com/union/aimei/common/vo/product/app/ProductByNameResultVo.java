package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品结果(名称)
 *
 * @author liurenkai
 * @time 2018/1/9 17:17
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "商品结果(名称)")
public class ProductByNameResultVo implements Serializable {

    @ApiModelProperty("商品id")
    private Integer id;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("原价")
    private Integer originalPrice;

    @ApiModelProperty("上门费")
    private Integer homeFee;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("商品封面图")
    private String coverImg;

    @ApiModelProperty("距离")
    private Long distance;
}
