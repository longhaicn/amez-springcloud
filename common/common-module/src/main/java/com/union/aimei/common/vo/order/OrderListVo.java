package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author GaoWei
 * @describe 订单VO
 * @time 2018/1/24,16:45
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "订单列表VO")
public class OrderListVo {

    @ApiModelProperty(value = "订单ID")
    private Integer id;
    @ApiModelProperty("店铺名称")
    private String storeName;
    @ApiModelProperty(value = "店铺电话")
    private String storePhone;
    @ApiModelProperty(value = "订单来源(0:APP商城,1:微信商城)")
    private Integer orderSource;
    @ApiModelProperty("订单类型 0.到店服务订单 1.上门服务订单")
    private Integer type;
    @ApiModelProperty("订单编号")
    private String orderNo;
    @ApiModelProperty("订单状态0：待付款;1:交易关闭;2:待服务;4:服务中;5:待评价;6:评价完成")
    private Integer status;
    @ApiModelProperty(value = "上门费")
    private Integer freight;

    @ApiModelProperty("订单总金额")
    private Integer amountTotal;
    @ApiModelProperty(value = "应付金额")
    private Integer needPay;
    @ApiModelProperty("实际支付金额")
    private Integer amountPay;


    @ApiModelProperty(value = "订单退款状态0：未申请，1：已申请，2：退款完成，3：退款失败")
    private Integer returnStatus;

    @ApiModelProperty("会员手机号码")
    private String phone;

    @ApiModelProperty("会员姓名")
    private String memberRealName;

    @ApiModelProperty("会员昵称")
    private String memberNickName;


    @ApiModelProperty(value = "上门顾客姓名")
    private String customerName;
    @ApiModelProperty(value = "上门顾客电话")
    private String customerPhone;


    @ApiModelProperty("下单时间")
    private Date addTime;
    @ApiModelProperty("支付时间")
    private Date payTime;


    @ApiModelProperty("商品单价或加钱购金额")
    private Integer productPrice;

    @ApiModelProperty("商品名称")
    private String productName;
    @ApiModelProperty("产品图片")
    private String productImg;

}
