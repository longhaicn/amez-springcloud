package com.union.aimei.common.model.umeng;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Data
@EqualsAndHashCode
@ApiModel(value="友盟消息推送记录")
public class BaseUmengPushHistory implements Serializable {
       @ApiModelProperty("主键自增")
       private Integer id;

       @ApiModelProperty("模板Id")
       private Integer templateId;

       @ApiModelProperty("发送设备token")
       private String deviceToken;

       @ApiModelProperty("设备类型 1--android系统 2--ios系统")
       private Integer deviceType;

       @ApiModelProperty("消息类型(0--服务消息  1--项目消息 2--系统消息)")
       private Integer msgType;

       @ApiModelProperty("用户消息的类型集合(service,project,system)")
       private String msgCode;

       @ApiModelProperty("会员的id")
       private Integer memberId;

       @ApiModelProperty("必填，通知栏通知信息")
       private String pushTicker;

       @ApiModelProperty("必填，通知标题")
       private String pushTitle;

       @ApiModelProperty("必填，通知文字描述")
       private String pushText;

       @ApiModelProperty("跳转类型(系统消息招募挂靠跳转参数)")
       private Integer target;

       @ApiModelProperty("参数(系统消息招募挂靠内容参数)")
       private String param;

       @ApiModelProperty("自定义的内容")
       private String custom;

       @ApiModelProperty("跳转类型(0---app原生  1---html5)")
       private String forwardType;

       @ApiModelProperty("跳转页面url")
       private String forwardUrl;

       @ApiModelProperty("读取状态 0--未读取 1--已读取 2--删除")
       private String readStatus;

       @ApiModelProperty("创建时间")
       private Date createTime;

       @ApiModelProperty("更新时间")
       private Date updateTime;

       private static final long serialVersionUID = 1L;
}