package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author houji
 * @date 2018/6/11  10:12
 */
@Data
@ApiModel(value = "美容邦登录注册VO")
public class MrbMemberLoginVo {
    @ApiModelProperty(value = "登录主体0：用户，1：美容师，2：店长")
    private Integer loginCustomer;
    @ApiModelProperty(value = "登录方式0:手机登录，1：账号密码登录")
    private Integer loginType;
    @ApiModelProperty(value = "IP地址(客户端IP地址)", example = "192.168.1.170")
    private String ip;
    @ApiModelProperty(value = "手机号码", example = "17704060953")
    private String mobile;
    @ApiModelProperty(value = "验证码", example = "0755")
    private String verifyCode;
    @ApiModelProperty(value = "密码((MD5加密))", example = "01eb7f3269ce8b17b07f0dc4c13af91d")
    private String password;
    @ApiModelProperty(value = "来源0:用户端，1：美容师端，2：店长端", example = "0")
    private String source;
    @ApiModelProperty(value = "用户名", example = "17704060953")
    private String userName;
}
