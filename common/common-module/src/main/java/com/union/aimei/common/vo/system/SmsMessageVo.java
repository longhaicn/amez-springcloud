package com.union.aimei.common.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * SmsMessageVo
 *
 * @author liufeihua
 * @date 2018/1/10 15:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "方案附件表")
public class SmsMessageVo {

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("短信编码")
    private String smsCode;

    @ApiModelProperty("短信内容 --发送验证码不用填,发送推广短信或者营销短信的填")
    private String smsContent;
}
