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
@ApiModel(value = "短信模板表")
public class BaseSmsTemplate implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 短信类型(0验证码,1短信通知,2短信推广)
     */
    public interface SmsType {
        byte VERIFICATION_CODE = 0;
        byte NOTIFICATION = 1;
        byte PROMOTION = 2;
    }

    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("短信名称")
    private String smsName;
    @ApiModelProperty("短信编码")
    private String smsCode;
    @ApiModelProperty("短信模板")
    private String smsTemplate;
    @ApiModelProperty("短信类型(0验证码,1短信通知,2短信推广)")
    private Byte smsType;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("备注")
    private String remarks;
    @ApiModelProperty("是否删除")
    private Byte isDelete;
}