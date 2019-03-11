package com.union.aimei.common.feign.app.member;

import com.union.aimei.common.feign.app.member.hystrix.MrbMemberHystrix;
import com.union.aimei.common.vo.member.MrbMemberLoginVo;
import com.union.aimei.remote.model.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

/**
 * @author GaoWei
 * @time 2018/6/6 13:56
 * @description
 */
@FeignClient(serviceId = "APP-MEMBER-SERVICE", fallback = MrbMemberHystrix.class)
public interface MrbMemberFeign {

    /**
     * 美容邦用户登录
     * @param mrbMemberLoginVo
     * @return
     */
    @PostMapping(value = "/mrbMember/login")
    ResponseMessage memberLogin(@RequestBody MrbMemberLoginVo mrbMemberLoginVo);


    /**
     * 未登录重置密码
     * @param resetLoginPwdVo
     * @return
     */
    @PostMapping(value = "/mrbMember/reSetPasswordOnUnLogin")
    ResponseMessage reSetPasswordOnUnLogin(@RequestBody ResetLoginPwdVo resetLoginPwdVo);


    /**
     * 找回支付密码(忘记支付密码，重置支付密码)
     * @param resetPayPwdVo
     * @return
     */
    @PostMapping(value = "/mrbMember/reSetPayPasswordOnUnLogin")
    ResponseMessage reSetPayPasswordOnUnLogin(@RequestBody ResetPayPwdVo resetPayPwdVo);


    /**
     * 登录状态-重置登录密码
     * @param updateLoginPasswordVo
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/mrbMember/resSetPasswordOnLogin")
    ResponseMessage resSetPassword(@RequestBody UpdateLoginPasswordVo updateLoginPasswordVo)throws IOException;


    /**
     * 验证支付密码
     * @param memberVo
     * @return
     */
    @PostMapping(value = "/mrbMember/verifyPayPassword")
    ResponseMessage verifyPayPassword(@RequestBody MemberVo memberVo);


    /**
     * 初始化登录密码,密码必须MD5加密(UUID,密码，IP,来源必传)
     * @param register
     * @return
     */
    @PostMapping(value = "/mrbMember/initPassword")
    ResponseMessage initPassword(@RequestBody MemberVo register);


    /**
     * 初始化支付密码,支付密码必须MD5加密(UUID,支付密码，IP,，来源必传)
     * @param register
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "初始化支付密码,支付密码必须MD5加密(UUID,支付密码，IP,，来源必传)")
    @PostMapping(value = "/mrbMember/initPayPassword")
    ResponseMessage initPayPassword(@RequestBody MemberVo register);


    /**
     * 登录状态-重置支付密码
     * @param updatePayPasswordVo
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/mrbMember/resSetPayPasswordOnLogin")
    ResponseMessage resSetPayPassword(@RequestBody UpdatePayPasswordVo updatePayPasswordVo)throws IOException;


    /**
     * 获取注册登录验证码及找回密码传递手机号码及类型即可，" +
     *                     "修改登录密码以及修改支付密码必传UUID，手机号及类型
     * @param mobileVerifyCodeVo
     * @return
     */
    @PostMapping(value = "/mrbMember/getVerifyCode")
    ResponseMessage getLoginVerifyCode(@RequestBody MobileVerifyCodeVo mobileVerifyCodeVo);


    /**
     * 通过UUID查询余额
     * @param uuid
     * @return
     */
    @GetMapping(value = "/mrbMember/queryUserUseBalance/{uuid}")
    ResponseMessage<Double> queryUserUseBalance(@PathVariable(value = "uuid") String uuid);


    /**
     * 通过UUID查询一卡通信息
     * @param uuid
     * @return
     */
    @GetMapping(value = "/mrbMember/queryUserOneCardInfo/{uuid}")
    ResponseMessage<List<MemberOneCardVo>> queryUserOneCardInfo(@PathVariable(value = "uuid") String uuid);


}
