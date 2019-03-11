package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.model.product.ProductBeauticianRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 批量项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/27 10:39
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel(value = "批量项目-美容师-关联")
public class ProductBeauticianRefByBatchVo implements Serializable {

    public ProductBeauticianRefByBatchVo(List<ProductBeauticianRef> productBeauticianRefList) {
        this.productBeauticianRefList = productBeauticianRefList;
    }

    @ApiModelProperty(value = "项目-美容师-关联集合")
    private List<ProductBeauticianRef> productBeauticianRefList;

}
