package com.union.aimei.common.vo.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
/**
 * @author liufeihua
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "统计店铺待结算流水的对账金额")
public class StoreTradeDetailSumVo implements Serializable {


    @ApiModelProperty(value = "筛选开始时间")
    private String startTime;

    @ApiModelProperty(value = "筛选结束时间")
    private String endTime;

    @ApiModelProperty("店铺id")
    private Integer storeId;

}