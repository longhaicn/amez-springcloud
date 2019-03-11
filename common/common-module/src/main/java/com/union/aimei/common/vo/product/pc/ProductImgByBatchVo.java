package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.ProductImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 批量商品图片
 *
 * @author liurenkai
 * @time 2018/2/28 18:03
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel(value = "批量商品图片")
public class ProductImgByBatchVo implements Serializable {

    public ProductImgByBatchVo(List<ProductImg> productImgList) {
        this.productImgList = productImgList;
    }

    @ApiModelProperty(value = "商品图片集合")
    private List<ProductImg> productImgList;

}