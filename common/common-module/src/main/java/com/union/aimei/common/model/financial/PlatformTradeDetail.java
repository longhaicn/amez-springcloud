package com.union.aimei.common.model.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value="平台交易流水")
public class PlatformTradeDetail implements Serializable {
    @ApiModelProperty("交易流水id")
    private Integer id;

    @ApiModelProperty("订单号")
    private String orderNumber;

    @ApiModelProperty("交易流水号")
    private String transactionSerialNumber;

    @ApiModelProperty("付款时间")
    private Date payTime;

    @ApiModelProperty("交易类型(1-服务订单，2-会员卡售卡,3-会员卡充值,4-退款")
    private Integer tradeType;

    @ApiModelProperty("交易状态:0-未完成,1-已完成")
    private Integer tradeStatus;

    @ApiModelProperty("订单金额")
    private Integer orderAmount;

    @ApiModelProperty("实付金额")
    private Integer actuallyAmount;

    @ApiModelProperty("美容师提成")
    private Integer beauticianCommission;

    @ApiModelProperty("门店净收入")
    private Integer storeNetIncome;

    @ApiModelProperty("结算金额")
    private Integer settlementAmount;

    @ApiModelProperty("平台佣金")
    private Integer platformCommission;

    @ApiModelProperty("支付方式:1-支付宝,2-微信,3-会员卡,4-一卡通,5-余额支付")
    private Integer payMethod;

    @ApiModelProperty("支付比率")
    private Integer payRate;

    @ApiModelProperty("结算时间")
    private Date settlementTime;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty("门店名字")
    private String storeName;

    @ApiModelProperty("店长电话")
    private String storePhone;

    @ApiModelProperty("门店老板")
    private String storeBboss;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("美容师名字")
    private String beauticianName;

    @ApiModelProperty("美容师电话")
    private String beauticianPhone;

    @ApiModelProperty("买家名字")
    private String buyersNickname;

    @ApiModelProperty("买家手机")
    private String buyersPhone;

    @ApiModelProperty("服务名称")
    private String serviceName;

    @ApiModelProperty("单价")
    private Integer unitPrice;

    @ApiModelProperty("优惠券优惠")
    private Integer coupons;

    @ApiModelProperty("会员卡优惠")
    private Integer membershipCardDiscount;

    @ApiModelProperty("一卡通优惠")
    private Integer oneCartoonPreferential;

    @ApiModelProperty("会员卡")
    private String membershiCard;

    @ApiModelProperty("卡内容")
    private String cardContent;

    @ApiModelProperty("面值")
    private Integer faceValue;

    @ApiModelProperty("售卡渠道奖励")
    private Integer sellCardChannelReward;

    @ApiModelProperty("总价")
    private Integer totalPrice;

    @ApiModelProperty("统计时间年份")
    private String statisticsYear;

    @ApiModelProperty("统计时间年份月份")
    private String statisticsYearMonth;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("备注")
    private String remarks;

    private static final long serialVersionUID = 1L;
}