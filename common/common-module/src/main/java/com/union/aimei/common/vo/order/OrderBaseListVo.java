package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 订单列表VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@ApiModel(value = "订单列表VO")
public class OrderBaseListVo {

    @ApiModelProperty("订单id")
    private Integer id;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("门店电话")
    private String storePhone;

    @ApiModelProperty("店铺logo")
    private String storeLogo;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("第三方交易流水号 如：微信支付流水号")
    private String tradeNo;

    @ApiModelProperty("订单类型 0.到店服务订单 1.上门服务订单")
    private Integer type;

    @ApiModelProperty("订单状态,0：待付款;1:交易关闭;2:待服务;3:服务中;4:待评价;5:评价完成 ")
    private Integer status;
    @ApiModelProperty("商品总数量")
    private Integer nums;

    @ApiModelProperty("上门服务顾客姓名")
    private String customerName;

    @ApiModelProperty("上门服务顾客电话")
    private String customerPhone;

    @ApiModelProperty("上门服务顾客地址")
    private String customerAddress;

    @ApiModelProperty("上门顾客经度")
    private String customerLongitude;

    @ApiModelProperty("上门顾客地址纬度")
    private String customerLatitude;

    @ApiModelProperty("订单总金额")
    private Integer amountTotal;

    @ApiModelProperty("应付金额")
    private Integer needPay;

    @ApiModelProperty("上门服务费")
    private Integer freight;

    @ApiModelProperty("支付方式  wxpay、alipay，memberCardPay,oneCardPay,balancePay")
    private String payType;

    @ApiModelProperty("实际支付金额")
    private Integer amountPay;

    @ApiModelProperty("兑换总积分")
    private Integer point;

    @ApiModelProperty("支付时间")
    private Date payTime;

    @ApiModelProperty("退换货和退款状态，0表示无申请，1退款中，2退款完成，3：退款失败")
    private Integer returnStatus;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("用户手机号码")
    private String memberPhone;

    @ApiModelProperty("会员姓名")
    private String memberRealName;

    @ApiModelProperty("会员昵称")
    private String memberNickName;

    @ApiModelProperty("卡券id")
    private Integer cardId;

    @ApiModelProperty("卡券编号")
    private String cardCode;

    @ApiModelProperty("卡券类型名称")
    private String cardTypeName;

    @ApiModelProperty("优惠规则匹配减免金额")
    private Integer preferentialAmount;

    @ApiModelProperty("会员卡减免金额")
    private Integer memberCardReduce;

    @ApiModelProperty("优惠券减免金额")
    private Integer couponReduce;

    @ApiModelProperty("减免总金额")
    private Integer amountReduce;

    @ApiModelProperty("预约时间")
    private String appointmentTime;

    @ApiModelProperty("收货地址ID")
    private Integer addressId;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("手机号码")
    private String addressPhone;

    @ApiModelProperty("收货人姓名")
    private String addressReveiver;

    @ApiModelProperty("收货地址所在省市县地区信息")
    private String addressRegson;

    @ApiModelProperty("服务开始时间")
    private Date serverStartTime;

    @ApiModelProperty("服务结束时间")
    private Date serverEndTime;

    @ApiModelProperty("下单时间")
    private Date addTime;

    @ApiModelProperty("发货时间")
    private Date deliveryTime;

    @ApiModelProperty("确认收货时间")
    private Date receiveTime;

    @ApiModelProperty("退款时间")
    private Date returnTime;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("二维码")
    private String qrCode;

    @ApiModelProperty("验证码")
    private String verificationCode;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品名称")
    private String productImg;

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "顾客评论ID")
    private Integer commentId;

    @ApiModelProperty(value = "美容师回复ID")
    private Integer beauticianCommentId;
}
