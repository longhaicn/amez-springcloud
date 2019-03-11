package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author GaoWei
 * @describe 订单管理-订单基础详情
 * @time 2018/1/29,10:42
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "订单基础VO")
public class OrderBaseVo {

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;
    @ApiModelProperty("订单来源(0：app商城，1：微信商城)")
    private Byte orderSource;
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    @ApiModelProperty(value = "订单状态")
    private Integer status;
    @ApiModelProperty("订单类型 0.到店服务订单 1.上门服务订单")
    private Integer type;
    @ApiModelProperty("第三方支付单号 如：微信支付流水号")
    private String tradeNo;
    @ApiModelProperty("支付方式  wxpay、alipay、balancePay、memberCardPay")
    private String payType;
    @ApiModelProperty("订单总金额")
    private Integer amountTotal;
    @ApiModelProperty("退换货和退款状态，0表示无申请，1退款中，2退款完成")
    private Integer returnStatus;
    @ApiModelProperty("会员卡减免金额")
    private Integer memberCardReduce;
    @ApiModelProperty("优惠券减免金额")
    private Integer couponReduce;
    @ApiModelProperty("减免总金额")
    private Integer amountReduce;
    @ApiModelProperty("支付金额")
    private Integer amountPay;
    @ApiModelProperty("提交订单时间")
    private Date addTime;
    @ApiModelProperty("支付时间")
    private Date payTime;
    @ApiModelProperty("服务开始时间")
    private Date serverStartTime;
    @ApiModelProperty("服务结束时间")
    private Date serverEndTime;
    @ApiModelProperty("退款时间")
    private Date returnTime;
    @ApiModelProperty("服务实际开始时间")
    private Date actualStartTime;
    @ApiModelProperty("服务实际结束时间")
    private Date actualEndTime;


}
