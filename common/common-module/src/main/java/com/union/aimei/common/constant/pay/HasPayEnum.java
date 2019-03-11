package com.union.aimei.common.constant.pay;

/**
 * @author GaoWei
 * @time 2018/5/24 19:53
 * @description 订单已支付Redis的Key
 */
public enum HasPayEnum {

    /**
     * 支付成功KEY
     */
    PAY_SUCCESS_KEY("支付成功KEY", "PAY_SUCCESS"),
    /**
     * 支付成功HASHKEY
     */
    PAY_SUCCESS_HASH_KEY("支付成功HASHKEY", "PAY_ORDER_"),
    /**
     * 支付补偿KEY
     */
    PAY_COMPENSATE_KEY("支付补偿KEY", "PAY_COMPENSATE"),
    /**
     * 支付补偿HASHkey
     */
    PAY_COMPENSATE_HASH_KEY("支付补偿HASHkey", "COMPENSATE_ORDER_");

    private String name;
    private String value;

    HasPayEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
