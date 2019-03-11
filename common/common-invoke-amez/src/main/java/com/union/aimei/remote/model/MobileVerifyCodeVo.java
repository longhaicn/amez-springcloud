package com.union.aimei.remote.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe 手机验证码VO
 * @time 2018/1/16,19:09
*/
@Data
@EqualsAndHashCode
@ApiModel
public class MobileVerifyCodeVo {
    @ApiModelProperty(value = "获取验证码类型(0:注册登录验证码,1:修改登录密码(登录),2:修改支付密码(登录)，3:找回登录密码)")
    private Integer codeType;
    @ApiModelProperty(value = "手机号码")
    private String mobile;
    @ApiModelProperty(value = "uuid")
    private String uuid;
    @ApiModelProperty(value = "token(旧的接口使用)")
    private String token;

    public interface CodeType{
        int REGIN_LOGIN_CODE = 0;
        int UPDATE_LOGIN_CODE = 1;
        int UPDATE_PAY_CODE = 2;
        int FIND_LOGIN_PWD_CODE = 3;
    }
}
