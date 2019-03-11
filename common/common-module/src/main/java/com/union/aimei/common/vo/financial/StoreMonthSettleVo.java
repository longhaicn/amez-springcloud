package com.union.aimei.common.vo.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author GaoWei
 * @describe 店铺月结算vo
 * @time 2018/2/4,23:18
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺月结算vo")
public class StoreMonthSettleVo {

    @ApiModelProperty(value = "店铺统计年份月份")
    private String yearMonth;
    @ApiModelProperty(value = "结算时间")
    private Date settlementTime;
    @ApiModelProperty(value = "月累计净收入")
    private Long monthIncome;
    @ApiModelProperty(value = "结算状态")
    private boolean settlementStatus;
}
