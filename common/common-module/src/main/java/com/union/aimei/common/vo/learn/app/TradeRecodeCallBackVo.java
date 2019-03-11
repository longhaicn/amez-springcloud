package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author houji
 * @date 2018/5/23  17:19
 */
@Data
@EqualsAndHashCode
@ApiModel("订单回调参数")
public class TradeRecodeCallBackVo {

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("交易流水号")
    private String tradeNo;

    @ApiModelProperty("交易金额（以分为单位存入）")
    private Integer tradeAmount;

    @ApiModelProperty("支付类型 0-微信、1-支付宝、2-银联、3-他人支付")
    private Byte payType;

}
