package com.union.aimei.remote.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GaoWei
 * @describe 修改支付密码VO
 * @time 2018/4/12,17:08
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "更新支付密码VO")
public class UpdatePayPasswordVo {

    @ApiModelProperty(value = "用户UUID")
    private String uuid;
    @ApiModelProperty(value = "旧支付密码")
    private String oldPayPassword;
    @ApiModelProperty(value = "新支付密码")
    private String newPayPassword;
    @ApiModelProperty(value = "IP")
    private String ip;
}
