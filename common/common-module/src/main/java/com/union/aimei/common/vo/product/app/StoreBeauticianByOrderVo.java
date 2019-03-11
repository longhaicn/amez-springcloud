package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺美容师（订单）
 *
 * @author liurenkai
 * @time 2018/3/16 15:20
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺美容师（订单）")
public class StoreBeauticianByOrderVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

}
