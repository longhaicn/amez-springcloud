package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券下所支持服务的idvo
 *
 * @author caizhaoming
 * @time 2018/04/18 16:10
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "优惠券下所支持服务的id")
public class StoreCouponsProductDetailResultVo {

    @ApiModelProperty(value = "关联id")
    private String id;

    @ApiModelProperty(value = "服务id")
    private String productId;

}
