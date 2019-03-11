package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.StoreCoupons;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 领取的店铺优惠券结果（会员）
 *
 * @author liurenkai
 * @time 2018/1/11 10:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "领取的店铺优惠券结果（会员）")
public class StoreCouponsByMemberIdForReceivedResultVo extends StoreCoupons {

    @ApiModelProperty("使用标记，1为正常，0为使用")
    private Boolean isUsed;

}
