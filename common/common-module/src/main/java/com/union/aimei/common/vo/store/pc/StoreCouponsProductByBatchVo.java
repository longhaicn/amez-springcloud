package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.StoreCouponsProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 批量优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2018/5/2 18:48
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel("批量优惠券-服务-关联")
public class StoreCouponsProductByBatchVo implements Serializable {

    public StoreCouponsProductByBatchVo(List<StoreCouponsProduct> storeCouponsProductList) {
        this.storeCouponsProductList = storeCouponsProductList;
    }

    @ApiModelProperty("优惠券-服务-关联集合")
    private List<StoreCouponsProduct> storeCouponsProductList;

}
