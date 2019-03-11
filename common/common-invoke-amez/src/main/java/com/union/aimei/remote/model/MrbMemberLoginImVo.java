package com.union.aimei.remote.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容邦登录注册IM条件
 *
 * @author liurenkai
 * @time 2018/7/11 18:15
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "美容邦登录注册IM条件")
public class MrbMemberLoginImVo implements Serializable {

    @ApiModelProperty(value = "登录主体0：用户，1：美容师，2：店长")
    private MrbMemberLoginVo loginVo;

    @ApiModelProperty("IM用户ID")
    private Integer imUserId;

    @ApiModelProperty("IM用户名")
    private String imUsername;

}
