package com.union.aimei.common.feign.app.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberFeign;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberImUsernameListVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/15,14:37
*/
@Component(value = "app-MemberFeign")
public class MemberApiHystrix implements MemberFeign{
    @Override
    public int insertMember(Member member) {
        return 0;
    }

    @Override
    public ResponseMessage queryByConditions(Member member) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public int edit(Member member) {
        return 0;
    }

    @Override
    public Member queryById(int id) {
        return null;
    }


    @Override
    public ResponseMessage<List<Member>> queryByImUsernameList(MemberImUsernameListVo memberImUsernameListVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage queryMemberInfoByUuid(String uuid) {
        return HystrixResponse.invokeFail();
    }


    @Override
    public ResponseMessage<Member> queryByPhone(String mobile) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 前端分页查询美容邦用户表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param member 查询条件
     * @return
     */
    @Override
    public PageInfo<Member> findByPageForFront(Integer pageNo, Integer pageSize, Member member) {
        return null;
    }

    @Override
    public ResponseMessage<Member> registerAmezMember(MrbMemberLoginVo mrbMemberLoginVo) {
        return HystrixResponse.invokeFail();
    }

}
