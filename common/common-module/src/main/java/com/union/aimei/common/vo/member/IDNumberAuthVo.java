package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author houji
 * @date 2018/3/6  11:44
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "身份证第三方实名认证Vo")
public class IDNumberAuthVo implements Serializable {

    @ApiModelProperty(value = "身份证号码")
    private String cardNo;

    @ApiModelProperty(value = "身份证真实姓名")
    private String realName;

}
