package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品收藏vo
 *
 * @author caizhaoming
 * @time 2018/4/20 10:04
 */
@Data
@EqualsAndHashCode
@ApiModel("商品收藏vo")
public class ProductCollectionResultVo implements Serializable {

    @ApiModelProperty("商品id")
    private Integer id;

    @ApiModelProperty("商品图片")
    private String coverImg;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("商品原价")
    private Integer originalPrice;

    @ApiModelProperty("商品批发价")
    private Integer wholesalePrice;

    @ApiModelProperty("商品零售价")
    private Integer retailPrice;

    @ApiModelProperty("商品销售价")
    private Integer salePrice;

    @ApiModelProperty("商品上架状态，0-下架，1-上架")
    private Integer saleStatus;

    @ApiModelProperty("审核状态，0-待审核，1-已审核，2-不通过")
    private Integer auditStatus;

    @ApiModelProperty("平台标记，1-是，0-否")
    private Boolean isPlatform;

    @ApiModelProperty(value = "距离，单位为 米")
    private String distance;


}
