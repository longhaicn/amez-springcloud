package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 产品库存批量
 *
 * @author liurenkai
 * @time 2018/3/16 15:54
 */
@Data
@EqualsAndHashCode
@ApiModel("产品库存批量")
public class ProductPhysicalByInventoryByBatchVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("产品库存集合")
    private List<PhysicalByInventoryVo> inventoryList;
}
