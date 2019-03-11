package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author houji
 * @date 2018/3/1  12:55
 */
@Data
@EqualsAndHashCode
@ApiModel(value="会员提现申请管理")
public class MemberWithdrawsVo implements Serializable {
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("会员ID")
    private Integer memberId;

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

    @ApiModelProperty("提现申请开始时间")
    private Date addStartTime;

    @ApiModelProperty("提现申请结束时间")
    private Date addEndTime;

    @ApiModelProperty("打款开始时间")
    private Date playAmountStartTime;

    @ApiModelProperty("打款结束时间")
    private Date playAmountEndTime;

    private static final long serialVersionUID = 1L;
}
