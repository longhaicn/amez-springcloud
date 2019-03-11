package com.union.aimei.common.feign.pc.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.hystrix.MemberApiHystrix;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.remote.model.MrbMemberLoginImVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@FeignClient(serviceId = "pc-member-service", fallback = MemberApiHystrix.class)
public interface MemberFeign {
    /**
     * 添加美容邦用户表
     *
     * @param member
     * @return
     */
    @PostMapping(value = "/member/insert")
    int insert(@RequestBody Member member);

    /**
     * 删除美容邦用户表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/member/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改美容邦用户表
     *
     * @param member
     * @return
     */
    @PutMapping(value = "/member/edit")
    int edit(@RequestBody Member member);

    /**
     * 根据ID查询会员卡基本信息
     *
     * @param id
     * @returnmember
     */
    @GetMapping(value = "/member/queryById/{id}")
    Member queryById(@PathVariable(value = "id") int id);


    /**
     * 前端分页查询美容邦用户表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param member   查询条件
     * @return
     */
    @PostMapping(value = "/member/front/findByPage")
    PageInfo<Member> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                Integer pageSize, @RequestBody Member member);

    /**
     * 注册会员
     *
     * @param mrbMemberLoginVo
     * @return
     */
    @PostMapping(value = "/member/registerUser")
    ResponseMessage<Member> registerAmezMember(@RequestBody MrbMemberLoginVo mrbMemberLoginVo);

    /**
     * 查询会员卡数量
     * @param memberAndMemberCardVo
     * @return
     */
    @PostMapping("/member/queryMemberCount")
    Integer queryMemberCount(@RequestBody MemberAndMemberCardVo memberAndMemberCardVo);

    /**
     * 修改美容邦用户表
     *
     * @param member 美容邦用户
     * @return
     */
    @PutMapping(value = "/member/modify")
    ResponseMessage modify(@RequestBody Member member);

    /**
     * 注册会员（IM版本）
     *
     * @param mrbMemberLoginImVo
     * @return
     */
    @PostMapping(value = "/member/1.1.1/registerUser")
    ResponseMessage<Member> registerAmezMemberV111(@RequestBody MrbMemberLoginImVo mrbMemberLoginImVo);

}