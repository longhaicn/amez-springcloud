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
@ApiModel(value = "app门店端的营业统计中的员工业绩返回Vo")
public class QueryProjectPerformanceResponseVo {

    @ApiModelProperty(value = "项目名字")
    private String productName;
    @ApiModelProperty(value = "金额")
    private Integer amount;
    @ApiModelProperty(value = "单数")
    private Integer oderNumber;
}
