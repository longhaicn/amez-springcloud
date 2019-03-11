package com.union.aimei.member.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.member.MemberConstant;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.vo.member.MemberImUsernameListVo;
import com.union.aimei.member.mapper.MemberCardRefMapper;
import com.union.aimei.member.mapper.MemberMapper;
import com.union.aimei.member.service.MemberService;
import com.union.aimei.remote.AmezResponse;
import com.union.aimei.remote.model.AmezMember;
import com.union.aimei.remote.model.MemberResult;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.aimei.remote.model.ResultVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.exception.ServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/2,17:38
*/
@Service("memberService")
public class MemberServiceImpl implements MemberService {

      public static final Logger log= LoggerFactory.getLogger(MemberServiceImpl.class);
       @Resource
       private MemberMapper memberMapper;
       @Resource
       private MemberCardRefMapper memberCardRefMapper;
       @Resource
       private AmezResponse amezResponse;
       /**
        * 前端分页查询美容邦用户表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param member 查询条件
        * @return 
        */
       @Override
       public PageInfo<Member> findByPageForFront(Integer pageNo, Integer pageSize, Member member) {
              PageHelper.startPage(pageNo,pageSize);
              List<Member> list = this.memberMapper.selectListByConditions(member);
              PageInfo<Member> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加美容邦用户表
        * @param
        * @return
        */
       @Override
       @Transactional(rollbackFor = Exception.class)
       public int addObj(Member t) {
           int result=this.memberMapper.insertSelective(t);
           return result;
       }

       /**
        * 删除美容邦用户表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改美容邦用户表
        * @param
        * @return
        */
       @Override
       public int modifyObj(Member t) {
              return this.memberMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmember
        */
       @Override
       public Member queryObjById(int id) {
              Member model=this.memberMapper.selectByPrimaryKey(id);
              return model;
       }


       @Override
       public ResponseMessage queryByConditions(Member member) {
           ResponseMessage responseMessage=new ResponseMessage();
           List<Member> member1=memberMapper.queryByConditions(member);
           if(member1!=null){
               responseMessage.setData(member1.get(0));
           }else{
               responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
               responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
           }
           return responseMessage;
       }




    @Override
    public ResponseMessage judgeIfHasBuyCard(Integer memberId, Integer memberCardId) {
        ResponseMessage res= ResponseMessageFactory.newInstance();
           Map<String,Object> map=new HashMap<>(2);
        map.put("memberId",memberId);
        map.put("cardId",memberCardId);
        int result=memberCardRefMapper.countMemberBuyCard(map);
        if(result==1){
            res.setData(1);
        }else{
            res.setData(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }



    @Override
    public ResponseMessage<List<Member>> queryByImUsernameList(MemberImUsernameListVo memberImUsernameListVo) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        List<Member> list = this.memberMapper.queryByImUsernameList(memberImUsernameListVo);
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Member> queryMemberInfoByUuid(String uuid) {
        ResponseMessage<Member> responseMessage = new ResponseMessage<>();
        Member model=this.memberMapper.queryMemberInfoByUuid(uuid);
        responseMessage.setData(model);
        return responseMessage;
    }

    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<Member> registerUser(MrbMemberLoginVo mrbMemberLoginVo) {
        ResponseMessage<Member> responseMessage = new ResponseMessage<>();
        //判断是否已经注册过：
        Member mem = memberMapper.queryByMobile(mrbMemberLoginVo.getMobile());
        if (mem != null) {
            responseMessage.setData(mem);
            return responseMessage;
        }
        if(mrbMemberLoginVo.getMobile()==null){
            mrbMemberLoginVo.setMobile(mrbMemberLoginVo.getUserName());
        }
        ResultVo<MemberResult> resultVo=amezResponse.memberLogin(mrbMemberLoginVo);
        Optional.of(resultVo)
                .map(x->x.getData())
                .map(x->x.getMember())
                .orElseThrow(()->new ServerException(500,resultVo.getMsg()));
        if(resultVo.getCode().equals(MemberConstant.Login.USER_LOGIN_BACK_CODE)){
            responseMessage.setCode(1004);
        }
        AmezMember amezMember = resultVo.getData().getMember();
        Member member=new Member();
        member.setAmezUserId(amezMember.getId());
        member.setAmezUuid(amezMember.getUuid());
        member.setRegisterPhone(amezMember.getMobile());
        //添加信息到会员表中
        memberMapper.insertSelective(member);
        responseMessage.setData(member);
        return responseMessage;
    }
}