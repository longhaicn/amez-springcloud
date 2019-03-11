package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师详情条件
 *
 * @author liurenkai
 * @time 2018/6/26 20:31
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师详情条件")
public class BeauticianDetailVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

}
