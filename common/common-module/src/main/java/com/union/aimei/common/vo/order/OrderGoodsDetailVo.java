package com.union.aimei.common.vo.order;

import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 实物订单详情vo
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel
public class OrderGoodsDetailVo {

    @ApiModelProperty(value = "实物订单基础信息")
    private OrderGoodsBase orderGoodsBase;
    @ApiModelProperty(value = "实物订单产品信息")
    private List<OrderGoodsInfo> goodsInfoList;
}
