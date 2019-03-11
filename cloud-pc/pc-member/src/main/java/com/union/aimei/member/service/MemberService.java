package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.remote.model.MrbMemberLoginImVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;


/**
 * @author GaoWei
 * @describe
 * @time 2018/1/9,14:45
 */
public interface MemberService extends SpringCloudBaseService<Member> {
    /**
     * 前端分页查询美容邦用户表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param member   查询条件
     * @return
     */
    PageInfo<Member> findByPageForFront(Integer pageNo, Integer pageSize, Member member);

    /**
     * 注册会员
     * @param mrbMemberLoginVo
     * @return
     */
    ResponseMessage<Member> registerUser(MrbMemberLoginVo mrbMemberLoginVo);

    /**
     * 注册会员（IM版本）
     * @param mrbMemberLoginVo
     * @return
     */
    ResponseMessage<Member> registerUserV111(MrbMemberLoginImVo mrbMemberLoginVo);

    /**
     * 查询会员新增统计
     * @param memberAndMemberCardVo
     * @return
     */
    Integer queryMemberCount(MemberAndMemberCardVo memberAndMemberCardVo);

    /**
     * 修改会员
     *
     * @param member 会员
     * @return
     */
    ResponseMessage modify(Member member);

}