package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品（店铺优惠券）
 *
 * @author liurenkai
 * @time 2018/1/11 16:34
 */
@Data
@EqualsAndHashCode
@ApiModel("商品（店铺优惠券）")
public class ProductByStoreCouponsVo implements Serializable {

    @ApiModelProperty("品牌ID")
    private Integer brandId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("商品名称")
    private String serverName;

}
