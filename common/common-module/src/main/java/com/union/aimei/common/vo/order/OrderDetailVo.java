package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe 订单详情VO
 * @time 2018/1/30,19:22
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "订单详情VO")
public class OrderDetailVo {

    @ApiModelProperty(value = "订单基础信息")
    private OrderBaseVo orderBaseVo;
    @ApiModelProperty(value = "购买会员信息")
    private OrderBuyerVo orderBuyerVo;
    @ApiModelProperty(value = "美容院信息")
    private OrderStoreVo orderStoreVo;
    @ApiModelProperty(value = "订单商品信息")
    private OrderProductVo orderProductVo;
}
