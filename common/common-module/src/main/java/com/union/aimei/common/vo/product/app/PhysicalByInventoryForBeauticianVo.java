package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 产品库存（美容师）
 *
 * @author liurenkai
 * @time 2018/3/16 16:34
 */
@Data
@EqualsAndHashCode
@ApiModel("产品库存（美容师）")
public class PhysicalByInventoryForBeauticianVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("产品库存集合")
    private List<PhysicalByInventoryVo> inventoryList;

}
