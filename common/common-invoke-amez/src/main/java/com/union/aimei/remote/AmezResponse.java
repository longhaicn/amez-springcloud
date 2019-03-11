package com.union.aimei.remote;


import com.union.aimei.remote.model.*;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * @author GaoWei
 * @describe 艾美E族接口对接
 * @time 2018/4/11,20:00
*/
public interface AmezResponse {
    /**
     * 获取accessToken
     * @return
     */
    String getAccessToken();

    /**
     * 会员注册
     * @param mrbMemberLoginVo
     * @return
     */
    ResultVo<MemberResult> memberLogin(MrbMemberLoginVo mrbMemberLoginVo);

    /**
     * 查询艾美会员详细信息（包含会员信息，一卡通信息，以及余额）
     * @param mrbMemberLoginVo
     * @return
     */
    ResultVo<AmezMemberInfoVo> queryMemberMoreInfo(MrbMemberLoginVo mrbMemberLoginVo);

    /**
     * 通过uuid初始化登录密码
     * @param uuid
     * @param password
     * @param ip
     * @param source
     * @return
     */
    ResultVo<MemberResult> initLoginPwdByUuid(String uuid, String password, String ip, String source);

    /**
     * 初始化支付密码
     * @param uuid
     * @param payPassword
     * @param ip
     * @param source
     * @return
     */
    ResultVo<Boolean> initPayPassword(String uuid, String payPassword, String ip, String source);

    /**
     *  修改登录密码
     * @param uuid
     * @param oldPassWord
     * @param newPassword
     * @param ip
     * @return
     */
    ResultVo<MemberResult> updateLoginPassword(String uuid, String oldPassWord, String newPassword, String ip);

    /**
     * 修改支付密码
     * @param uuid
     * @param oldPayPassWord
     * @param newPayPassword
     * @param ip
     * @return
     */
    ResultVo<Boolean> updatePayPassword(String uuid, String oldPayPassWord, String newPayPassword, String ip);

    /**
     * 匹配支付密码
     * @param uuid
     * @param payPassword
     * @return
     */
    ResultVo<Boolean> matchPayPassword(String uuid, String payPassword);

    /**
     * 获取忘记密码或者忘记支付密码Code
     * @param uuid 会员唯一标识
     * @param accessToken token
     * @param type 1：忘记登录密码，2：忘记支付密码
     * @return
     */
    String getForgetCode(String uuid, String accessToken, int type);

    /**
     * 找回登录密码
     * @param uuid 会员唯一标识
     * @param pwd 登录密码
     * @param forgetPwdCode 忘记密码code（取代手机验证码）
     * @param ip 客户端IP地址
     * @param source 来源（0：用户端，1：美容师端，2：店长端）
     * @param token 令牌
     * @return
     */
    ResultVo<MemberResult> resetUpdateLoginPasswordByUuid(String uuid, String pwd, String forgetPwdCode, String ip, int source, String token);

    /**
     * 找回支付密码
     * @param uuid 会员唯一标识
     * @param payPwd 支付密码
     * @param forgetPwdCode 忘记密码code（取代手机验证码）
     * @param ip 客户端IP地址
     * @param source 来源（0：用户端，1：美容师端，2：店长端）
     * @param token 令牌
     * @return
     */
    ResultVo<Boolean> resetUpdatePayPasswordByUuid(String uuid, String payPwd, String forgetPwdCode, String ip, int source, String token);

    /**
     * 根据UUID获取会员余额
     * @param uuid
     * @return
     */
    ResultVo<MemberBalanceVo> queryMemberBalance(String uuid);

    /**
     * 根据UUID查询会员一卡通信息
     * @param uuid
     * @return
     */
    ResultVo<List<MemberOneCardVo>> queryMemberOneCardInfo(String uuid);

    /**
     * 创建艾美平台订单
     * @param token
     * @param tradeVo
     * @param payPrice
     * @return
     */
    ResultVo<PayRecordVo> createAmezPlatOrder(String token, TradeVo tradeVo, double payPrice);

    /**
     * 获取余额/一卡通支付结果
     * @param orderNo 艾美订单号
     * @param tradeNo 艾美交易流水号
     * @param payPassword 支付密码
     * @param token 令牌
     * @param payType 支付类型(3:一卡通支付，4：余额支付)
     * @param memberId 会员ID
     * @return
     */
     String getPreResult(String orderNo, String tradeNo, String payPassword, String token, Integer payType, Integer memberId);

    /**
     * 余额/一卡通退款
     * @param vo
     * @return
     */
    ResponseMessage refund(RefundParamVo vo);

}
