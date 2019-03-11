package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品排序(店铺)
 *
 * @author liurenkai
 * @time 2018/1/5 15:13
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "商品排序(店铺)")
public class ProductByStoreIdForSortVo implements Serializable {

    @ApiModelProperty(value = "店铺ID")
    private Integer storeId;

    @ApiModelProperty(value = "排序类型，1=热销，2=上门，3，新品，4，价格")
    private Integer sortType;

    @ApiModelProperty(value = "排序，0=顺序，1=倒序")
    private Integer sort;
}
