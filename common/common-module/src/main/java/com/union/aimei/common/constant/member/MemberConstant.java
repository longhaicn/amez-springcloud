package com.union.aimei.common.constant.member;

/**
 * @author GaoWei
 * @describe 会员相关常量类
 * @time 2017/12/12,17:53
 */
public class MemberConstant {

    /**
     * 远程调用
     */
    public static class Invoke{
        public static final Integer INVOKE_FAIL = 0001;
        public static final String INVOKE_FAIL_MSG = "调用艾美接口失败";
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
        public static final Integer MEMBER_ISNOT_EXSIT_OTHER=1005;


    }

    public static class MemberCard{
        public static final Integer QUERY_MEMCARD_FAIL= 2002;
        public static final String QUERY_MEMCARD_FAIL_MSG = "查询会员卡服务失败";
        public static final Integer CARD_IS_NOT_EXSIT= 2002;
        public static final String CARD_IS_NOT_EXSIT_MSG = "会员卡不存在";
        public static final Integer HAS_BUY_CARD= 2003;
        public static final String HAS_BUY_CARD_MSG = "请勿重复购买";

    }


    public static  class Login{
        public static final Integer SHOPOWNER_LOGIN_FAIL= 3001;
        public static final String SHOPOWNER_LOGIN_FAIL_MSG = "您还未开通店长权限，可致电美容邦客服咨询合作事宜职";
        public static final Integer BEAUTICIAN_LOGIN_FAIL= 3002;
        public static final String BEAUTICIAN_LOGIN_FAIL_MSG = "您还未开通美容邦相关业务，请与您的店长确认，或致电美容邦客服咨询合作事宜";
        public static final Integer USERNAME_OR_PWD_ERROR= 3002;
        public static final String USERNAME_OR_PWD_ERROR_MSG = "用户名密码错误";
        public static final Integer USER_LOGIN_BACK_CODE= 1006;
    }


    public static  class VerifyCode{
        public static final Integer USER_LOGIN_BACK_CODE= 1006;
    }





}
