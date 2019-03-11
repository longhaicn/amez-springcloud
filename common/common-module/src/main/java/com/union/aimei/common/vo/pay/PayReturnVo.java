package com.union.aimei.common.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 支付返回VO
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@ApiModel(value = "支付返回VO")
@Builder
@Data
@ToString
public class PayReturnVo {

    /**
     * 支付用途常量
     */
    public static class PayUseType {
        /**
         * 项目购买
         */
        public static final int PRODUCT = 0;
        /**
         * 实物产品购买
         */
        public static final int GOODS = 1;
        /**
         * 课程购买
         */
        public static final int LESSONS = 2;
        /**
         * 活动支付
         */
        public static final int ACTIVITY = 3;
    }

    @ApiModelProperty(value = "支付用途(0:项目购买，1：实物产品购买，2：课程购买，3：活动支付)")
    private int payUseType;
    @ApiModelProperty(value = "商户订单号")
    private String orderNo;
    @ApiModelProperty(value = "支付流水号")
    private String tradeNo;
    @ApiModelProperty(value = "支付类型(1:支付宝，2：微信，3：会员卡，4：一卡通，5：余额)")
    private Integer payType;
    @ApiModelProperty(value = "实际支付金额")
    private int amountPay;
    @ApiModelProperty(value = "减免金额")
    private int reduceAmount;
    @ApiModelProperty(value = "一卡通支付折扣")
    private int oneCardDiscount;


}
