package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.StoreCoupons;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.sql.rowset.CachedRowSet;

/**
 * 店铺的店铺优惠券结果（会员）
 *
 * @author liurenkai
 * @time 2018/1/11 10:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "店铺的店铺优惠券结果（会员）")
public class StoreCouponsByMemberIdForStoreResultVo extends StoreCoupons {

    @ApiModelProperty("每人限领标记 1，正常，0，限领")
    private Boolean isPerPersonLimit;

}
