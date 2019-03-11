package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GaoWei
 * @time 2018/5/31
 * @description
 */
@Data
@ApiModel(value = "美容师不同状态订单数量")
public class BeauticianTodayOrderCount {

    @ApiModelProperty(value = "美容师ID")
    private int beauticianId;
    @ApiModelProperty(value = "订单状态")
    private int status;
    @ApiModelProperty(value = "订单数量")
    private int num;
}
