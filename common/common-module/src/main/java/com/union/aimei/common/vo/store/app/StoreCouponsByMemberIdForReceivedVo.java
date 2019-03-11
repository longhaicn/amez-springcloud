package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 领取的店铺优惠券（会员）
 *
 * @author liurenkai
 * @time 2018/1/11 10:22
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "领取的店铺优惠券（会员）")
public class StoreCouponsByMemberIdForReceivedVo implements Serializable {

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("使用标记，1为正常，0为使用")
    private Integer isUsed;

    @ApiModelProperty("优惠券状态，0-未开始，1-活动中，2-已结束")
    private Integer couponStatus;

    @ApiModelProperty("优惠券状态list ，0-未开始，1-活动中，2-已结束")
    private List<Integer> couponStatusList;


}
