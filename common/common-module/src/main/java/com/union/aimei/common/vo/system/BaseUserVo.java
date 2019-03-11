package com.union.aimei.common.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * BaseUserVo
 *
 * @author liufeihua
 * @date 2018/1/18 17:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "添加老板,店长,员工参数")
public class BaseUserVo {

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("用户类型 0老板,1店长,2员工")
    private int userType;
}
