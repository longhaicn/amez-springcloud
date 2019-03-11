package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据分类查询产品
 *
 * @author liurenkai
 * @time 2018/3/2 10:20
 */
@Data
@EqualsAndHashCode
@ApiModel("根据分类查询产品")
public class ProductPhysicalByCategoryVo implements Serializable {

    @ApiModelProperty("分类ID")
    private Integer categoryId;
    
}
