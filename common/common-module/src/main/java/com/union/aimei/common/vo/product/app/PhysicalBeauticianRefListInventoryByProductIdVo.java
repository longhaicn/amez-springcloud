package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 根据项目ID查询存在可消耗库存的美容师条件
 *
 * @author liurenkai
 * @time 2018/7/12 17:55
 */
@Data
@EqualsAndHashCode
@ApiModel("根据项目ID查询存在可消耗库存的美容师ID条件")
public class PhysicalBeauticianRefListInventoryByProductIdVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("美容师ID集合")
    private List<Integer> beauticanIdList;

}
