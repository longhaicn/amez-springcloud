package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author caizhaoming
 * @date 2018/04/27  17:06
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "根据新增的商品添加到优惠券与商品的关系表(传参)")
public class StoreCouponsProductParamVo implements Serializable {

    @ApiModelProperty("店铺id")
    private List<Integer> storeIdList;

    @ApiModelProperty("商品id")
    private Integer productId;

    @ApiModelProperty("商品名字")
    private String productName;

}
