package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量精选店铺
 *
 * @author liurenkai
 * @time 2018/4/19 17:50
 */
@Data
@EqualsAndHashCode
@ApiModel("批量精选店铺")
public class StoreBySelectBatchVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("店铺集合")
    private List<StoreBySelectVo> storeList;

}
