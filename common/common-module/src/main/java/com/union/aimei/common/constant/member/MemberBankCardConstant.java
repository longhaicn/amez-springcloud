package com.union.aimei.common.constant.member;

/**
 * @author houji
 * @describe 会员相关常量类
 * @time 2017/12/12,17:53
 */
public class MemberBankCardConstant {

    /**
     * 会员银行卡实名验证
     */
    public static class AuthMemberBankCard {
        /**
         * 参数错误
         */
        public static final Integer PARAM_ERROR = 0;
        /**
         * 会员银行卡第三方验证信息不匹配
         */
        public static final Integer BANK_THIRD_ERROR = 2;
        /**
         * 该银行卡号已经实名制验证，不可重复添加
         */
        public static final Integer BANK_AUTH_READY = 3;
    }

}
