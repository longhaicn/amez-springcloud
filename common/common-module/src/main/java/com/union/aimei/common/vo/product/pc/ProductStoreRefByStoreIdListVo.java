package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量门店list
 *
 * @author houji
 * @time 2018/2/27 10:28
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "批量店铺id集合")
public class ProductStoreRefByStoreIdListVo implements Serializable {

    @ApiModelProperty(value = "店铺Id集合")
    private List<Integer> storeIdList;

}
