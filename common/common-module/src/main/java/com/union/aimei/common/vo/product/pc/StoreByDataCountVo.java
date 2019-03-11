package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺数据统计
 *
 * @author liurenkai
 * @time 2018/4/20 13:49
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺数据统计")
public class StoreByDataCountVo implements Serializable {

    /**
     * 统计类型，0-所有店铺
     */
    public static final int TYPE_ALL = 0;

    /**
     * 统计类型，1-指定店铺
     */
    public static final int TYPE_STORE = 1;

    @ApiModelProperty("统计类型，0-所有店铺，1-指定店铺")
    private Integer type;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("统计天数")
    private Integer days;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty("实名状态，0-待提交，1-待审核，2-审核通过，3-审核不通过")
    private Integer realNameStatus;

}
