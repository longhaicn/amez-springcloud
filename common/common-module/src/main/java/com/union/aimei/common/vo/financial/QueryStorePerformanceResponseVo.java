package com.union.aimei.common.vo.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author liufeihua
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "app门店端的营业统计中的员工业绩Vo")
public class QueryStorePerformanceResponseVo {

    @ApiModelProperty(value = "营业额")
    private Integer turnover;
    @ApiModelProperty(value = "订单收入")
    private Integer amount;
    @ApiModelProperty(value = "成交订单数")
    private Integer oderNumber;
}
