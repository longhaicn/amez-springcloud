package com.union.aimei.member.controller;


import com.union.aimei.member.service.MrbMemberService;
import com.union.aimei.remote.model.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags = "美容邦会员相关(最新版本)")
@RestController
@RequestMapping(value = "/mrbMember")
public class MrbMemberController {

    @Resource
    private MrbMemberService mrbMemberService;

    @ApiOperation(httpMethod = "POST", value = "美容邦用户登录", notes = "来源和IP,登录主体,登录类型(0手机登录：手机号，1：账户登录(账号密码必传)")
    @PostMapping(value = "/login")
    public ResponseMessage memberLogin(@RequestBody MrbMemberLoginVo mrbMemberLoginVo) {
         Optional.of(mrbMemberLoginVo)
                .filter(m1->!StringUtils.isBlank(String.valueOf(m1.getLoginCustomer())))
                .filter(m1->m1.getLoginType()==0?m1.getMobile()!=null&&m1.getVerifyCode()!=null:m1.getUserName()!=null&&m1.getPassword()!=null)
                .filter(m1-> !StringUtils.isBlank(m1.getIp()))
                .filter(m1->!StringUtils.isBlank(m1.getSource()))
                .orElseThrow(()->new ClientException(500,"必传参数错误，请仔细检查"));
       return mrbMemberService.generatorLoginCustomer(mrbMemberLoginVo);
    }




    @ApiOperation(httpMethod = "POST", value = "找回登录密码(忘记密码，重置密码)")
    @PostMapping(value = "reSetPasswordOnUnLogin")
    public ResponseMessage reSetPasswordOnUnLogin(@RequestBody ResetLoginPwdVo resetLoginPwdVo){
        Optional.of(resetLoginPwdVo)
                .filter(vo -> !StringUtils.isBlank(vo.getMobile()))
                .filter(vo->!StringUtils.isBlank(vo.getVerifyCode()))
                .filter(vo->!StringUtils.isBlank(vo.getPwd()))
                .filter(vo->!StringUtils.isBlank(vo.getIp()))
                .filter(vo->!StringUtils.isBlank(String.valueOf(vo.getSource())))
                .orElseThrow(()->new ClientException(500,"必传参数缺失，请仔细检查"));
        return mrbMemberService.reSetPasswordOnUnLogin(resetLoginPwdVo);
    }



    @ApiOperation(httpMethod = "POST", value = "找回支付密码(忘记支付密码，重置支付密码)")
    @PostMapping(value = "/reSetPayPasswordOnUnLogin")
    public ResponseMessage reSetPayPasswordOnUnLogin(@RequestBody ResetPayPwdVo resetPayPwdVo){
        Optional.of(resetPayPwdVo)
                .filter(vo -> !StringUtils.isBlank(vo.getMobile()))
                .filter(vo->!StringUtils.isBlank(vo.getVerifyCode()))
                .filter(vo->!StringUtils.isBlank(vo.getPayPwd()))
                .filter(vo->!StringUtils.isBlank(vo.getIp()))
                .filter(vo->!StringUtils.isBlank(String.valueOf(vo.getSource())))
                .orElseThrow(()->new ClientException(500,"必传参数缺失，请仔细检查"));
        return mrbMemberService.reSetPayPwdOnUnLogin(resetPayPwdVo);
    }


    @ApiOperation(httpMethod = "POST", value = "登录状态-重置登录密码",notes = "UUID，旧密码，新密码，ip必传，密码需MD5" +
            "加密")
    @PostMapping(value = "resSetPasswordOnLogin")
    public ResponseMessage resSetPassword(@RequestBody UpdateLoginPasswordVo updateLoginPasswordVo)throws IOException{
        Optional.of(updateLoginPasswordVo)
                .filter(vo->!StringUtils.isBlank(vo.getUuid()))
                .filter(vo->!StringUtils.isBlank(vo.getOldLoginPassword()))
                .filter(vo->!StringUtils.isBlank(vo.getNewLoginPassword()))
                .filter(vo->!StringUtils.isBlank(vo.getIp()))
                .orElseThrow(()->new ClientException(500,"必传参数缺失，请仔细检查"));
        return mrbMemberService.updateLoginPassword(updateLoginPasswordVo.getUuid(),updateLoginPasswordVo.getOldLoginPassword(),updateLoginPasswordVo.getNewLoginPassword(),updateLoginPasswordVo.getIp());
    }

    @ApiOperation(httpMethod = "POST", value = "验证支付密码",notes = "UUID,支付密码必传")
    @PostMapping(value = "verifyPayPassword")
    public ResponseMessage verifyPayPassword(@RequestBody MemberVo memberVo){
       Optional.of(memberVo)
               .filter(mvo->!StringUtils.isBlank(mvo.getUuid()))
               .filter(mvo->!StringUtils.isBlank(mvo.getPayPassword()))
               .orElseThrow(()->new ClientException(500,"必传参数缺失，请仔细检查"));
        return mrbMemberService.matchPayPassword(memberVo.getUuid(),memberVo.getPayPassword());
    }



    @ApiOperation(httpMethod = "POST", value = "初始化登录密码,密码必须MD5加密(UUID,密码，IP,来源必传)")
    @PostMapping(value = "/initPassword")
    public ResponseMessage initPassword(
            @RequestBody MemberVo register){
        Optional.of(register)
                .filter(vo->!StringUtils.isBlank(vo.getUuid()))
                .filter(vo->!StringUtils.isBlank(vo.getPassword()))
                .filter(vo->!StringUtils.isBlank(vo.getIp()))
                .filter(vo->!StringUtils.isBlank(vo.getSource()))
                .orElseThrow(()->new ClientException(500,"必传参数缺失，请仔细检查"));
        return mrbMemberService.initLoginPassword(register.getUuid(),register.getPassword(),register.getIp(),register.getSource());
    }

    @ApiOperation(httpMethod = "POST", value = "初始化支付密码,支付密码必须MD5加密(UUID,支付密码，IP,，来源必传)")
    @PostMapping(value = "/initPayPassword")
    public ResponseMessage initPayPassword(@RequestBody MemberVo register){
        Optional.of(register)
                .filter(vo->!StringUtils.isBlank(vo.getUuid()))
                .filter(vo->!StringUtils.isBlank(vo.getPayPassword()))
                .filter(vo->!StringUtils.isBlank(vo.getIp()))
                .filter(vo->!StringUtils.isBlank(vo.getSource()))
                .orElseThrow(()->new ClientException(500,"必传参数缺失，请仔细检查"));
        return mrbMemberService.initPayPassWord(register.getUuid(),register.getPayPassword(),register.getIp(),register.getSource());

    }



    @ApiOperation(httpMethod = "POST", value = "登录状态-重置支付密码",notes = "UUID，旧支付密码，新支付密码，ip必传，密码需MD5")
    @PostMapping(value = "resSetPayPasswordOnLogin")
    public ResponseMessage resSetPayPassword(@RequestBody UpdatePayPasswordVo updatePayPasswordVo)throws IOException{
        Optional.of(updatePayPasswordVo)
                .filter(vo->!StringUtils.isBlank(vo.getUuid()))
                .filter(vo->!StringUtils.isBlank(vo.getOldPayPassword()))
                .filter(vo->!StringUtils.isBlank(vo.getNewPayPassword()))
                .filter(vo->!StringUtils.isBlank(vo.getIp()))
                .orElseThrow(()->new ClientException(500,"必传参数缺失，请仔细检查"));
        return mrbMemberService.updatePayPassword(updatePayPasswordVo.getUuid(),updatePayPasswordVo.getOldPayPassword(),updatePayPasswordVo.getNewPayPassword(),updatePayPasswordVo.getIp());
    }

    @ApiOperation(httpMethod = "POST", value = "获取验证码",
            notes = "获取注册登录验证码及找回密码传递手机号码及类型即可，" +
                    "修改登录密码以及修改支付密码必传UUID，手机号及类型"
    )
    @PostMapping(value = "/getVerifyCode")
    public ResponseMessage getLoginVerifyCode(@RequestBody MobileVerifyCodeVo mobileVerifyCodeVo){
        Optional.of(mobileVerifyCodeVo)
                .filter(vo->{
                    boolean isTrue=false;
                    int codeType=vo.getCodeType();
                    if(codeType==MobileVerifyCodeVo.CodeType.REGIN_LOGIN_CODE||codeType==MobileVerifyCodeVo.CodeType.FIND_LOGIN_PWD_CODE){
                        isTrue=vo.getMobile()!=null;
                    }else if(codeType==MobileVerifyCodeVo.CodeType.UPDATE_LOGIN_CODE||codeType==MobileVerifyCodeVo.CodeType.UPDATE_PAY_CODE){
                        isTrue=vo.getMobile()!=null&&vo.getUuid()!=null;
                    }
                    return isTrue;
                })
                .orElseThrow(()->new ClientException(500,"必传参数错误，请仔细检查"));
        return mrbMemberService.getLoginVerifyCode(mobileVerifyCodeVo);

    }



    @ApiOperation(httpMethod="GET", value="通过UUID查询余额")
    @GetMapping(value = "/queryUserUseBalance/{uuid}")
    public ResponseMessage<Double> queryUserUseBalance(@PathVariable(value = "uuid")String uuid){
        Optional.ofNullable(uuid)
                .filter(u->!StringUtils.isBlank(u))
                .orElseThrow(()->new ClientException(500,"UUID不能为空"));
        return mrbMemberService.queryUserUseBalance(uuid);
    }

    @ApiOperation(httpMethod="GET", value="通过UUID查询一卡通信息")
    @GetMapping(value = "/queryUserOneCardInfo/{uuid}")
    public ResponseMessage<List<MemberOneCardVo>> queryUserOneCardInfo(@PathVariable(value = "uuid")String uuid){
        Optional.ofNullable(uuid)
                .filter(u->!StringUtils.isBlank(u))
                .orElseThrow(()->new ClientException(500,"UUID不能为空"));
        return mrbMemberService.queryUserOneCardInfo(uuid);
    }



}
