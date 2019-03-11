package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.function.Supplier;

/**
 * 计算订单价格VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@ApiModel(value = "计算订单价格VO")
public class OrderAmountVo implements Serializable{


    @ApiModelProperty(value = "是否上门")
    private boolean isToDoor;
    @ApiModelProperty(value = "服务价格")
    private int productPrice;
    @ApiModelProperty(value = "数量")
    private int num;
    @ApiModelProperty(value = "上门费")
    private int fee;
    @ApiModelProperty(value = "优惠券减免金额")
    private int couponReduce;
    @ApiModelProperty(value = "会员卡折扣")
    private int disCount;


    public static OrderAmountVo create(Supplier<OrderAmountVo> supplier){
        return supplier.get();
    }


}
