package com.union.aimei.common.vo.financial;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class QueryProjectPerformanceVo {

    @ApiModelProperty(value = "门店ID")
    private int storeId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "自定义开始时间")
    private String startDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "自定义结束时间")
    private String endDate;
}
