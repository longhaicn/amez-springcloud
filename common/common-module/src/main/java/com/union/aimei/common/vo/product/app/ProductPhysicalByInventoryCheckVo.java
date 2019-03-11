package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 产品库存检查
 *
 * @author liurenkai
 * @time 2018/3/5 10:53
 */
@Data
@EqualsAndHashCode
@ApiModel("产品库存检查")
public class ProductPhysicalByInventoryCheckVo implements Serializable {

    @ApiModelProperty("产品库存集合")
    private List<PhysicalByInventoryVo> physicalInventoryList;

}
