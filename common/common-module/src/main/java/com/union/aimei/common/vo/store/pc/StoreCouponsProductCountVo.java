package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺优惠券列表和统计商品数量查询条件
 *
 * @author czm
 * @version 1.0
 * @create 2018-04-18 14:34
 **/
@Data
@EqualsAndHashCode
@ApiModel("店铺优惠券列表和统计商品数量查询条件")
public class StoreCouponsProductCountVo implements Serializable {

    @ApiModelProperty("生效时间")
    private String beginTime;

    @ApiModelProperty("过期时间")
    private String endTime;

    @ApiModelProperty("查询名称")
    private String searchName;

    @ApiModelProperty("查询类型 1查询发券名字 2查询发券店铺")
    private Integer searchType;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Integer isEnabled;

    @ApiModelProperty("优惠券状态，0-未开始，1-活动中，2-已结束")
    private Integer couponStatus;

    @ApiModelProperty("店铺ID")
    private Integer storeId;




}
