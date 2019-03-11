package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据商品查询领取的最佳店铺优惠券（提交订单）
 *
 * @author liurenkai
 * @time 2018/1/22 11:17
 */
@Data
@EqualsAndHashCode
@ApiModel("根据商品查询领取的最佳店铺优惠券（提交订单）")
public class StoreCouponsByProductForBestForOrderVo implements Serializable {

    @ApiModelProperty(value = "店铺ID")
    private Integer storeId;

    @ApiModelProperty(value = "商品ID")
    private Integer productId;

    @ApiModelProperty(value = "会员ID")
    private Integer memberId;

    @ApiModelProperty(value = "销售价格")
    private Integer salePrice;
}
