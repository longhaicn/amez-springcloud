package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/26,13:40
*/
@Data
@ApiModel(value = "微信关联会员请求vo")
public class WxRelationMemberVo {
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "验证码")
    private String verifyCode;
//    @ApiModelProperty(value = "微信会员信息")
//    private WxMpUser wxMpUser;
}
