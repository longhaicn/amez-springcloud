package com.union.aimei.remote.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午4:03
  * @description
  */
@Data
@ApiModel(value = "找回支付密码VO")
public class ResetPayPwdVo {

    @ApiModelProperty(value = "手机号码")
    private String mobile;
    @ApiModelProperty(value = "验证码")
    private String verifyCode;
    @ApiModelProperty(value = "支付密码（MD5加密）")
    private String payPwd;
    @ApiModelProperty(value = "IP")
    private String ip;
    @ApiModelProperty(value = "来源(0:用户端，1：美容时端，2：店长端)")
    private Integer source;
}
