package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品库存（产品）
 *
 * @author liurenkai
 * @time 2018/3/3 16:42
 */
@Data
@EqualsAndHashCode
@ApiModel("商品库存（产品）")
public class ProductByInventoryForProductPhysicalVo implements Serializable {

    @ApiModelProperty("产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("产品数量")
    private Integer physicalNumber;

}
