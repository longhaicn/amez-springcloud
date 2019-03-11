package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 订单支付项目更新条件
 *
 * @author liurenkai
 * @time 2018/6/26 17:12
 */
@Data
@EqualsAndHashCode
@ApiModel("订单支付项目更新条件")
public class ProductUpdateOrderPayVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

}
