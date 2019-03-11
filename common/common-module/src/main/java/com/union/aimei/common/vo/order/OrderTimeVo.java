package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
*@author GaoWei
*descrption:
*time  2018/1/14 16:15
*/
@ApiModel
@Data
@EqualsAndHashCode
public class OrderTimeVo {
    @ApiModelProperty(value = "服务开始时间")
    private Date serverStartTime;
    @ApiModelProperty(value = "服务结束时间")
    private Date serverEndTime;
}
