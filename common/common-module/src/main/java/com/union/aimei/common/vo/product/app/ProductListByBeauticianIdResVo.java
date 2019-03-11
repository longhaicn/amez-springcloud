package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据美容师ID查询项目列表结果
 *
 * @author liurenkai
 * @time 2018/5/25 15:13
 */
@Data
@EqualsAndHashCode
@ApiModel("根据美容师ID查询项目列表结果")
public class ProductListByBeauticianIdResVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

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

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

}
