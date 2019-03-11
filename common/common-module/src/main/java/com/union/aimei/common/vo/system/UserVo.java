package com.union.aimei.common.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * UserVo
 *
 * @author liufeihua
 * @date 2018/1/11 11:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "用户登录信息")
public class UserVo {

    public final static int USER_LOGIN = 0;
    public final static int PHONE_LOGIN = 1;

    @ApiModelProperty("用户名或者手机号码")
    private String userName;
    @ApiModelProperty("密码或者验证码")
    private String password;
    @ApiModelProperty("登录类型: 0表示账号登录,1表示手机登录")
    private int loginType;
}
