package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GaoWei
 * @time 2018/5/30 20:14
 * @description
 */
@Data
@ApiModel(value = "店铺不同状态订单统计类")
public class StoreTodayOrderCount {

    @ApiModelProperty(value = "店铺ID")
    private int storeId;
    @ApiModelProperty(value = "订单状态")
    private int status;
    @ApiModelProperty(value = "订单数量")
    private int num;

}
