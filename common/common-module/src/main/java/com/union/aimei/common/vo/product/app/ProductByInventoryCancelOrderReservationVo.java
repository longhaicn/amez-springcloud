package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 商品库存取消订单预约
 *
 * @author liurenkai
 * @time 2018/3/3 12:26
 */
@Data
@EqualsAndHashCode
@ApiModel("商品库存取消订单预约")
public class ProductByInventoryCancelOrderReservationVo implements Serializable {

    @ApiModelProperty("产品库存")
    private ProductByInventoryVo inventory;

    @ApiModelProperty("产品集合")
    private List<ProductByInventoryForProductPhysicalVo> productPhysicalList;

}
