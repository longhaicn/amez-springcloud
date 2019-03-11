package com.union.aimei.common.constant.order;

/**
 * @author GaoWei
 * @describe 订单模块常量类
 * @time 2017/12/9,11:12
 */
public class OrderConstant {


    public static final Integer INVOKE_KD100_FAIL = 1000;
    public static final String INVOKE_KD100_FAIL_MSG = "调用快递100接口失败";
    public static final Integer QUERY_ORDER_IS_NOT_EXSIT = 1001;
    public static final String QUERY_ORDER_IS_NOT_EXSIT_MSG = "订单不存在，无法提供物流信息";
    public static final Integer UNKNOWN_ORDER_CPMMENT_TYPE = 1002;
    public static final String UNKNOWN_ORDER_CPMMENT_TYPE_MSG = "未知的订单评论类型";
    public static final Integer HAS_COMMENT = 1003;
    public static final String HAS_COMMENT_MSG = "请勿重复评价";
    public static final Integer HAS_REPLY = 1004;
    public static final String HAS_REPLY_MSG = "请勿重复回复";
    public static final Integer BEYOND_UPDATE_COUNT = 1005;
    public static final String BEYOND_UPDATE_COUNT_MSG = "已超过最大修改次数";
    public static final Integer HAS_NOT_COMMENT = 1006;
    public static final String HAS_NOT_COMMENT_MSG = "用户评价已删除";


    /**
     * 基础
     */
    public static class Base {
        public static final int ORDER_ISNOT_EXSIT = 0001;
        public static final String ORDER_ISNOT_EXSIT_MSG = "查询不到订单信息";
        public static final int MEMBER_CARD_PAY_FAIL = 0002;
        public static final String MEMBER_CARD_PAY_FAIL_MSG = "会员卡支付失败";
        public static final int IS_NOT_STORE_OWNER = 0003;
        public static final String IS_NOT_STORE_OWNER_MSG = "验证失败,您不具备店长资格";
        public static final int IS_NOT_ORDER_BEAUTICIN = 0004;
        public static final String IS_NOT_ORDER_BEAUTICIN_MSG = "验证失败,您不是订单美容师";
        public static final int ORDER_STATUS_ERROR = 0004;
        public static final String ORDER_STATUS_ERRORN_MSG = "订单交易关闭或已付款";
        public static final int UPDATE_ORDER_STATUS_FAIL = 0005;
        public static final String UPDATE_ORDER_STATUS_FAIL_MSG = "支付成功修改订单状态失败";
        public static final int IS_NOT_ORDER_OSTORE_OWNER = 0006;
        public static final String IS_NOT_ORDER_OSTORE_OWNER_MSG = "验证失败,您不是该店店长";

    }

    /**
     * 请求参数检查
     */
    public static class Check {
        public static final int STORE_ISNOT_EXSIT = 1001;
        public static final String STORE_ISNOT_EXSIT_MSG = "店铺不存在";
        public static final int PRODUCT_ISNOT_EXSIT_OR_OFFSHELF = 1002;
        public static final String PRODUCT_ISNOT_EXSITOR_OFFSHELF_MSG = "商品已下架";
        public static final int BEAUTICAIN_ISNOT_EXSIT = 1003;
        public static final String BEAUTICAIN_ISNOT_EXSIT_MSG = "查询店铺美容师信息失败";
        public static final int MEMBERCARD_ISNOT_EXSIT = 1004;
        public static final String MEMBERCARD_ISNOT_EXSIT_MSG = "用户会员卡不存在";
        public static final int ORDER_AMOUNT_ERROR = 1005;
        public static final String ORDER_AMOUNT_ERROR_MSG = "订单金额不正确";
        public static final int GET_ORDERBASE_FAIL = 1006;
        public static final String GET_ORDERBASE_FAIL_MSG = "获取订单基础信息失败";
        public static final int TYPE_LOST = 1007;
        public static final String TYPE_LOST_MSG = "请输入员工类型";
        public static final int QUERY_MEMBER_FAIL = 1008;
        public static final String QUERY_MEMBER_FAIL_MSG = "查询会员信息失败";
        public static final int CUSTOMER_ADDRESS_IS_NULL = 1009;
        public static final String CUSTOMER_ADDRESS_IS_NULL_MSG = "服务上门地址为空";
        public static final int ANCHORED_STOREID_IS_NULL = 1009;
        public static final String ANCHORED_STOREID_IS_NULL_MSG = "挂靠店铺ID不能为空";
        public static final int BEAUTICIAN_HAS_NO_ANCHORED_STOREID = 1010;
        public static final String BEAUTICIAN_HAS_NO_ANCHORED_STOREID_MSG = "美容师没有挂靠门店";
        public static final int BEAUTICIAN_HAS_NO_ACCESS_TO_BUY = 1011;
        public static final String EAUTICIAN_HAS_NO_ACCESS_TO_BUY_MSG = "美容师没有权限购买";
        public static final int GOODS_IS_NOT_ENOUGH = 1011;
        public static final String GOODS_IS_NOT_ENOUGH_MSG = "实物产品库存不足";
        public static final int REPEAT_INSER_ORDER_RETURN = 1012;
        public static final String REPEAT_INSER_ORDER_RETURN_MSG = "已提交退款申请，请勿重复提交";
        public static final int REPEAT_AUDIT = 1013;
        public static final String REPEAT_AUDIT_MSG = "请勿重复审核";


    }

    /**
     * 调用服务状态
     */
    public static class RemoteInvoke {
        public static final int INVOKE_FAIL = 2001;
        public static final String INVOKE_FAIL_MESSAGE = "网络异常，请稍后重试";
        public static final int INVOKE_STORE_COUPONS_FAIL = 2002;
        public static final String INVOKE_STORE_COUPONS_FAIL_MESSAGE = "网络异常，请稍后重试";
        public static final int INVOKE_MEMBERCARDREF_FAIL = 2003;
        public static final String INVOKE_MEMBERCARDREF_FAIL_MESSAGE = "网络异常，请稍后重试";
        public static final int INVOKE_STOREBEAUTICIAN_FAIL = 2004;
        public static final String INVOKE_STOREBEAUTICIAN_FAIL_MESSAGE = "网络异常，请稍后重试";
        public static final int INVOKE_MEMBER_FAIL = 2005;
        public static final String INVOKE_MEMBER_FAIL_MESSAGE = "网络异常，请稍后重试败";
        public static final int INVOKE_GOODS_FAIL = 2006;
        public static final String INVOKE_GOODS_FAIL_MESSAGE = "网络异常，请稍后重试";

    }


    /**
     * 添加状态
     */
    public static class Insert {
        public static final int ORDER_BASE_FAIL = 2001;
        public static final String ORDER_BASE_FAIL_MSG = "添加订单信息失败";
    }

    /**
     * 数据查询结果
     */
    public static class Query {
        public static final int EMPTY = 5001;
        public static final String EMPTY_MSG = "查询订单为空";
        public static final int PRODUCT_EMPTY = 5002;
        public static final String PRODUCT_EMPTY_MSG = "查询订单商品为空";
        public static final int IS_NOT_PAY = 5003;
        public static final String IS_NOT_PAY_MSG = "订单未付款，无法退款";
        public static final int IS_SEVICE = 5004;
        public static final String IS_SEVICE_MSG = "订单已消费，无法退款";
        public static final int HAS_REFUENED = 5005;
        public static final String HAS_REFUENED_MSG = "订单已退款,请求重复申请";
        public static final int CAN_NOT_VERIFY = 5006;
        public static final String CAN_NOT_VERIFY_MSG = "订单无法验证，未付款或者交易未完成";
        public static final int VERIFY_CODE_ERROR = 5007;
        public static final String VERIFY_CODE_ERROR_MSG = "订单验证码错误";
        public static final int REPEAT_VERIFY_CODE_ERROR = 5008;
        public static final String REPEAT_VERIFY_CODE_ERROR_MSG = "请勿重复验证订单";
        public static final int REPEAT_REFUND_ORDER = 5009;
        public static final String REPEAT_REFUND_ORDER_MSG = "请勿重复申请退款订单";
        public static final int NO_MORE_ACCESS_REFUND_APPLICATION = 5010;
        public static final String NO_MORE_ACCESS_REFUND_APPLICATION_MSG = "已超过最大申请退款次数";
        public static final int IS_NOT_IN_REFUND = 5010;
        public static final String IS_NOT_IN_REFUND_MSG = "没有申请退款记录";
        public static final int HAS_NO_COMMENT = 5011;
        public static final String HAS_NO_COMMEN_MSG = "没有订单评论记录";

    }

    /**
     * 订单状态
     */
    public static class Status {
        /**
         * 订单状态：待付款
         */
        public static final Integer PENDING_PAYMENT = 0;
        /**
         * 订单状态：交易关闭
         */
        public static final Integer TRANSACTION_CLOSED = 1;
        /**
         * 订单状态：待服务
         */
        public static final Integer PENDING_SERVICE = 2;
        /**
         * 订单状态：服务中
         */
        public static final Integer IN_SERVICE = 3;
        /**
         * 订单状态：待评价
         */
        public static final Integer PENDING_EVALUATION = 4;
        /**
         * 订单状态：评价完成
         */
        public static final Integer EVALUATION_COMPLETION = 5;
    }

    /**
     * 订单类型
     */
    public static class Type {
        /**
         * 订单类型：到店服务
         */
        public static final Integer TO_SHOP = 0;
        /**
         * 订单类型：上门服务
         */
        public static final Integer TO_DOOR = 1;
    }

    /**
     * 订单支付类型
     */
    public static class PayType {
        /**
         * 支付方式：微信支付
         */
        public static final String WECHAT = "wxpay";
        /**
         * 支付方式：支付宝
         */
        public static final String ALIPAY = "alipay";
        /**
         * 支付方式：会员卡
         */
        public static final String MEMBER_CARD = "membercard";
    }

    /**
     * 退款状态
     */
    public static class Return {
        /**
         * 退退款状态：无申请
         */
        public static final Integer NO_APPLICATION = 0;
        /**
         * 退款状态：退款中
         */
        public static final Integer REFUNDING = 1;
        /**
         * 退款状态：退款完成
         */
        public static final Integer REFUND_COMPLETED = 2;
    }


}
