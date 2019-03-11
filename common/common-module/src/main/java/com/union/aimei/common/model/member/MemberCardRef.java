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
@ApiModel(value = "用户会员卡表")
public class MemberCardRef implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("会员ID")
    private Integer memberId;
    @ApiModelProperty("会员卡ID")
    private Integer cardId;
    @ApiModelProperty("会员名称")
    private String memberName;
    @ApiModelProperty("会员手机号码")
    private String memberMobile;
    @ApiModelProperty("总金额（以分为单位存入）")
    private Integer totalBalance;
    @ApiModelProperty("可用金额（以分为单位存入）")
    private Integer useableBalance;
    @ApiModelProperty("冻结金额（以分为单位存入）")
    private Integer frozenBalance;
    @ApiModelProperty("使用状态(0：正常，1：被冻结，2：已作废)")
    private Byte isEnabled;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("过期时间")
    private Date expiredTime;
}