package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author GaoWei
 * @describe 美容师预约看板订单简介
 * @time 2017/12/27,11:32
*/
@Data
@EqualsAndHashCode
public class BeauticianOrder {

    @ApiModelProperty(value = "服务开始时间")
    private Date serverStartTime;
    @ApiModelProperty(value = "服务结束时间")
    private Date serverEndTime;
    @ApiModelProperty(value = "服务类型0到店，1：上门")
    private Byte type;
    @ApiModelProperty(value = "产品名称")
    private  String productName;
    @ApiModelProperty(value = "状态，0:未开始，1：进行中，2：已完成")
    private int status;
}
