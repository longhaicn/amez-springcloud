package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GaoWei
 * @time 2018/7/12 14:39
 * @description
 */
@Data
@ApiModel
public class QueryNewAddOrder {

    @ApiModelProperty(value = "店铺ID")
    private int storeId;
    @ApiModelProperty(value = "查询对象类型，0:平台，1：店铺")
    private int type;
    @ApiModelProperty(value = "天数")
    private int days;
    @ApiModelProperty(value = "查询时间类型",notes = "查询类型：0：当天 ，1：当周，2：当月")
    private int query;


}
