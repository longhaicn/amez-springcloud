package com.union.aimei.member.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.member.MrbMemberConstant;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.member.mapper.MemberMapper;
import com.union.aimei.member.service.MemberService;
import com.union.aimei.remote.AmezResponse;
import com.union.aimei.remote.model.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 会员
 *
 * @author liurenkai
 * @time 2018/7/11 16:51
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private AmezResponse amezResponse;

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
        PageHelper.startPage(pageNo, pageSize);
        List<Member> list = this.memberMapper.selectListByConditions(member);
        PageInfo<Member> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加美容邦用户表
     *
     * @param
     * @return
     */
    @Override
    public int addObj(Member t) {
        return this.memberMapper.insertSelective(t);
    }

    /**
     * 删除美容邦用户表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.memberMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改美容邦用户表
     *
     * @param
     * @return
     */
    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public int modifyObj(Member t) {
        return this.memberMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmember
     */
    @Override
    public Member queryObjById(int id) {
        Member model = this.memberMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<Member> registerUser(MrbMemberLoginVo mrbMemberLoginVo) {
        ResponseMessage<Member> responseMessage = new ResponseMessage<>();
        //判断是否已经注册过：
        Member mem = memberMapper.getMemberByPhone(mrbMemberLoginVo.getMobile());
        if (mem != null) {
            responseMessage.setData(mem);
            return responseMessage;
        }
        //这个地方注释有错误2018/06/08
        ResultVo<MemberResult> resultVo = amezResponse.memberLogin(mrbMemberLoginVo);
        Optional.of(resultVo)
                .map(x -> x.getData())
                .map(x -> x.getMember())
                .orElseThrow(() -> new ServerException(500, resultVo.getMsg()));
        if (resultVo.getCode().equals(MrbMemberConstant.Login.AIMEI_LOGIN_ERROR)) {
            responseMessage.setCode(1004);
        }
        AmezMember amezMember = resultVo.getData().getMember();
        Member member = new Member();
        member.setAmezUserId(amezMember.getId());
        member.setAmezUuid(amezMember.getUuid());
        member.setRegisterPhone(amezMember.getMobile());
        if (mrbMemberLoginVo.getLoginCustomer() == MrbMemberLoginVo.LoginCustomer.USER) {
            //设置用户登录的昵称
            StringBuffer sb = new StringBuffer();
            sb.append("小邦举").append((int) ((Math.random() * 9 + 1) * 100000));
            member.setMemberNickname(sb.toString());
        } else if (mrbMemberLoginVo.getLoginCustomer() == MrbMemberLoginVo.LoginCustomer.BEAUTICIAN) {
            StringBuffer sb = new StringBuffer();
            sb.append("邦女郎").append((int) ((Math.random() * 9 + 1) * 100000));
            member.setMemberNickname(sb.toString());
        } else if (mrbMemberLoginVo.getLoginCustomer() == MrbMemberLoginVo.LoginCustomer.OWENR) {
            StringBuffer sb = new StringBuffer();
            sb.append("邦主").append((int) ((Math.random() * 9 + 1) * 100000));
            member.setMemberNickname(sb.toString());
        }
        //添加信息到会员表中
        memberMapper.insertSelective(member);
        responseMessage.setData(member);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<Member> registerUserV111(MrbMemberLoginImVo loginImVo) {
        MrbMemberLoginVo mrbMemberLoginVo = loginImVo.getLoginVo();
        ResponseMessage<Member> responseMessage = new ResponseMessage<>();
        //判断是否已经注册过：
        Member mem = memberMapper.getMemberByPhone(mrbMemberLoginVo.getMobile());
        if (mem != null) {
            responseMessage.setData(mem);
            return responseMessage;
        }
        //这个地方注释有错误2018/06/08
        ResultVo<MemberResult> resultVo = amezResponse.memberLogin(mrbMemberLoginVo);
        Optional.of(resultVo)
                .map(x -> x.getData())
                .map(x -> x.getMember())
                .orElseThrow(() -> new ServerException(500, resultVo.getMsg()));
        if (resultVo.getCode().equals(MrbMemberConstant.Login.AIMEI_LOGIN_ERROR)) {
            responseMessage.setCode(1004);
        }
        AmezMember amezMember = resultVo.getData().getMember();
        Member member = new Member();
        member.setAmezUserId(amezMember.getId());
        member.setAmezUuid(amezMember.getUuid());
        member.setRegisterPhone(amezMember.getMobile());
        if (mrbMemberLoginVo.getLoginCustomer() == MrbMemberLoginVo.LoginCustomer.USER) {
            //设置用户登录的昵称
            StringBuffer sb = new StringBuffer();
            sb.append("小邦举").append((int) ((Math.random() * 9 + 1) * 100000));
            member.setMemberNickname(sb.toString());
        } else if (mrbMemberLoginVo.getLoginCustomer() == MrbMemberLoginVo.LoginCustomer.BEAUTICIAN) {
            StringBuffer sb = new StringBuffer();
            sb.append("邦女郎").append((int) ((Math.random() * 9 + 1) * 100000));
            member.setMemberNickname(sb.toString());
        } else if (mrbMemberLoginVo.getLoginCustomer() == MrbMemberLoginVo.LoginCustomer.OWENR) {
            StringBuffer sb = new StringBuffer();
            sb.append("邦主").append((int) ((Math.random() * 9 + 1) * 100000));
            member.setMemberNickname(sb.toString());
        }
        //添加信息到会员表中
        member.setImUserId(loginImVo.getImUserId());
        member.setImUsername(loginImVo.getImUsername());
        memberMapper.insertSelective(member);
        responseMessage.setData(member);
        return responseMessage;
    }

    @Override
    public Integer queryMemberCount(MemberAndMemberCardVo memberAndMemberCardVo) {
        return this.memberMapper.queryMemberCount(memberAndMemberCardVo);
    }


    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage modify(Member member) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.memberMapper.updateByPrimaryKeySelective(member);
        responseMessage.setData(result);
        return responseMessage;
    }


}