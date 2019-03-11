package com.union.aimei.common.constant.pay;

/**
 * @author GaoWei
 * @Date 18-8-13 上午11:09
 * @description 支付方式枚举类
 */
public enum PayTypeEnum {

    /**
     * 支付宝支付
     */
    ALI_PAY("alipay", "支付宝支付"),
    /**
     * 微信支付
     */
    WX_PAY("wxpay", "微信支付"),
    /**
     * 会员卡支付
     */
    MEMBER_CARD_PAY("memberCardPay", "会员卡支付"),
    /**
     * 余额支付
     */
    BALANCE_PAY("balancePay", "余额支付"),
    /**
     * 一卡通
     */
    ONE_CARD_PAY("oneCardPay", "一卡通");

    private String name;
    private String des;

    PayTypeEnum(String name, String des) {
        this.name = name;
        this.des = des;
    }


    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }
}
