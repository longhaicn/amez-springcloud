package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据商品ID查询优惠券
 *
 * @author liurenkai
 * @time 2018/4/17 17:02
 */
@Data
@EqualsAndHashCode
@ApiModel("根据商品ID查询优惠券")
public class CouponsByProductIdVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("商品ID")
    private Integer productId;

}
