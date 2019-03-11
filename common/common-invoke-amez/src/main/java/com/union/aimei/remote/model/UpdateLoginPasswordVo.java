package com.union.aimei.remote.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GaoWei
 * @describe  修改登录密码vo
 * @time 2018/4/12,17:06
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "修改登录密码VO")
public class UpdateLoginPasswordVo {

    @ApiModelProperty(value = "用户UUID")
    private String uuid;
    @ApiModelProperty(value = "旧密码")
    private String oldLoginPassword;
    @ApiModelProperty(value = "新密码")
    private String newLoginPassword;
    @ApiModelProperty(value = "IP")
    private String ip;

}
