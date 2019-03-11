package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.ProductCity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 批量项目城市
 *
 * @author liurenkai
 * @time 2018/2/27 10:24
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel(value = "批量项目城市")
public class ProductCityByBatchVo implements Serializable {

    public ProductCityByBatchVo(List<ProductCity> productCityList) {
        this.productCityList = productCityList;
    }

    @ApiModelProperty(value = "项目城市集合")
    private List<ProductCity> productCityList;

}
