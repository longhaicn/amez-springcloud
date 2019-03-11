package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师注册条件
 *
 * @author liurenkai
 * @time 2018/5/8 17:08
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师注册条件")
public class BeauticianByRegisterVo implements Serializable {

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("密码")
    private String password;

}
