package com.union.aimei.common.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/27,20:33
*/
@Data
@ApiModel(value = "微信支付回调对象")
public class WeChatPayNotifyVo {
    @ApiModelProperty(value = "公共回传参数")
    private String attach;
    @ApiModelProperty(value = "商户订单号")
    private String outTradeNo;
    @ApiModelProperty(value = "订单总金额")
    private Integer totalFee;
    @ApiModelProperty(value = "微信交易流水号")
    private String transactionId;

}
