package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.PhysicalCategoryRef;
import com.union.aimei.common.model.product.ProductPhysical;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 添加产品
 *
 * @author liurenkai
 * @time 2018/3/2 11:54
 */
@Data
@EqualsAndHashCode
@ApiModel("添加产品")
public class ProductPhysicalByAddVo implements Serializable {

    @ApiModelProperty("产品")
    private ProductPhysical productPhysical;

    @ApiModelProperty("产品-产品分类-关联")
    private PhysicalCategoryRef physicalCategoryRef;

}
