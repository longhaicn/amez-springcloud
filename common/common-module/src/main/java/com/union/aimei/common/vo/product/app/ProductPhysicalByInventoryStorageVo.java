package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 产品库存入库
 *
 * @author liurenkai
 * @time 2018/3/5 13:37
 */
@Data
@EqualsAndHashCode
@ApiModel("产品库存入库")
public class ProductPhysicalByInventoryStorageVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("产品库存集合")
    private List<PhysicalByInventoryVo> physicalInventoryList;

}
