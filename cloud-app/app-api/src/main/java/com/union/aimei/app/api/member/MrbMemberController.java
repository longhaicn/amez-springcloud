package com.union.aimei.app.api.member;


import com.union.aimei.common.feign.app.member.MrbMemberFeign;
import com.union.aimei.common.vo.member.MrbMemberLoginVo;
import com.union.aimei.remote.model.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Api(tags = "美容邦会员相关(最新版本)")
@RestController
@RequestMapping(value = "/mrbMember")
public class MrbMemberController {

    @Resource
    private MrbMemberFeign mrbMemberFeign;


    @ApiOperation(httpMethod = "POST", value = "美容邦用户登录", notes = "来源和IP,登录主体,登录类型(0手机登录：手机号，1：账户登录(账号密码必传)")
    @PostMapping(value = "/login")
    public ResponseMessage memberLogin(@RequestBody MrbMemberLoginVo mrbMemberLoginVo) {
       return mrbMemberFeign.memberLogin(mrbMemberLoginVo);
    }




    @ApiOperation(httpMethod = "POST", value = "找回登录密码(忘记密码，重置密码)")
    @PostMapping(value = "reSetPasswordOnUnLogin")
    public ResponseMessage reSetPasswordOnUnLogin(@RequestBody ResetLoginPwdVo resetLoginPwdVo){

        return mrbMemberFeign.reSetPasswordOnUnLogin(resetLoginPwdVo);
    }



    @ApiOperation(httpMethod = "POST", value = "找回支付密码(忘记支付密码，重置支付密码)")
    @PostMapping(value = "/reSetPayPasswordOnUnLogin")
    public ResponseMessage reSetPayPasswordOnUnLogin(@RequestBody ResetPayPwdVo resetPayPwdVo){

        return mrbMemberFeign.reSetPayPasswordOnUnLogin(resetPayPwdVo);
    }


    @ApiOperation(httpMethod = "POST", value = "登录状态-重置登录密码",notes = "UUID，旧密码，新密码，ip必传，密码需MD5" +
            "加密")
    @PostMapping(value = "resSetPasswordOnLogin")
    public ResponseMessage resSetPassword(@RequestBody UpdateLoginPasswordVo updateLoginPasswordVo)throws IOException{

        return mrbMemberFeign.resSetPassword(updateLoginPasswordVo);
    }

    @ApiOperation(httpMethod = "POST", value = "验证支付密码",notes = "UUID,支付密码必传")
    @PostMapping(value = "verifyPayPassword")
    public ResponseMessage verifyPayPassword(@RequestBody MemberVo memberVo){

        return mrbMemberFeign.verifyPayPassword(memberVo);
    }



    @ApiOperation(httpMethod = "POST", value = "初始化登录密码,密码必须MD5加密(UUID,密码，IP,来源必传)")
    @PostMapping(value = "/initPassword")
    public ResponseMessage initPassword(
            @RequestBody MemberVo register){

        return mrbMemberFeign.initPassword(register);
    }

    @ApiOperation(httpMethod = "POST", value = "初始化支付密码,支付密码必须MD5加密(UUID,支付密码，IP,，来源必传)")
    @PostMapping(value = "/initPayPassword")
    public ResponseMessage initPayPassword(@RequestBody MemberVo register){

        return mrbMemberFeign.initPayPassword(register);

    }



    @ApiOperation(httpMethod = "POST", value = "登录状态-重置支付密码",notes = "UUID，旧支付密码，新支付密码，ip必传，密码需MD5")
    @PostMapping(value = "resSetPayPasswordOnLogin")
    public ResponseMessage resSetPayPassword(@RequestBody UpdatePayPasswordVo updatePayPasswordVo)throws IOException{

        return mrbMemberFeign.resSetPayPassword(updatePayPasswordVo);
    }

    @ApiOperation(httpMethod = "POST", value = "获取验证码",
            notes = "获取注册登录验证码及找回密码传递手机号码及类型即可，" +
                    "修改登录密码以及修改支付密码必传UUID，手机号及类型"
    )
    @PostMapping(value = "/getVerifyCode")
    public ResponseMessage getLoginVerifyCode(@RequestBody MobileVerifyCodeVo mobileVerifyCodeVo){

        return mrbMemberFeign.getLoginVerifyCode(mobileVerifyCodeVo);

    }



    @ApiOperation(httpMethod="GET", value="通过UUID查询余额")
    @GetMapping(value = "/queryUserUseBalance/{uuid}")
    public ResponseMessage<Double> queryUserUseBalance(@PathVariable(value = "uuid")String uuid){

        return mrbMemberFeign.queryUserUseBalance(uuid);
    }

    @ApiOperation(httpMethod="GET", value="通过UUID查询一卡通信息")
    @GetMapping(value = "/queryUserOneCardInfo/{uuid}")
    public ResponseMessage<List<MemberOneCardVo>> queryUserOneCardInfo(@PathVariable(value = "uuid")String uuid){

        return mrbMemberFeign.queryUserOneCardInfo(uuid);
    }



}
