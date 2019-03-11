package com.union.aimei.member.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.member.service.MemberService;
import com.union.aimei.remote.model.MrbMemberLoginImVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags = "美容邦用户表")
@RestController
@RequestMapping(value = "member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @PostMapping("/front/findByPage")
    public PageInfo<Member> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                       Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                       Integer pageSize, @ApiParam(value = "查询条件") @RequestBody Member member) {
        return this.memberService.findByPageForFront(pageNo, pageSize, member);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Member member) {
        return this.memberService.addObj(member);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.memberService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody Member member) {
        return this.memberService.modifyObj(member);
    }

    @GetMapping("/queryById/{id}")
    public Member queryById(@PathVariable(value = "id") int id) {
        return this.memberService.queryObjById(id);
    }


    /**
     * 注册艾美会员
     * 手机号，密码，IP，source，loginType必传
     *
     * @param mrbMemberLoginVo
     * @return
     */
    @PostMapping(value = "/registerUser")
    public ResponseMessage<Member> registerAmezMember(@RequestBody MrbMemberLoginVo mrbMemberLoginVo) {
        return memberService.registerUser(mrbMemberLoginVo);
    }

    /**
     * 注册艾美会员（IM版本）
     * 手机号，密码，IP，source，loginType必传
     *
     * @param mrbMemberLoginVo
     * @return
     */
    @PostMapping(value = "/1.1.1/registerUser")
    public ResponseMessage<Member> registerAmezMemberV111(@RequestBody MrbMemberLoginImVo mrbMemberLoginVo) {
        return memberService.registerUserV111(mrbMemberLoginVo);
    }

    /**
     * 查询会员新增统计
     */
    @ApiOperation(httpMethod = "POST", value = "根据时间段查询会员和会员卡新增统计")
    @PostMapping("/queryMemberCount")
    public Integer queryMemberCount(@RequestBody MemberAndMemberCardVo memberAndMemberCardVo) {
        return memberService.queryMemberCount(memberAndMemberCardVo);
    }

    /**
     * 修改会员
     *
     * @param member 会员
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改会员")
    @PutMapping("/modify")
    public ResponseMessage modify(@ApiParam(value = "会员") @RequestBody Member member) {
        return this.memberService.modify(member);
    }

}