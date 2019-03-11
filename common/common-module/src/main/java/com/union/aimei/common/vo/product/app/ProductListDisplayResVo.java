package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目列表展示结果
 *
 * @author liurenkai
 * @time 2018/6/12 15:13
 */
@Data
@EqualsAndHashCode
@ApiModel("项目列表展示结果")
public class ProductListDisplayResVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("项目类型，1-门店自营，2-品牌，3-平台自营")
    private Integer productType;

    @ApiModelProperty("项目封面图")
    private String coverImg;

    @ApiModelProperty("项目名称")
    private String serverName;

    @ApiModelProperty("原价")
    private Integer originalPrice;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("上门费")
    private Integer homeFee;

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

}
