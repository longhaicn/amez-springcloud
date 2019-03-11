package com.union.aimei.remote.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午4:03
  * @description
  */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员一卡通信息VO")
public class MemberOneCardVo {

    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "激活时间")
    private String activateTime;
    @ApiModelProperty(value = "余额")
    private Double balance;
    @ApiModelProperty(value = "卡号")
    private String cardNo;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "创建人")
    private Integer creater;
    @ApiModelProperty(value = "节省多少钱")
    private Double economizeMoney;
    @ApiModelProperty(value = "过期时间")
    private String expirationDate;
    @ApiModelProperty(value = "否绑定 （1 是 0 否）")
    private Integer isBinding;
    @ApiModelProperty(value = "会员ID")
    private Integer memberId;
    @ApiModelProperty(value = "会员名称")
    private String memberName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "状态(1 待激活 2使用，3过期，)")
    private Integer status;
    @ApiModelProperty(value = "一卡通")
    private TypeOneCardVo typeOneCard;
    @ApiModelProperty(value = "修改时间")
    private String updateTime;
    @ApiModelProperty(value = "修改人")
    private Integer updater;
    @ApiModelProperty(value = "版本号")
    private Integer version;


}
