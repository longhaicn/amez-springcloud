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
@ApiModel(value = "美容邦用户表")
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("IM用户ID")
    private Integer imUserId;
    @ApiModelProperty("艾美UUID")
    private String amezUuid;
    @ApiModelProperty("IM用户名")
    private String imUsername;
    @ApiModelProperty("艾美会员ID")
    private Integer amezUserId;
    @ApiModelProperty("微信openId")
    private String openId;
    @ApiModelProperty("会员名称")
    private String memberName;
    @ApiModelProperty("会员昵称")
    private String memberNickname;
    @ApiModelProperty("性别（0：男，1：女）")
    private Boolean gender;
    @ApiModelProperty("会员头像地址")
    private String memberImgUrl;
    @ApiModelProperty("个人签名")
    private String personSignature;
    @ApiModelProperty("注册手机号")
    private String registerPhone;
    @ApiModelProperty("出生年月")
    private Date birthday;
    @ApiModelProperty("等级")
    private String memberLevel;
    @ApiModelProperty("手机设备号(UDID)")
    private String deviceTokens;
    @ApiModelProperty("添加时间")
    private Date addTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}