package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺数据统计结果
 *
 * @author liurenkai
 * @time 2018/4/20 14:01
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺数据统计结果")
public class StoreByDataCountResVo implements Serializable {

    @ApiModelProperty("待审核服务")
    private Integer pendingProductCount = 0;

    @ApiModelProperty("待审核员工")
    private Integer pendingBeauticianCount = 0;

    @ApiModelProperty("新增会员")
    private Integer addMemberCount = 0;

    @ApiModelProperty("新增店铺")
    private Integer addStoreCount = 0;

    @ApiModelProperty("新增服务")
    private Integer addProductCount = 0;

    @ApiModelProperty("新增会员卡")
    private Integer addMemberCardCount = 0;

    @ApiModelProperty("新增服务订单")
    private Integer addProductOrderCount = 0;

    @ApiModelProperty("新增售卡订单")
    private Integer addSaleCardOrderCount = 0;

    @ApiModelProperty("新增充值订单")
    private Integer addRechargeOrderCount = 0;

    @ApiModelProperty("交易额")
    private Integer turnoverCount = 0;

}
