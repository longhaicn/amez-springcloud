package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 计算运费
 *
 * @author liurenkai
 * @time 2018/3/14 14:01
 */
@Data
@EqualsAndHashCode
@ApiModel("计算运费")
public class ProductPhysicalByCalcFreightVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("产品库存集合")
    private List<PhysicalByInventoryVo> inventoryList;

}
