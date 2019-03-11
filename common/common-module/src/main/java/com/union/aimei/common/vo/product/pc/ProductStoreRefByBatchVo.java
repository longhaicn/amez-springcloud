package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.ProductStoreRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 批量项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/2/27 10:28
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel(value = "批量项目-门店-关联")
public class ProductStoreRefByBatchVo implements Serializable {

    public ProductStoreRefByBatchVo(List<ProductStoreRef> productStoreRefList) {
        this.productStoreRefList = productStoreRefList;
    }

    @ApiModelProperty(value = "项目-门店-关联集合")
    private List<ProductStoreRef> productStoreRefList;

}
