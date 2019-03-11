package com.union.aimei.common.vo.financial;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author GaoWei
 * @describe 店铺月账单
 * @time 2018/2/6,14:44
 */
@Data
@EqualsAndHashCode
public class StoreMonthBillVo {

    @ApiModelProperty(value = "交易流水ID")
    private Integer id;
    @ApiModelProperty(value = "交易类型")
    private Integer tradeType;
    @ApiModelProperty(value = "支付时间")
    private Date payTime;
    @ApiModelProperty(value = "商品名称")
    private String productName;
    @ApiModelProperty(value = "结算金额")
    private Integer settlementAmount;
}
