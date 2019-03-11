package com.union.aimei.common.vo.member;

import com.union.aimei.common.model.member.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe 微信快捷登录VO
 * @time 2018/1/26,11:39
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "微信快捷登录VO")
public class WxQuickLoginVo {

    @ApiModelProperty(value = "是否已关联微信")
    private boolean hasRelationWx;
    @ApiModelProperty(value = "艾美会员令牌")
    private String token;
    @ApiModelProperty(value = "会员信息")
    private Member member;
}
