package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "已发送的短信历史表")
public class BaseSmsHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("短信名称")
    private String smsName;
    @ApiModelProperty("短信编码")
    private String smsCode;
    @ApiModelProperty("短信模板")
    private String smsTemplate;
    @ApiModelProperty("短信内容")
    private String smsContent;
    @ApiModelProperty("短信类型(0验证码,1短信通知,2短信推广)")
    private Byte smsType;
    @ApiModelProperty("接收短信的手机号码")
    private String receivePhone;
    @ApiModelProperty("发送时间")
    private Date sendTime;
    @ApiModelProperty("返回状态码解释")
    private String responseMessage;
    @ApiModelProperty("返回状态码")
    private String responseCode;
    @ApiModelProperty("	请求ID")
    private String requestid;
    @ApiModelProperty("发送回执ID,可根据该ID查询具体的发送状态")
    private String bizid;
}