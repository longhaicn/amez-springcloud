package com.union.aimei.common.vo.pay;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe 支付完成操作传递对象
 * @time 2018/3/7,14:18
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "支付完成操作传递对象VO")
public class AfterPayPassVo {

    @ApiModelProperty(value = "服务订单编号")
    private String productOrderNo;
    @ApiModelProperty(value = "服务订单交易流水号")
    private String productTradeNo;
    @ApiModelProperty(value = "支付类型")
    private Integer payType;
    @ApiModelProperty(value = "实际支付金额")
    private Integer amountPay;
}
