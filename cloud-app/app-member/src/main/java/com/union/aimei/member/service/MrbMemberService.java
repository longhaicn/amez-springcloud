package com.union.aimei.member.service;

import com.union.aimei.remote.model.*;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * @author GaoWei
 * @time 2018/6/6 11:12
 * @description
 */
public interface MrbMemberService {


    /**
     * 登录
     * @param mrbMemberLoginVo
     * @return
     */
    ResponseMessage generatorLoginCustomer(MrbMemberLoginVo mrbMemberLoginVo);



    /**
     * 初始化登录密码
     * @param uuid
     * @param password
     * @param ip
     * @param source
     * @return
     */
    ResponseMessage initLoginPassword(String uuid,String password,String ip,String source);

    /**
     *  初始化支付密码
     * @param uuid
     * @param password
     * @param ip
     * @param source
     * @return
     */
    ResponseMessage initPayPassWord(String uuid,String password,String ip,String source);


    /**
     * 修改登录密码
     * @param uuid
     * @param oldPassword
     * @param newPassword
     * @param ip
     * @return
     */
    ResponseMessage updateLoginPassword(String uuid,String oldPassword,String newPassword,String ip);

    /**
     * 修改支付密码
     * @param uuid
     * @param oldPayPassword
     * @param newPayPassword
     * @param ip
     * @return
     */
    ResponseMessage updatePayPassword(String uuid,String oldPayPassword,String newPayPassword,String ip);

    /**
     * 匹配支付密码
     * @param uuid
     * @param payPassword
     * @return
     */
    ResponseMessage matchPayPassword(String uuid,String payPassword);



    /**
     * 根据UUID查询用户余额
     * @param uuid
     * @return
     */
    ResponseMessage<Double> queryUserUseBalance(String uuid);


    /**
     * 根据UUID查询用户一卡通信息
     * @param uuid
     * @return
     */
    ResponseMessage<List<MemberOneCardVo>> queryUserOneCardInfo(String uuid);


    /**
     * 获取短信验证码
     * @param mobileVerifyCodeVo
     * @return
     */
    ResponseMessage getLoginVerifyCode(MobileVerifyCodeVo mobileVerifyCodeVo);

    /**
     * 找回登录密码
     * @param resetLoginPwdVo
     * @return
     */
    ResponseMessage reSetPasswordOnUnLogin(ResetLoginPwdVo resetLoginPwdVo);

    /**
     * 找回支付密码
     * @param payPwdVo
     * @return
     */
    ResponseMessage reSetPayPwdOnUnLogin(ResetPayPwdVo payPwdVo);


}
