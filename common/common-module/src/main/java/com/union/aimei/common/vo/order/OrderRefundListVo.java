package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author GaoWei
 * @describe 退款订单列表VO
 * @time 2018/4/24,10:06
*/
@Data
@ApiModel(value = "退款订单列表VO")
public class OrderRefundListVo {

    @ApiModelProperty(value = "订单ID")
    private int orderId;
    @ApiModelProperty(value = "订单退款ID")
    private int orderReturnId;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "订单类型")
    private int orderType;
    @ApiModelProperty(value = "服务项目名称")
    private String productName;
    @ApiModelProperty(value = "应付金额")
    private int needPay;
    @ApiModelProperty(value = "退款金额")
    private int refund;
    @ApiModelProperty(value = "申请时间")
    private Date applyTime;
    @ApiModelProperty(value = "退款状态")
    private int returnStatus;
}
