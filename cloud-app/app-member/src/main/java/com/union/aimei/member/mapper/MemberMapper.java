package com.union.aimei.member.mapper;


import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberImUsernameListVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/2,17:30
*/
public interface MemberMapper extends BaseMapper<Member> {

    /**
     * 根据条件查询会员
     * @param member
     * @return
     */
    List<Member> queryByConditions(Member member);

    /**
     * 根据手机号码查询
     * @param mobile
     * @return
     */
    Member queryByMobile(String mobile);

    /**
     * 查询im用户的列表
     * @param memberImUsernameListVo
     * @return
     */
    List<Member> queryByImUsernameList(MemberImUsernameListVo memberImUsernameListVo);

    /**
     * 根据uuid来查询会员信息
     * @param uuid
     * @return
     */
    Member queryMemberInfoByUuid(String uuid);
}