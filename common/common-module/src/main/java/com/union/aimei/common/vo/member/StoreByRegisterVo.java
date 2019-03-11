package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 门店注册条件
 *
 * @author liurenkai
 * @time 2018/5/25 17:50
 */
@Data
@EqualsAndHashCode
@ApiModel("门店注册条件")
public class StoreByRegisterVo implements Serializable {
    
    @ApiModelProperty("店长ID")
    private Integer sellerUserId;

    @ApiModelProperty("店长手机号码")
    private String sellerPhone;

    @ApiModelProperty("店长账号")
    private String sellerName;

}
