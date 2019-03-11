package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 商品结果（店铺优惠券）
 *
 * @author liurenkai
 * @time 2018/1/11 16:31
 */
@Data
@EqualsAndHashCode
@ApiModel("商品结果（店铺优惠券）")
public class ProductByStoreCouponsResultVo implements Serializable {

    @ApiModelProperty("品牌商品结果（店铺优惠券）")
    private List<ProductByStoreCouponsForBrandResultVo> productByStoreCouponsForBrandResultVoList;

    @ApiModelProperty("自营商品结果（店铺优惠券）")
    private List<ProductByStoreCouponsForSelfResultVo> productByStoreCouponsForSelfResultVoList;

}
