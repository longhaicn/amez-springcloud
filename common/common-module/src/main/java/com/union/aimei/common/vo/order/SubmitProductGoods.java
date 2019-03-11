package com.union.aimei.common.vo.order;

import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 提交实物订单
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@EqualsAndHashCode
@ApiModel
public class SubmitProductGoods {

    @ApiModelProperty(value = "实物订单基础信息")
    private OrderGoodsBase orderGoodsBase;
    @ApiModelProperty(value = "实物订单产品信息")
    private List<OrderGoodsInfo> orderGoodsInfo;
}
