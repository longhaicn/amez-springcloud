package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品销量
 *
 * @author liurenkai
 * @time 2018/3/9 13:42
 */
@Data
@EqualsAndHashCode
@ApiModel("商品销量")
public class ProductBySaleVolumeVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("销量")
    private Integer saleVolume;

}
