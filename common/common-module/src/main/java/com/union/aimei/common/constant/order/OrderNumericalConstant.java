package com.union.aimei.common.constant.order;

/**
 * @author GaoWei
 * @Date 18-8-13 上午10:57
 * @description 订单数值常量类
 */
public enum OrderNumericalConstant {

    /**
     * 项目订单长度固定位数
     */
    MAX_ORDER_LEN(24, "项目订单长度固定位数"),
    /**
     * 申请退款的最大次数
     */
    MAX_REFUND_COUNT(4, "申请退款的最大次数");

    private int value;

    private String des;

    OrderNumericalConstant(int value, String des) {
        this.value = value;
        this.des = des;
    }

    public int getValue() {
        return value;
    }

    public String getDes() {
        return des;
    }
}
