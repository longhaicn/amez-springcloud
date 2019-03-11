package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author liurenkai
 * @time 2018/2/28 15:53
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel(value = "批量项目-产品-关联")
public class ProductProductPhysicalRefByBatchVo implements Serializable {

    public ProductProductPhysicalRefByBatchVo(List<ProductProductPhysicalRef> productProductPhysicalRefList) {
        this.productProductPhysicalRefList = productProductPhysicalRefList;
    }

    @ApiModelProperty(value = "项目-产品-关联集合")
    private List<ProductProductPhysicalRef> productProductPhysicalRefList;

}
