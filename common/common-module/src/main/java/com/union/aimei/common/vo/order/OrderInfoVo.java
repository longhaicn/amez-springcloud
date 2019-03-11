package com.union.aimei.common.vo.order;

import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.model.order.OrderProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单信息vo
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class OrderInfoVo {

    @ApiModelProperty(value = "订单基础")
    private OrderBase orderBase;
    @ApiModelProperty(value = "订单服务信息")
    private OrderProduct orderProduct;
    @ApiModelProperty(value = "订单美容师信息")
    private OrderBeautician orderBeautician;
}
