package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2017/12/22 16:17
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺优惠券领取")
public class StoreCouponsReceived implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺优惠券ID")
    private Integer storeCouponsId;

    @ApiModelProperty("优惠券号码")
    private String couponNumber;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("使用商品ID")
    private Integer usedProductId;

    @ApiModelProperty("使用商品名称")
    private String usedProductName;

    @ApiModelProperty("使用时间")
    private Date usedTime;

    @ApiModelProperty("使用标记，1为正常，0为使用")
    private Boolean isUsed;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建会员ID")
    private Integer createMemberId;

    @ApiModelProperty("创建会员名称")
    private String createMemberName;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}