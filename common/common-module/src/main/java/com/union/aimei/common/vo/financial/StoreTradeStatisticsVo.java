package com.union.aimei.common.vo.financial;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author caizhaoming
 * @describe 财务对账vo
 * @time 2018/6/6,16:34
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "财务对账vo")
public class StoreTradeStatisticsVo {

    @ApiModelProperty(value = "月份/年份")
    private String monthAndYearStr;

    @ApiModelProperty(value = "年月日区间开始")
    private String dateInterregionalStart;

    @ApiModelProperty(value = "年月日区间结束")
    private String dateInterregionalEnd;

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("门店id")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("门店电话")
    private String storePhone;

    @ApiModelProperty("月订单总量")
    private Integer monthlyOrderQuantity;

    @ApiModelProperty("本月销售总额")
    private Integer totalSalesThisMonth;

    @ApiModelProperty("月净收入")
    private Integer onNetIncome;

    @ApiModelProperty("已服务订单(未完成订单)")
    private Integer serviceOrder;

    @ApiModelProperty("已服务订单金额(未完成订单)")
    private Integer serviceOrderAmount;

    @ApiModelProperty("已完成订单数(已完成订单)")
    private Integer orderCompleted;

    @ApiModelProperty("已完成订单总金额(已完成订单)")
    private Integer orderCompletedAmount;

    @ApiModelProperty("退款订单数")
    private Integer refundOrder;

    @ApiModelProperty("退款总金额")
    private Integer refundOrderAmount;

    @ApiModelProperty("会员卡售卡数量")
    private Integer cardNumber;

    @ApiModelProperty("售卡奖励")
    private Integer sellCardRewards;

    @ApiModelProperty("打款状态:0未打款,1-已打款")
    private Integer playStatus;

    @ApiModelProperty("打款时间")
    private Date playTime;

    @ApiModelProperty("统计时间年份")
    private String statisticsYear;

    @ApiModelProperty("统计时间年份月份")
    private String statisticsYearMonth;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("对账金额")
    private Integer reconciliationAmount;

    @ApiModelProperty("对账流水状态 0-初始状态（无按钮），1-对账确认，2-提现申请，3-提交提现申请，4-已提现")
    private Integer reconciliationType;




}
