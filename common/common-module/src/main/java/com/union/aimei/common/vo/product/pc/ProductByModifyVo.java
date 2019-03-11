package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.aimei.common.model.product.ProductImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 修改商品
 *
 * @author liurenkai
 * @time 2018/1/5 14:17
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "修改商品")
public class ProductByModifyVo implements Serializable {

    @ApiModelProperty(value = "商品")
    private Product product;

    @ApiModelProperty(value = "商品图片")
    private ProductImg productImg;

    @ApiModelProperty(value = "商品与商品分类关联")
    private ProductCategoryRef productCategoryRef;
}
