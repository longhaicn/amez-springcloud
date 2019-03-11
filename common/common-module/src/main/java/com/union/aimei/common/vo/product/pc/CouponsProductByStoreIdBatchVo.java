package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量根据店铺ID新增优惠券-服务-关联
 *
 * @author caizhaoming
 * @date 2018/04/27  17:06
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "批量根据店铺ID新增优惠券-服务-关联")
public class CouponsProductByStoreIdBatchVo implements Serializable {

    @ApiModelProperty("商品")
    private Product product;

    @ApiModelProperty("店铺ID集合")
    private List<Integer> storeIdList;

}
