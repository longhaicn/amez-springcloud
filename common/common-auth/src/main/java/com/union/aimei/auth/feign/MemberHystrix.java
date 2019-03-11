package com.union.aimei.auth.feign;

import com.union.aimei.common.model.member.Member;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Component
public class MemberHystrix implements MemberFeign{
    @Override
    public ResponseMessage<Member> queryMemberInfoByUuid(String uuid) {
        return HystrixResponse.invokeFail();
    }
}
