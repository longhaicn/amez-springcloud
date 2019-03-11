package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 修改订单预约时间VO
 *
 * @author gaowei
 * @time 2018/8/24 10:03
 */
@Data
@ApiModel(value = "修改订单预约时间VO")
public class UpdateAppointmentTimeVo {

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;

    @ApiModelProperty(value = "美容师ID")
    private Integer beauticianId;

    @ApiModelProperty(value = "开始预约时间")
    private String startTime;

    @ApiModelProperty(value = "结束预约时间")
    private String endTime;

}
