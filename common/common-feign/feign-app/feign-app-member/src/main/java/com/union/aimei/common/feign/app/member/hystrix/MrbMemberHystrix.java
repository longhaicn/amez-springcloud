package com.union.aimei.common.feign.app.member.hystrix;

import com.union.aimei.common.feign.app.member.MrbMemberFeign;
import com.union.aimei.common.vo.member.MrbMemberLoginVo;
import com.union.aimei.remote.model.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author GaoWei
 * @time 2018/6/6 13:56
 * @description
 */
@Component(value = "app-MrbMemberFeign")
public class MrbMemberHystrix implements MrbMemberFeign {
    @Override
    public ResponseMessage memberLogin(MrbMemberLoginVo mrbMemberLoginVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage reSetPasswordOnUnLogin(ResetLoginPwdVo resetLoginPwdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage reSetPayPasswordOnUnLogin(ResetPayPwdVo resetPayPwdVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage resSetPassword(UpdateLoginPasswordVo updateLoginPasswordVo) throws IOException {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage verifyPayPassword(MemberVo memberVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage initPassword(MemberVo register) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage initPayPassword(MemberVo register) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage resSetPayPassword(UpdatePayPasswordVo updatePayPasswordVo) throws IOException {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage getLoginVerifyCode(MobileVerifyCodeVo mobileVerifyCodeVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Double> queryUserUseBalance(String uuid) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<MemberOneCardVo>> queryUserOneCardInfo(String uuid) {
        return HystrixResponse.invokeFail();
    }
}
