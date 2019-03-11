package com.union.aimei.common.model.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value="店铺提现")
public class StoreshipWithdrawal implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("商店id")
    private Integer storeId;

    @ApiModelProperty("提现金额")
    private Integer withdrawalAmount;

    @ApiModelProperty("流水单号")
    private String numberBankSlip;

    @ApiModelProperty("开户行")
    private String bank;

    @ApiModelProperty("户名")
    private String userName;

    @ApiModelProperty("账号")
    private String accountNumber;

    @ApiModelProperty("提现状态 1-没到帐,2-已到帐")
    private Byte withdrawalStatus;

    @ApiModelProperty("剩下余额")
    private Integer remainingAmount;

    @ApiModelProperty("统计时间年份")
    private String statisticsYear;

    @ApiModelProperty("统计时间年份月份")
    private String statisticsYearMonth;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("到账时间")
    private Date arriveTime;

    @ApiModelProperty("备注")
    private String remarks;

    /**
     * 提现状态 1-没到帐
     */
    public static final byte WITHDRAWAL_STATUS_NO = 1;
    /**
     * 提现状态 2-已到帐
     */
    public static final byte WITHDRAWAL_STATUS_YES = 2;

    private static final long serialVersionUID = 1L;
}