package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 店铺优惠券vo
 *
 * @author liurenkai
 * @time 2017/12/21 17:58
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺优惠券vo")
public class StoreCouponsVo {

    @ApiModelProperty(value = "店铺优惠券")
    private StoreCoupons storeCoupons;

    @ApiModelProperty(value = "优惠券-服务-关联集合")
    private List<StoreCouponsProduct> storeCouponsProductList;

}
