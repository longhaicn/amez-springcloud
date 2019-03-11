package com.union.aimei.common.vo.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师流水数据统计vo
 *
 * @author caizhaoming
 * @create 2018-06-07 13:44
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "美容师流水数据统计vo")
public class BeauticianTradeStatisticalVo implements Serializable {

    @ApiModelProperty("结算金额")
    private Integer settlementAmount;

    @ApiModelProperty("待结算金额")
    private Integer pendingAmount;

}
