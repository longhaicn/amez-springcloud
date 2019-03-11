package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 领取的店铺优惠券使用
 *
 * @author liurenkai
 * @time 2018/3/7 17:21
 */
@Data
@EqualsAndHashCode
@ApiModel("领取的店铺优惠券使用")
public class StoreCouponsReceivedByUsedVo implements Serializable {

    @ApiModelProperty("店铺优惠券ID")
    private Integer storeCouponsId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("商品名称")
    private String productName;

}
