package com.union.aimei.member.constant;

/**
*@author GaoWei
*descrption:
*time  2017/12/16 16:40
*/
public class MemberConstant {

    /**
     * 请求参数检查
     */
    public static class CheckRequestParam{
        public static  final int EMPTY=1001;
        public static  final String EMPTY_MSG="请求参数为空";
        public static  final int LOST=1002;
        public static  final String LOST_MSG="请求参数缺失";
    }

    /**
     * 会员卡
     */
    public static class MemberCard{
        public static  final int NOT_EXSIT=2001;
        public static  final String NOT_EXSIT_MSG="会员卡不存在";
    }

    public static class MemberCardTradeRecode{
        public static  final int AMOUNT_LESS=3001;
        public static  final String AMOUNT_LESS_MSG="可用余额不足，请充值";
    }

    public static class Cache{
        public static final Integer INSERT_TO_REDIS_FAIL=4001;
        public static final String INSERT_TO_REDIS_FAIL_MSG="添加数据到Redis失败";
    }

    /**
     * 远程调用
     */
    public static class Invoke{
        public static final Integer INVOKE_FAIL = 0001;
        public static final String INVOKE_FAIL_MSG = "调用艾美接口失败";
        public static final Integer WXMEMBER_INFO_FAIL = 0002;
        public static final String WXMEMBER_INFO_FAIL_MSG = "调用微信会员信息失败";
        public static final Integer VERIFY_PAYPASSWORD_ERROR = 0003;
        public static final String VERIFY_PAYPASSWORD_ERROR_MSG = "验证支付密码失败";

    }

    /**
     * 注册
     */
    public static class Register {
        public static final Integer REGISER_FAIL=1000;
        public static final String  REGISER_FAIL_MSG="注册失败，请重试";
        public static final Integer PARAMS_EMPTY = 1001;
        public static final String PARAMS_EMPTY_MSG = "注册参数为空";
        public static final Integer PARAMS_LOST = 1002;
        public static final String SOURCE_EMPTY_MSG = "来源不能为空;";
        public static final String MOBILE_EMPTY_MSG = "手机号码不能为空;";
        public static final String VALIDATE_CODE_EMPTY_MSG = "验证码不能为空;";
        public static final Integer REGISTER_TYPE_LOST = 1003;
        public static final String REGISTER_TYPE_LOST_MSG = "注册类型为空";
        public static final Integer INSERT_TO_BEAUTIYBOND_FAIL=1004;
        public static final String  INSERT_TO_BEAUTIYBOND_FAIL_MSG="添加会员信息到美容邦失败";
        public static final Integer MEMBER_ISNOT_EXSIT=1005;
        public static final String  MEMBER_ISNOT_EXSIT_MSG="会员不存在";
    }

    public static  class Login{
        public static final Integer SHOPOWNER_LOGIN_FAIL= 3001;
        public static final String SHOPOWNER_LOGIN_FAIL_MSG = "您还未开通店长权限，可致电美容邦客服咨询合作事宜职";
        public static final Integer BEAUTICIAN_LOGIN_FAIL= 3002;
        public static final String BEAUTICIAN_LOGIN_FAIL_MSG = "您还未开通美容邦相关业务，请与您的店长确认，或致电美容邦客服咨询合作事宜";
        public static final Integer USERNAME_OR_PWD_ERROR= 3002;
        public static final String USERNAME_OR_PWD_ERROR_MSG = "用户名密码错误";
    }


}
