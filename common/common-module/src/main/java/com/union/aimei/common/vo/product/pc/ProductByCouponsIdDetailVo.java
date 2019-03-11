package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券下所支持服务的id详情
 *
 * @author caizhaoming
 * @time 2018/04/18 16:10
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "优惠券下所支持服务的id详情")
public class ProductByCouponsIdDetailVo {

    @ApiModelProperty(value = "服务id")
    private String productId;

}
