package com.union.aimei.common.vo.order;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * @author GaoWei
  * @Date 18-8-23 下午4:36
  * @description 美容师当天订单和预收入信息
  */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "美容师当天订单和预收入信息")
public class BeauticianTodayBussinessInfo {

    @ApiModelProperty(value = "订单总数")
    private Integer orderTotal;
    @ApiModelProperty(value = "预收入金额")
    private Integer preIncome;
}
