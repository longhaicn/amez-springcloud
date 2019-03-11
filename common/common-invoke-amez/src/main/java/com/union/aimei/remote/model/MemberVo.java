package com.union.aimei.remote.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/15,17:03
*/
@Data
@EqualsAndHashCode
public class MemberVo {
    @ApiModelProperty(value = "登录方式0:手机登录，1：账号密码登录")
    private Integer loginType;
    @ApiModelProperty(value = "IP地址", example = "192.168.1.170")
    private String ip;
    @ApiModelProperty(value = "手机号码", example = "17704060953")
    private String mobile;
    @ApiModelProperty(value = "手机设备号(UDID)")
    private String deviceTokens;
    @ApiModelProperty(value = "密码", example = "123456")
    private String password;
    @ApiModelProperty(value = "支付密码", example = "121801")
    private String payPassword;
    @ApiModelProperty(value = "来源", example = "深圳罗湖")
    private String source;
    @ApiModelProperty(value = "用户名", example = "wsdtsh159359")
    private String userName;
    @ApiModelProperty(value = "验证码", example = "123456")
    private String validateCode;
    @ApiModelProperty(value = "艾美会员ID")
    private Integer amId;
    @ApiModelProperty(value = "token")
    private String token;
    @ApiModelProperty(value = "UUID")
    private String uuid;

}
