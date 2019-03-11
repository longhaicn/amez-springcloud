package com.union.aimei.common.vo.order;

import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 提交订单数据
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@EqualsAndHashCode
@ApiModel(value = "提交订单数据")
public class SubmitOrder {
    @ApiModelProperty(value = "订单基础信息")
    private OrderBase orderBase;
    @ApiModelProperty(value = "订单美容师信息")
    private OrderBeautician orderBeautician;
    @ApiModelProperty(value = "订单商品信息")
    private OrderProduct orderProduct;
    @ApiModelProperty(value = "订单服务消耗实物产品记录")
    List<OrderProductConsumeGoodsRecord> consumeGoodsRecordList;
}
