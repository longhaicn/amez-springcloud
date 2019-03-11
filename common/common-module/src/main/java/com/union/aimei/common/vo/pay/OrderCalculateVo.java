package com.union.aimei.common.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 订单结算vo
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@ApiModel
public class OrderCalculateVo {

    @ApiModelProperty(value = "订单类型，0：到店，1：上门")
    private int orderType;
    @ApiModelProperty(value = "项目类型，0：平台，1：门店自营")
    private int productType;
    @ApiModelProperty(value = "平台抽佣比例")
    private int platformCommissionRate;
    @ApiModelProperty(value = "门店抽佣比例")
    private int storeCommissionRate;
    @ApiModelProperty(value = "美容师固定佣金")
    private int beauticianFixCommission;
    @ApiModelProperty(value = "订单实付金额")
    private int amountPay;
    @ApiModelProperty(value = "美容师类型(0:全职，1：兼职)")
    private int beauticianType;
}
