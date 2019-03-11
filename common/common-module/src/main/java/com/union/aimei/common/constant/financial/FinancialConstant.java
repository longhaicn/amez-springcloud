package com.union.aimei.common.constant.financial;

/**
 * 财务统计常量
 *
 * @author caizhaoming
 * @create 2018-06-07 18:12
 **/
public class FinancialConstant {


    public static final int ERROR_CODE = 201;

    public interface Query {
        int DUPLICATE_NUMBER = 201;
        int ERROR_NUMBE = 5001;
        String ORDER_NUMBER_CANNOT_BE_EMPTY = "订单编号不能为空";
        String TRANSACTION_TYPE_CANNOT_BE_EMPTY = "交易类型不能为空";
        String SAVE_STREAM_ERRORS_DUPLICATE_DATA = "保存流水错误，数据重复";
        String MEMBERS_DID_NOT_IMPLEMENT_REAL_NAME_SYSTEM = "会员没有进行实名制";
        String THE_BEAUTICIAN_USER_WAS_NOT_FOUND = "未找到该美容师用户";
        String THE_BEAUTICIAN_RUNNING_WATER_IS_EMPTY = "美容师流水为空";
        String THE_ORDER_BASE_IS_EMPTY = "订单信息为空";
        String WITHDRAW = "提现";
        String WITHDRAWAL_AMOUNT_IS_INSUFFICIENT = "提现金额不足";
        String NO_COMMISSION = "佣金获取不到";
        String THE_ORDER_WAS_NOT_FOUND = "未找到该服务订单。";
        String SELECT_NULL = "查询的数据为空";
    }

    public interface Param {
        int ERROR_CODE = 500;
        String NOT_MEMBERID = "memberId不能为空";
        String NOT_BEAUTICIANID = "beauticianId不能为空";
        String NOT_WITHDRAWAMOUNT = "withdrawAmount不能为空";
        String NOT_BANKCARDID = "bankCardId不能为空";
        String NOT_CASH = "提现金额不能为空";
        String MEMBERS_ARE_NOT_REGISTERED = "会员没有进行实名制";
    }

    public static class Update {
        public static final String BIND_THE_ACCOUNT_OPENING_BANK_FIRST = "请先绑定开户银行";
        public static final String LINE_NUMBER_INITIALIZATION_EXCEPTION = "流水单号初始化异常";
        public static final String UNABLE_TO_CONFIRM_RECONCILIATION = "无法进行对账确认，状态错误";
        public static final String ID_ERROR = "id错误，查无数据";

    }

}
