package com.union.aimei.remote.config;


import lombok.Data;

/**
 * @author GaoWei
 * @describe 艾美一族请求常量
 * @time 2018/4/12,9:37
*/
@Data
public class AmezRequestConstant {

    /**
     * 路径
      */
   public static class Path{
       public static final String API="api";
       public static final String ACCESS_TOKEN="accessToken";
   }

    /**
     * 路由
     */
//   public static class Route{
//        /**
//         * 会员
//         */
//       public static final String  MEMBER  ="/member";
//        /**
//         * 一卡通
//         */
//       public static final String  MEMBER_ONECARD  ="/memberOneCard";
//        /**
//         * 平台订单
//         */
//       public static final String  PLATFORM_ORDER  ="/platformOrder";
//        /**
//         * 支付
//         */
//       public static final String   PAY ="/pay";
//        /**
//         * 余额及一卡通退款
//         */
//        public static final String REFUND="/refund";
//   }

    /**
     * 接口名称
     */
   public static class InterfaceName{
        /**
         * 获取微服务访问token
         */
        public static final String  ACCESS_TOKEN="/accessToken";
        /**
         * 注册会员
         */
        public static final String  REGISTER_BY_USER="/member/registerByUser";
        /**
         * 根据手机号或用户名密码获取会员详情信息(包含会员信息，一卡通信息，以及余额信息)
         */
        public static final String  FIND_BY_MOBILE_OR_USERNAME="/member/findByMobileOrUserNamePassword";
        /**
         * 初始化登录
         */
        public static final String INIT_SET_LOGIN_PASSWORD_BY_UUID="/member/initSetLoginPasswordByUUid";
        /**
         * 初始化支付密码
         */
        public static final String INIT_SET_PAY_PASSWORD_BY_UUID="/member/initSetPayPasswordByUUid";

        /**
         * 修改登录密码
         */
        public static final String UPDATE_LOGIN_PASSWORD_BY_UUID="/member/updateLoginPasswordByUuid";
        /**
         * 修改支付密码
         */
        public static final String UPDATE_PAY_PASSWORD_BY_UUID="/member/updatePayPasswordByUuid";
        /**
         * 匹配支付密码
         */
        public static final String MATCH_PAY_PASSWORD="/member/matchPayPasswrod";
        /**
         * 获取忘记密码Code
         */
        public static final String   GET_FORGET_PWD_CODE="/member/getForgetPwdCode";
        /**
         * 找回密码
         */
        public static final String RESET_UPDATE_LOGIN_PASSWORD_BY_UUID="/member/resetUpdateLoginPasswordByUuid";
        /**
         * 找回支付密码
         */
        public static final String RESET_UPDATE_PAY_PASSWORD_BY_UUID="/member/resetUpdatePayPasswordByUuid";
        /**
         * 查询会员余额
         */
        public static final String QUERY_MEMBER_BALANCE="/member/findMemberBalanceByUuid";
        /**
         * 查询会员一卡通信息
         */
        public static final String QUERY_MEMBER_ONE_CARD_INFO="/memberOneCard/findByMemberUuid";
        /**
         * 创建第三方订单并返回支付流水
         */
        public static final String CREATE_THIRD_PARTY_ORDER="/platformOrder/createThirdPartyOrder";

        /**
         * 获取平台订单
         */
        public static final String GET_PLATFORM_ORDER="/platformOrder/get";
        /**
         * 余额支付
         */
        public static final String BALANCE_PAY="/pay/balance";
        /**
         * 一卡通支付
         */
        public static final String ONE_CARD_PAY="/pay/oneCard";
        /**
         * 申请退款
         */
        public static final String REFUND="/refund/thirdPartyOrder";
    }


}
