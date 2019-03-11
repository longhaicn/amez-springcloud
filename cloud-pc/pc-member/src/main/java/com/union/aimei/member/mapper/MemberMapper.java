package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.common.utils.base.BaseMapper;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:37
*/
public interface MemberMapper extends BaseMapper<Member> {
    /**
     * 通过手机号码判断是否已经注册过
     * @param phone
     * @return
     */
    Member getMemberByPhone(String phone);

    /**
     * 查询会员数量
     * @param memberAndMemberCardVo
     * @return
     */
    Integer queryMemberCount(MemberAndMemberCardVo memberAndMemberCardVo);
}