package com.union.aimei.common.constant.financial;

/**
 * @author GaoWei
 * @time 2018/5/28 13:53
 * @description 佣金比例类型枚举类
 */
public enum CommissionEnum {

    /**
     * 平台佣金比例
     */
    PLATFORM("PTYJBL"),
    /**
     * 美容师提现手续费
     */
    MRSTISXF("MRSTISXF");


    private String type;

    CommissionEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
