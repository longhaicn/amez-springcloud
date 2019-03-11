package com.union.aimei.remote.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author GaoWei
 * @describe 订单交易模型
 * @time 2018/1/10,14:46
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "支付请求参数")
public class TradeVo implements Serializable{

    /**
     * 交易类型常量
     */
    public static class TradeType{
        /**
         * 项目交易
         */
        public static final int PRODUCT=0;
        /**
         * 会员卡购卡
         */
        public static final int BUY_CARD=1;
        /**
         * 会员卡充值
         */
        public static final int RECHARGE_CARD=2;
        /**
         * 实物产品购买
         */
        public static final int BUY_GOODS=3;
        /**
         * 课程购买
         */
        public static final int BUY_LESSSONS=4;
        /**
         * 活动参与
         */
        public static final int BUY_ACTIVITY=5;
    }

    /**
     * 支付类型常量
     */
    public static class PayType{
        /**
         * 微信支付
         */
        public static final int WX_PAY = 0;
        /**
         * 支付宝支付
         */
        public static final int ALI_PAY = 1;
        /**
         * 会员卡支付
         */
        public static final int MEMBER_CARD_PAY = 2;
        /**
         * 一卡通支付
         */
        public static final int ONE_CARD_PAY = 3;
        /**
         * 余额支付
         */
        public static final int BANLANCE_PAY = 4;
    }

    /**
     * 使用客户端常量
     */
    public static class UseType{
        /**
         * 用户端
          */
        public static final int CUSTOMER = 0;
        /**
         * 美容师端
         */
        public static final int BEAUTICIAN = 1;
        /**
         * 店长端
         */
        public static final int STORE_SELLER = 2;
    }

    @ApiModelProperty(value = "使用端号。0：用户端，1：美容师端，2：店长端",dataType = "0")
    private Integer useType=0;
    @ApiModelProperty(value = "订单编号",required = true)
    private String orderNo;
    @ApiModelProperty(value = "交易类型(0:项目交易，1：会员卡购卡，2：会员卡充值,3:实物产品交易,4:课程配置，5：活动支付)",required = true)
    private Integer tradeType=0;
    @ApiModelProperty(value = "支付方式(0:微信支付，1：支付宝，2:会员卡,3:一卡通支付,4:余额支付)",required = true)
    private Integer payType;
    @ApiModelProperty(value = "交易金额")
    private Integer amountTotal;
    @ApiModelProperty(value = "商品名称")
    private String productName;
    @ApiModelProperty(value = "艾美用户ID")
    private Integer amUserId;
    @ApiModelProperty(value = "艾美一卡通ID")
    private Integer amPayCardId;
    @ApiModelProperty(value = "支付密码")
    private String payPassword;
    @ApiModelProperty(value = "会员UUID")
    private String uuid;
}
