package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品库存
 *
 * @author liurenkai
 * @time 2018/3/15 17:32
 */
@Data
@EqualsAndHashCode
@ApiModel("商品库存")
public class ProductByInventoryVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("是否美容师库存标记，true-美容师，false-店铺")
    private Boolean isBeauticianInventory = true;

}
