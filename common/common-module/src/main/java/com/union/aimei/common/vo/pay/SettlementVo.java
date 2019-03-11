package com.union.aimei.common.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author GaoWei
 * @time 2018/6/30 15:03
 * @description
 */
@Data
@ApiModel(value = "订单结算VO")
public class SettlementVo {

    @ApiModelProperty(value = "项目类型")
    private int productType;
    @ApiModelProperty(value = "美容师ID")
    private int beauticianId;
    @ApiModelProperty(value = "美容师类型")
    private int beauticianType;
    @ApiModelProperty(value = "项目ID")
    private int productId;
    @ApiModelProperty(value = "实际支付金额")
    private int amountPay;
    @ApiModelProperty(value = "上门服务费")
    private int frieht;
    @ApiModelProperty(value = "支付类型")
    private int payType;
    @ApiModelProperty(value = "一卡通折扣比例")
    private double oneCardDiscount;


}
