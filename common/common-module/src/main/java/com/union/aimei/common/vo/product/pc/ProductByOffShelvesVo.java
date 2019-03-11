package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品下架
 *
 * @author liurenkai
 * @time 2018/3/7 15:02
 */
@Data
@EqualsAndHashCode
@ApiModel("商品下架")
public class ProductByOffShelvesVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

}
