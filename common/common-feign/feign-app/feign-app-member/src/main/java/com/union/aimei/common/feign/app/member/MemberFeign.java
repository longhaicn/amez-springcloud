package com.union.aimei.common.feign.app.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.hystrix.MemberApiHystrix;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberImUsernameListVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/13,13:21
*/
@FeignClient(serviceId = "APP-MEMBER-SERVICE", fallback = MemberApiHystrix.class)
public interface MemberFeign {

    /**
     * 添加美容邦会员信息
     * @param member
     * @return
     */
    @PostMapping(value = "/member/insert")
    int insertMember(@RequestBody Member member);


    /**
     * 根据条件查询会员是否存在
     * @param member
     * @return
     */
    @PostMapping(value = "/member/queryByConditions")
    ResponseMessage queryByConditions(@RequestBody Member member);

    /**
     * 修改美容邦用户表
     * @param member
     * @return
     */
    @PutMapping(value="/member/edit")
    int edit(@RequestBody Member member);

    /**
     * 根据ID查询
     * @param id
     * @returnmember
     */
    @GetMapping(value="/member/queryById/{id}")
    Member queryById(@PathVariable(value = "id") int id);

    /**
     * 根据ImUsernameList来查询会员信息
     * @param memberImUsernameListVo
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/member/queryByImUsernameList")
    ResponseMessage queryByImUsernameList(@RequestBody MemberImUsernameListVo memberImUsernameListVo);

    /**
     * 根据uuid来查询会员信息
     * @param uuid
     * @return uuid
     */
    @GetMapping(value = "/member/queryMemberInfoByUuid/{uuid}")
    ResponseMessage<Member>  queryMemberInfoByUuid(@PathVariable(value = "uuid") String uuid);


    /**
     * 根据手机号码查询member
     * @param mobile
     * @return
     */
    @GetMapping(value = "/member/queryByMobile")
    ResponseMessage<Member> queryByPhone(@RequestParam(value = "mobile") String mobile);


    /**
     * 前端分页查询美容邦用户表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param member 查询条件
     * @return
     */
    @PostMapping(value="/member/front/findByPage")
    PageInfo<Member> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                Integer pageSize, @RequestBody Member member);

    /**
     * 注册艾美会员
     * 手机号，密码，IP，source，loginType必传
     * @param mrbMemberLoginVo
     * @return
     */
    @PostMapping(value = "/member/registerUser")
    ResponseMessage<Member> registerAmezMember(@RequestBody MrbMemberLoginVo mrbMemberLoginVo);

}
