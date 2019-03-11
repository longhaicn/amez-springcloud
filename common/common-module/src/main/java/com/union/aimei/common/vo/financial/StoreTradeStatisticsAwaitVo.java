package com.union.aimei.common.vo.financial;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author caizhaoming
 * @describe 财务对账vo
 * @time 2018/6/6,16:34
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "财务对账(待结算)vo")
public class StoreTradeStatisticsAwaitVo {

    @ApiModelProperty(value = "月份/年份")
    private String monthAndYearStr;

    @ApiModelProperty(value = "年月日区间开始")
    private String dateInterregionalStart;

    @ApiModelProperty(value = "年月日区间结束")
    private String dateInterregionalEnd;

    @ApiModelProperty("对账金额")
    private Integer reconciliationAmount;

    @ApiModelProperty("统计时间年份")
    private String statisticsYear;

    @ApiModelProperty("对账流水状态 0-初始状态（无按钮），1-对账确认，2-提现申请，3-提交提现申请，4-已提现")
    private Integer reconciliationType;

    @ApiModelProperty("统计时间年份月份")
    private String statisticsYearMonth;

    @ApiModelProperty("门店id")
    private Integer storeId;

    @ApiModelProperty(value = "预计结算日期")
    private String settlementDate;

    @ApiModelProperty(value = "账单日期")
    private String billDate;


}
