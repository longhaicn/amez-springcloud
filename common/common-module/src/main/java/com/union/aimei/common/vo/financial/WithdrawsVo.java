package com.union.aimei.common.vo.financial;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@EqualsAndHashCode
@ApiModel(value = "会员提现申请")
public class WithdrawsVo implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty("提现申请时间")
    private Date addTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty("打款时间")
    private Date playAmountTime;

    @ApiModelProperty("打款状态")
    private Integer playAmountStatus;

    @ApiModelProperty("提现人名字/手机号")
    private String beauticianNameAndPhone;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty("会员id")
    private Integer memberId;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("取款金额")
    private Integer withdrawAmount;

    @ApiModelProperty("银行卡id")
    private Integer bankCardId;

    @ApiModelProperty("银行卡号码")
    private String bankCardNo;

    private static final long serialVersionUID = 1L;
}