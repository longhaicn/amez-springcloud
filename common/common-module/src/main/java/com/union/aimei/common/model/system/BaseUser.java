package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "用户表")
public class BaseUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    @ApiModelProperty("登录名")
    private String loginName;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("手机号码")
    private String mobilePhone;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("是否禁用 0启用 1禁用")
    private Byte isDisabled;
    @ApiModelProperty("前台用户：front,后台用户:admin")
    private String userType;
    private Date lastLoginTime;
    private Date expirEtime;
}