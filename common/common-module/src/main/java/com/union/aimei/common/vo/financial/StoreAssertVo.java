package com.union.aimei.common.vo.financial;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author GaoWei
 * @describe 店铺资产统计VO
 * @time 2018/2/4,16:34
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺资产统计Vo")
public class StoreAssertVo {

    @ApiModelProperty(value = "门店ID")
    private Integer storeId;
    @ApiModelProperty(value = "年净收入")
    private Integer yearNetIncome;
    @ApiModelProperty(value = "统计年份")
    private String statisticsYear;
    @ApiModelProperty(value = "店铺累计订单量")
    private Integer orderTotalNum;
    @ApiModelProperty(value = "店铺累计净收入")
    private Long Cumulative;
    @ApiModelProperty(value = "月账单信息")
    private List<StoreMonthSettleVo> billList;
}
