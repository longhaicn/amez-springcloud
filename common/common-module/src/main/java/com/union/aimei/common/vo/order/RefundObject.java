package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GaoWei
 * @time 2018/6/1 14:34
 * @description 申请退款对象
 */
@Data
public class RefundObject {

    private int id;
    @ApiModelProperty(value = "商户订单号")
    private String outTradeNo;
    @ApiModelProperty(value = "交易流水号")
    private String tradeNo;
    @ApiModelProperty(value = "商户退款号")
    private String outRefundNo;
    @ApiModelProperty(value = "订单金额")
    private int totalFee;
    @ApiModelProperty(value = "退款金额")
    private int refundFee;
    @ApiModelProperty(value = "退款状态")
    private int refundStatus;

}
