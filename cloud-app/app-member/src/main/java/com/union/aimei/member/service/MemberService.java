package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberImUsernameListVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/2,17:38
*/
public interface MemberService extends SpringCloudBaseService<Member> {
       /**
        * 前端分页查询美容邦用户表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param member 查询条件
        * @return 
        */
       PageInfo<Member> findByPageForFront(Integer pageNo, Integer pageSize, Member member);

       /**
        * 根据条件查询
        * @param member
        * @return
        */
       ResponseMessage queryByConditions(Member member);


       /**
        * 判断用户是否已经购卡
        * @param memberId
        * @param memberCardId
        * @return
        */
       ResponseMessage judgeIfHasBuyCard(Integer memberId,Integer memberCardId);


       /**
        * MemberImUsernameList查询会员信息
        * @param memberImUsernameListVo
        * @return
        */
       ResponseMessage<List<Member>> queryByImUsernameList(MemberImUsernameListVo memberImUsernameListVo);

       /**
        * 根据uuid来查询会员信息
        * @param uuid
        * @return
        */
       ResponseMessage<Member> queryMemberInfoByUuid(String uuid);

       /**
        * 注册会员
        * @param mrbMemberLoginVo
        * @return
        */
       ResponseMessage<Member> registerUser(MrbMemberLoginVo mrbMemberLoginVo);


}