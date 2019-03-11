package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 修改门店自营项目
 *
 * @author liurenkai
 * @time 2018/1/5 13:55
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "修改门店自营项目")
public class ProductStoreSelfModifyVo implements Serializable {

    @ApiModelProperty(value = "商品")
    private Product product;

    @ApiModelProperty(value = "商品图片")
    private ProductImg productImg;

    @ApiModelProperty(value = "商品-分类-关联")
    private ProductCategoryRef productCategoryRef;

    @ApiModelProperty(value = "项目-门店-关联")
    private ProductStoreRef productStoreRef;

    @ApiModelProperty(value = "项目-美容师-关联集合（到店）")
    private List<ProductBeauticianRef> storeProductBeauticianRefList;

    @ApiModelProperty(value = "项目-美容师-关联集合（上门）")
    private List<ProductBeauticianRef> homeProductBeauticianRefList;

}
