package com.union.aimei.common.feign.pc.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberFeign;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.remote.model.MrbMemberLoginImVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberFeign")
public class MemberApiHystrix implements MemberFeign {

    /**
     * 前端分页查询美容邦用户表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param member   查询条件
     * @return
     */
    @Override
    public PageInfo<Member> findByPageForFront(Integer pageNo, Integer pageSize, Member member) {
        return null;
    }

    @Override
    public ResponseMessage<Member> registerAmezMember(MrbMemberLoginVo mrbMemberLoginVo) {
        return null;
    }


    /**
     * 添加美容邦用户表
     *
     * @param member
     * @return
     */
    @Override
    public int insert(Member member) {
        return 0;
    }

    /**
     * 删除美容邦用户表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改美容邦用户表
     *
     * @param member
     * @return
     */
    @Override
    public int edit(Member member) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmember
     */
    @Override
    public Member queryById(int id) {
        return null;
    }


    @Override
    public Integer queryMemberCount(MemberAndMemberCardVo memberAndMemberCardVo) {
        return null;
    }

    @Override
    public ResponseMessage modify(Member member) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Member> registerAmezMemberV111(MrbMemberLoginImVo mrbMemberLoginImVo) {
        return null;
    }


}