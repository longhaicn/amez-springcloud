package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目是否上架条件
 *
 * @author liurenkai
 * @time 2018/6/26 17:57
 */
@Data
@EqualsAndHashCode
@ApiModel("项目是否上架条件")
public class ProductIsOnSaleVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

}
