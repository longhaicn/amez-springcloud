package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺的优惠券(会员)
 *
 * @author liurenkai
 * @time 2018/1/11 10:43
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺的优惠券(会员)")
public class StoreCouponsByMemberIdForStoreVo implements Serializable {

    @ApiModelProperty(value = "会员ID")
    private Integer memberId;

    @ApiModelProperty(value = "店铺ID")
    private Integer storeId;

}
