package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺（品牌ID）
 *
 * @author liurenkai
 * @time 2018/2/26 14:25
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺（品牌ID）")
public class StoreByBrandIdVo implements Serializable {

    @ApiModelProperty(value = "品牌ID")
    private Integer brandId;

    @ApiModelProperty(value = "城市ID集合")
    private List<Integer> cityIdList;

}
