package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.aimei.common.model.product.ProductImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 到店项目详情结果
 *
 * @author liurenkai
 * @time 2018/1/8 18:05
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "到店项目详情结果")
public class ProductByDetailByResultVo implements Serializable {

    @ApiModelProperty(value = "项目")
    private Product product;

    @ApiModelProperty(value = "项目图片")
    private ProductImg productImg;

    @ApiModelProperty(value = "项目-分类-关联")
    private ProductCategoryRef productCategoryRef;

    @ApiModelProperty(value = "是否收藏标记")
    private Boolean isCollection;
}
