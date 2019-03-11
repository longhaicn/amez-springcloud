package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 项目详情结果
 *
 * @author liurenkai
 * @time 2018/1/8 18:05
 */
@Data
@EqualsAndHashCode
@ApiModel("项目详情结果")
public class ProductByDetailResVo implements Serializable {

    @ApiModelProperty("商品")
    private Product product;

    @ApiModelProperty("商品图片")
    private ProductImg productImg;

    @ApiModelProperty("商品-分类-关联")
    private ProductCategoryRef productCategoryRef;

    @ApiModelProperty("商品-城市-关联")
    private List<ProductCity> productCityList;

    @ApiModelProperty("项目-门店-关联")
    private List<ProductStoreRef> productStoreRefList;

    @ApiModelProperty("项目-产品-关联")
    private ProductProductPhysicalRef productProductPhysicalRef;

    @ApiModelProperty(value = "项目-美容师-关联集合（到店）")
    private List<ProductBeauticianRef> storeProductBeauticianRefList;

    @ApiModelProperty(value = "项目-美容师-关联集合（上门）")
    private List<ProductBeauticianRef> homeProductBeauticianRefList;

}
