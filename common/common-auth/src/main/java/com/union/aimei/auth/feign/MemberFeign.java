package com.union.aimei.auth.feign;

import com.union.aimei.common.model.member.Member;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GaoWei
 * @Date 18-7-25 上午10:52
 * @description
 */
@FeignClient(serviceId = "APP-MEMBER-SERVICE", fallback = MemberHystrix.class)
public interface MemberFeign {

    /**
     * 根据uuid来查询会员信息
     *
     * @param uuid
     * @return
     */
    @GetMapping(value = "/member/queryMemberInfoByUuid/{uuid}")
    ResponseMessage<Member> queryMemberInfoByUuid(@PathVariable(value = "uuid") String uuid);
}
