package com.union.aimei.common.vo.auth;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请求TokenVo
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@ApiModel(value = "请求TokenVo")
public class RequestTokenVo {

    @ApiModelProperty(value = "身份类型0：游客1：会员(String类型)")
    private String identityType;
    @ApiModelProperty(value = "用户uuid")
    private String uuid;
    @ApiModelProperty(value = "秘钥Key")
    private String secretKey;

}
