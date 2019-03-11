package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 门店入驻条件
 *
 * @author liurenkai
 * @time 2018/5/21 10:28
 */
@Data
@EqualsAndHashCode
@ApiModel("门店入驻条件")
public class StoreBySettledVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("入驻码")
    private String settledCode;

}