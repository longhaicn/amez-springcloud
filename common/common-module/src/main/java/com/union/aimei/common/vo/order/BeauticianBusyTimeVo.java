package com.union.aimei.common.vo.order;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

/**
*@author GaoWei
*descrption:
*time  2018/1/14 16:13
*/
@Data
@EqualsAndHashCode
public class BeauticianBusyTimeVo {
    @ApiModelProperty(value = "美容师ID")
    private Integer beauticianId;

    @ApiModelProperty(value = "订单工作时段")
    private Set<OrderTimeVo> orderTimeVoSet=new HashSet<>();
}
