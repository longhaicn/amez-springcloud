package com.union.aimei.common.model.umeng;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author houji
 * @date 2018/7/25  14:06
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@EqualsAndHashCode
@ApiModel(value="会员设备码表")
public class BaseMemberDevice implements Serializable {
       @ApiModelProperty("主键id")
       private Integer id;

       @ApiModelProperty("会员id，登陆人员的id")
       private Integer memberId;

       @ApiModelProperty("设备所属用户权限：0--用户端  1 --美容师端 2--店长端,默认0")
       private Integer deviceSystem;

       @ApiModelProperty("会员手机类型 1--android手机 2--ios手机")
       private Integer deviceType;

       @ApiModelProperty("umeng集成token")
       private String deviceToken;

       @ApiModelProperty("同一个设备同一个权限用户谁在使用标识(0---不在线 1--在线，默认1)")
       private Integer tokenOnline;

       @ApiModelProperty("录入时间")
       private Date createTime;

       @ApiModelProperty("更新时间")
       private Date updateTime;

       private static final long serialVersionUID = 1L;
}