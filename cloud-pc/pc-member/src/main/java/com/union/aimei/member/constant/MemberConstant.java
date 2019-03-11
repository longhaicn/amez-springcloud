package com.union.aimei.member.constant;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/22,14:44
*/
public class MemberConstant {

    public static class Base{
        public static final Integer GET_ACCESSTOKEN_FAIL=1001;
        public static final String GET_ACCESSTOKEN_FAIL_MSG="获取网关AccessToken失败";
        public static final Integer REMOTE_INVOKE_FAIL=1002;
        public static final String REMOTE_INVOKE_FAIL_MSG="远程调用失败";
        public static final Integer REGISTER_FAIL=1003;
        public static final String REGISTER_FAIL_FAIL_MSG="注册失败";
        public static final Integer REPEAT_REGISTER=1004;
        public static final String REPEAT_REGISTER_MSG="请勿重复注册";
    }
}
