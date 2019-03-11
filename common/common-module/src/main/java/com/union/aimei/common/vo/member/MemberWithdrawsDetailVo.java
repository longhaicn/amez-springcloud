package com.union.aimei.common.vo.member;

import com.union.aimei.common.model.member.MemberWithdraws;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author houji
 * @date 2018/3/1  19:42
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员提现详情信息表")
public class MemberWithdrawsDetailVo  implements Serializable {
    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("会员ID")
    private Integer memberId;

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

    @ApiModelProperty("开户人")
    private String accountName;

    @ApiModelProperty("开户行")
    private String accountBank;

    @ApiModelProperty("开户支行")
    private String accountBranchBank;

    @ApiModelProperty("会员银行卡号码")
    private String bankCardNo;

    @ApiModelProperty("打款状态(0：未打款，1：已打款)")
    private Boolean playAmountStatus;

    @ApiModelProperty("提现申请时间")
    private Date addTime;

    @ApiModelProperty("打款时间")
    private Date playAmountTime;

    public MemberWithdrawsDetailVo(MemberWithdraws memberWithdraws){
        this.id =  memberWithdraws.getId();
        this.memberId = memberWithdraws.getMemberId();
        this.beauticianId = memberWithdraws.getBeauticianId();
        this.memberRealName =  memberWithdraws.getMemberRealName();
        this.memberPhone =  memberWithdraws.getMemberPhone();
        this.belongStoreId = memberWithdraws.getBelongStoreId();
        this.belongStoreName = memberWithdraws.getBelongStoreName();
        this.withdrawAmount = memberWithdraws.getWithdrawAmount();
        this.taxRate = memberWithdraws.getTaxRate();
        this.taxation = memberWithdraws.getTaxation();
        this.actualAmount = memberWithdraws.getActualAmount();
        this.bankCardId = memberWithdraws.getBankCardId();
        this.bankCardNo = memberWithdraws.getBankCardNo();
        this.playAmountStatus = memberWithdraws.getPlayAmountStatus();
        this.addTime = memberWithdraws.getAddTime();
        this.playAmountTime = memberWithdraws.getPlayAmountTime();
    }

    private static final long serialVersionUID = 1L;

}
