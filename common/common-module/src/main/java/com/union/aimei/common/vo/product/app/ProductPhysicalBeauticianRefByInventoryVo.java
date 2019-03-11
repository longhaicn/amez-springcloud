package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 产品-美容师-关联库存
 *
 * @author liurenkai
 * @time 2018/3/3 17:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("产品-美容师-关联库存")
public class ProductPhysicalBeauticianRefByInventoryVo extends ProductByInventoryVo {

    @ApiModelProperty("产品ID")
    private Integer productPhysicalId;

    @ApiModelProperty("产品数")
    private Integer physicalNumber;

}
