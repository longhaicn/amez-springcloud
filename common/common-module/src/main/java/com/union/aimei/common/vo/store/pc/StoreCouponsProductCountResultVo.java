package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺优惠券列表和统计商品数量返回结果
 *
 * @author czm
 * @version 1.0
 * @create 2018-04-18 14:09
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺优惠券列表和统计商品数量返回结果")
public class StoreCouponsProductCountResultVo implements Serializable {


    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("优惠券名称")
    private String couponName;

    @ApiModelProperty("优惠金额")
    private Integer discountAmount;

    @ApiModelProperty("满足金额")
    private Integer meetAmount;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("支持服务项目数量")
    private Integer productCount;

    @ApiModelProperty("优惠券状态，0-未开始，1-活动中，2-已结束")
    private Integer couponStatus;

    @ApiModelProperty("创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
