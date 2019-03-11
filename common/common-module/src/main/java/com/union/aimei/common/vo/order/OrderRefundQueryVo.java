package com.union.aimei.common.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 退款订单查询VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@ApiModel(value = "退款订单查询VO")
public class OrderRefundQueryVo {

    @ApiModelProperty(value = "订单退款ID")
    private Integer id;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "订单类型")
    private Integer orderType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "开始申请时间")
    private Date applyStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "结束申请时间")
    private Date applyEndTime;
    @ApiModelProperty(value = "退款状态")
    private Integer returnStatus;
}
