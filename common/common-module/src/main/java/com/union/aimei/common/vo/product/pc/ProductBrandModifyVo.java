package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.aimei.common.model.product.ProductCity;
import com.union.aimei.common.model.product.ProductImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 修改品牌项目
 *
 * @author liurenkai
 * @time 2018/1/5 13:55
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "修改品牌项目")
public class ProductBrandModifyVo implements Serializable {

    @ApiModelProperty(value = "项目")
    private Product product;

    @ApiModelProperty(value = "项目图片")
    private ProductImg productImg;

    @ApiModelProperty(value = "商品-分类-关联")
    private ProductCategoryRef productCategoryRef;

    @ApiModelProperty(value = "项目城市集合")
    private List<ProductCity> productCityList;

}
