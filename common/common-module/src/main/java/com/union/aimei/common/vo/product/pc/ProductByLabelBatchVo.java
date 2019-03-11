package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.ProductCity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量商品标签
 *
 * @author liurenkai
 * @time 2018/4/19 16:08
 */
@Data
@EqualsAndHashCode
@ApiModel("批量商品标签")
public class ProductByLabelBatchVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("项目城市集合")
    private List<ProductCity> productCityList;

}
