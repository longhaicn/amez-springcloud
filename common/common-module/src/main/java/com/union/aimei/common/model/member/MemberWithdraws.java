package com.union.aimei.common.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员提现申请表")
public class MemberWithdraws implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("会员ID")
    private Integer memberId;
    @ApiModelProperty("美容师流水id")
    private Integer tradeDetailId;
    @ApiModelProperty("美容师ID")
    private Integer beauticianId;
    @ApiModelProperty("提现人姓名")
    private String memberRealName;
    @ApiModelProperty("提现人手机号")
    private String memberPhone;
    @ApiModelProperty("所属门店ID")
    private Integer belongStoreId;
    @ApiModelProperty("所属门店名称")
    private String belongStoreName;
    @ApiModelProperty("提现申请金额")
    private Integer withdrawAmount;
    @ApiModelProperty("税率(百分比，默认百分之3)")
    private Byte taxRate;
    @ApiModelProperty("税费")
    private Integer taxation;
    @ApiModelProperty("实际提现金额(扣除手续费后)")
    private Integer actualAmount;
    @ApiModelProperty("提现银行卡ID")
    private Integer bankCardId;
    @ApiModelProperty("会员银行卡号码")
    private String bankCardNo;
    @ApiModelProperty("打款状态(0：未打款，1：已打款)")
    private Boolean playAmountStatus;
    @ApiModelProperty("提现申请时间")
    private Date addTime;
    @ApiModelProperty("打款时间")
    private Date playAmountTime;
    @ApiModelProperty("预计打款时间")
    private Date expectAmountTime;
}