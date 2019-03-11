package com.union.aimei.common.constant.pay;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/27,14:47
*/
public class PayConstant {

    public static final Integer INOVKE_WXPAY_FAIL=1001;
    public static final String INOVKE_WXPAY_FAIL_MSG="调用微信信息失败";
    public static final int PAY_FAIL = 1000;
    public static final String PAY_FAIL_MSG = "支付失败";
    public static final int INVOKE_WEIXIN_PAY_FAIL = 1001;
    public static final String INVOKE_WEIXIN_PAY_FAIL_MSG = "调用微信支付失败";
    public static final int INVOKE_ALI_PAY_FAIL = 1002;
    public static final String INVOKE_ALI_PAY_FAIL_MSG = "调用支付宝支付失败";
    public static final int TRADE_TYPE_ERROR = 1003;
    public static final String TRADE_TYPE_ERROR_MSG = "交易或支付类型错误";
    public static final int TRADE_AMOUNT_ERROR = 1004;
    public static final String TRADE_AMOUNT_ERROR_MSG = "交易金额不正确";
    public static final int TRADE_PARAMS_ERROR=1005;
    public static final String TRADE_PARAMS_ERROR_MSG = "交易参数不正确";
    public static final Integer REQUEST_AM_TOKEN_FAIL=1006;
    public static final String  REQUEST_AM_TOKEN_FAIL_MSG="申请艾美商城token失败";
    public static final Integer INVOKE_AM_INTERFACE_FAIL=1008;
    public static final String  INVOKE_AM_INTERFACE_FAIL_MSG="调用艾美接口失败";
    public static final Integer GET_PAYRESULT_FAIL=1009;
    public static final String  GET_PAYRESULT_FAIL_MSG="获取交易结果失败";
    public static final Integer GET_PAYRECOD_FAIL=1010;
    public static final String  GET_PAYRECOD_FAIL_MSG="获取支付记录失败";
    public static final Integer GET_AMORDERINFO_FAIL=1011;
    public static final String  GET_AMORDERINFO_FAI_MSG="创建艾美平台订单失败";
    public static final Integer GET_ORDER_INFO_FAIL=1012;
    public static final String  GET_ORDER_INFO_FAIL_MSG="获取订单信息失败";
    public static final Integer AM_PAY_FAIL=1013;
    public static final String  AM_PAY_FAIL_MSG="艾美平台支付失败";
    public static final Integer REPEAT_PAY=1014;
    public static final String  REPEAT_PAY_MSG="请勿重复支付";

}
