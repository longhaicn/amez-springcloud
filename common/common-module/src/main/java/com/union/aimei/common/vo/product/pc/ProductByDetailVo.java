package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品详情查询条件
 *
 * @author liurenkai
 * @time 2018/4/10 18:25
 */
@Data
@EqualsAndHashCode
@ApiModel("商品详情查询条件")
public class ProductByDetailVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;


}
