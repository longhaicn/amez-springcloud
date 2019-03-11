package com.union.aimei.common.model.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 退款信息
 *
 * @author gaowei
 * @time 2018/8/24 10:03
 */
@Data
@ApiModel("退款信息")
public class Refund {
    @ApiModelProperty("商户订单号")
    private String outTradeNo;
    @ApiModelProperty("支付宝交易号")
    private String tradeNo;
    @ApiModelProperty("需要退款的金额")
    private String refundAmount;
    @ApiModelProperty("退款的说明原因")
    private String refundReason;
    @ApiModelProperty("标识一次退款请求")
    private String outRequestNo;
    @ApiModelProperty("商户的操作员编号")
    private String operatorId;
    @ApiModelProperty("商户的门店号")
    private String storeId;
    @ApiModelProperty("商户的终端编号")
    private String terminalId;

}
