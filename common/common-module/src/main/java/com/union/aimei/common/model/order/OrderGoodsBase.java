package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 实物订单表
 *
 * @author gaowei
 * @time 2018/8/24 10:02
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "实物订单表")
public class OrderGoodsBase {

    @ApiModelProperty("实物订单id")
    private Integer id;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("第三方交易流水号 如：微信支付流水号")
    private String tradeNo;

    @ApiModelProperty("订单状态0：待付款;1:待发货,2:待收货,3:已收货")
    private Integer status;

    @ApiModelProperty("商品总数量")
    private Integer nums;

    @ApiModelProperty("订单总金额")
    private Integer amountTotal;

    @ApiModelProperty("支付方式  wxpay、alipay，memberCardPay,oneCardPay,balancePay")
    private String payType;

    @ApiModelProperty("实际支付金额")
    private Integer amountPay;

    @ApiModelProperty("支付时间")
    private Date payTime;

    @ApiModelProperty("美容师所属门店ID")
    private Integer beauticianBelongStoreId;

    @ApiModelProperty("美容师所属门店名称")
    private String beauticianBelongStoreName;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("美容师类型(0:店长，1：兼职员工)")
    private Byte beauticianType;

    @ApiModelProperty("美容师手机号码")
    private String beauticianPhone;

    @ApiModelProperty("美容师姓名")
    private String beauticianRealName;

    @ApiModelProperty("美容师昵称")
    private String beauticianNickName;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("收货地址号码")
    private String addressPhone;

    @ApiModelProperty("收货人姓名")
    private String addressReveiver;

    @ApiModelProperty("收货地址所在省市县地区信息")
    private String addressRegson;

    @ApiModelProperty("下单时间")
    private Date addTime;

    @ApiModelProperty("邮费")
    private Integer postage;

    @ApiModelProperty("快递公司编码")
    private String expressCompanyCode;

    @ApiModelProperty("快递公司名称")
    private String expressCompanyName;

    @ApiModelProperty("发货单号")
    private String deliveryOrderNo;

    @ApiModelProperty("发货时间")
    private Date deliveryTime;

    @ApiModelProperty("确认收货时间")
    private Date receiveTime;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    private static final long serialVersionUID = 1L;

}
