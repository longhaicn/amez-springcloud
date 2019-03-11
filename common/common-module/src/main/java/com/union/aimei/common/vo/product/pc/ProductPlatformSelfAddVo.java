package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 保存平台自营项目条件
 *
 * @author liurenkai
 * @time 2018/1/5 13:55
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "保存平台自营项目条件")
public class ProductPlatformSelfAddVo implements Serializable {

    @ApiModelProperty(value = "项目")
    private Product product;

    @ApiModelProperty(value = "项目图片")
    private ProductImg productImg;

    @ApiModelProperty(value = "项目-分类-关联")
    private ProductCategoryRef productCategoryRef;

    @ApiModelProperty(value = "项目城市集合")
    private List<ProductCity> productCityList;

    @ApiModelProperty(value = "项目-产品-关联")
    private ProductProductPhysicalRef productProductPhysicalRef;

}
