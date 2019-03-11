package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.ProductBeauticianRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 商品上架
 *
 * @author liurenkai
 * @time 2018/3/6 17:28
 */
@Data
@EqualsAndHashCode
@ApiModel("商品上架")
public class ProductByOnSaleVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("上门费")
    private Integer homeFee;

    @ApiModelProperty(value = "项目-美容师-关联集合（到店）")
    private List<ProductBeauticianRef> storeProductBeauticianRefList;

    @ApiModelProperty(value = "项目-美容师-关联集合（上门）")
    private List<ProductBeauticianRef> homeProductBeauticianRefList;

    @ApiModelProperty(value = "项目-美容师-关联集合（招募）")
    private List<ProductBeauticianRef> recruitProductBeauticianRefList;

}
