package com.union.aimei.member.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.common.vo.member.AssembleModel;
import com.union.aimei.member.constant.MemberConstant;
import com.union.aimei.member.mapper.MemberCardRefMapper;
import com.union.aimei.member.mapper.MemberCardTradeRecodeMapper;
import com.union.aimei.member.mapper.MemberCardUseProductMapper;
import com.union.aimei.member.mapper.MemberMapper;
import com.union.aimei.member.service.MemberCardRefService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberCardRefService")
public class MemberCardRefServiceImpl implements MemberCardRefService {

    private final static Logger log= LoggerFactory.getLogger(MemberCardRefServiceImpl.class);
       @Resource
       private MemberCardRefMapper memberCardRefMapper;
       @Resource
       private MemberCardTradeRecodeMapper memberCardTradeRecodeMapper;
       @Resource
       private MemberMapper memberMapper;
       @Resource
       private MemberCardUseProductMapper memberCardUseProductMapper;

       /**
        * 前端分页查询用户会员卡表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardRef 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardRef> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardRef memberCardRef) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberCardRef> list = this.memberCardRefMapper.selectListByConditions(memberCardRef);
              PageInfo<MemberCardRef> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加用户会员卡表
        * @param
        * @return
        */
       @Override
       public int addObj(MemberCardRef t) {
              return this.memberCardRefMapper.insertSelective(t);
       }

       /**
        * 删除用户会员卡表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberCardRefMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改用户会员卡表
        * @param
        * @return
        */
       @Override
       public int modifyObj(MemberCardRef t) {
              return this.memberCardRefMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardRef
        */
       @Override
       public MemberCardRef queryObjById(int id) {
              MemberCardRef model=this.memberCardRefMapper.selectByPrimaryKey(id);
              return model;
       }

       @Override
       public ResponseMessage<MemberCardRef> queryByIdAndCardId(Map<String, Object> map) {
           ResponseMessage<MemberCardRef> res=new ResponseMessage<>();
           MemberCardRef mc=memberCardRefMapper.queryByIdAndCardId(map);
           if(mc!=null){
               res.setData(mc);
           }else{
               res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
               res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
           }
           return res;
       }

       @Override
       public ResponseMessage<PageInfo<Map<String,Object>>> queryByMemberId(Integer pageNo,Integer pageSize,Integer memberId,Byte isEnabled) {
              ResponseMessage<PageInfo<Map<String,Object>>> responseMessage=new ResponseMessage<>();
              PageInfo<Map<String,Object>> page = null;
              PageHelper.startPage(pageNo,pageSize);
              PageHelper.orderBy("mcr.create_time desc");
              Map<String,Object> mapParam = new HashMap<>(2);
              mapParam.put("memberId",memberId);
              mapParam.put("isEnabled",isEnabled);
              List<Map<String,Object>> map=memberCardRefMapper.queryByMemberId(mapParam);
              page = new PageInfo(map);
              responseMessage.setData(page);
              return responseMessage;
       }

    @Override
    public ResponseMessage<PageInfo<Map<String,Object>>> queryUserdByMemberId(Integer pageNo,Integer pageSize,Integer memberId,Integer productId) {
        ResponseMessage<PageInfo<Map<String,Object>>> responseMessage=new ResponseMessage<>();
        PageInfo<Map<String,Object>> page = null;
        PageHelper.startPage(pageNo,pageSize);
        PageHelper.orderBy("mcr.create_time desc");
        Map<String,Object> mapParam = new HashMap<>(2);
        mapParam.put("memberId",memberId);
        mapParam.put("productId",productId);
        List<Map<String,Object>> map=memberCardRefMapper.queryUserdByMemberId(mapParam);
        page = new PageInfo(map);
        responseMessage.setData(page);
        return responseMessage;
    }

       /**
        * 用户会员卡消费
        * @param amount
        * @param memberId
        * @param memberCardRefId
        * @return
        */
       @Override
       @Transactional(rollbackFor = Exception.class)
       public ResponseMessage memberCardConsume(Integer amount, Integer memberId, Integer memberCardRefId) {
           ResponseMessage responseMessage=new ResponseMessage();
           Map<String,Object> map=new HashMap<>(2);
           map.put("id",memberCardRefId);
           map.put("amount",amount);
              //查询用户是否拥有该卡
           MemberCardRef memberCardRef=memberCardRefMapper.selectByPrimaryKey(memberCardRefId);
              if(memberCardRef!=null){
                    Integer useAbleBalance=memberCardRef.getUseableBalance();
                    boolean isTrue=useAbleBalance-amount>=0;
                    if(isTrue){
                        memberCardRefMapper.updateMemberCardAmount(map);
                    }else{
                        responseMessage.setCode(MemberConstant.MemberCardTradeRecode.AMOUNT_LESS);
                        responseMessage.setMessage(MemberConstant.MemberCardTradeRecode.AMOUNT_LESS_MSG);
                    }
              }else{
                  responseMessage.setCode(MemberConstant.MemberCard.NOT_EXSIT);
                  responseMessage.setMessage(MemberConstant.MemberCard.NOT_EXSIT_MSG);
              }
              return responseMessage;
       }

    @Override
    public ResponseMessage getMyCardCount(Integer memberId) {
        ResponseMessage responseMessage=new ResponseMessage();
        int count=memberCardRefMapper.getMyCardCount(memberId);
        responseMessage.setData(count);
        return responseMessage;
    }

    /**
     * 查询我的会员卡信息
     * @param id(中间表ID)
     * @return
     */
    @Override
    public ResponseMessage queryMyCardInfo(Integer id) {
        ResponseMessage responseMessage= ResponseMessageFactory.newInstance();
        Map<String,Object> map=memberCardRefMapper.queryMyCardInfoByRefId(id);
        if(map!=null){
            Integer memberId=Integer.valueOf(map.get("memberId").toString());
            Integer cardId=Integer.valueOf(map.get("cardId").toString());
            MemberCardTradeRecode recode=new MemberCardTradeRecode();
            recode.setMemberId(memberId);
            recode.setMemberCardId(cardId);
            Byte type=1;
            recode.setUseType(type);
            byte useType=1;
            recode.setUseType(useType);
            Double reduceAmount=0.0;
            Integer discount=Integer.parseInt(map.get("discount").toString());
            //计算会员卡累计节省金额
            List<MemberCardTradeRecode> tradeList=memberCardTradeRecodeMapper.selectListByConditions(recode);
            if(!CollectionUtils.isEmpty(tradeList)){
                for(MemberCardTradeRecode m:tradeList){
                    Integer tradeAmount=m.getTradeAmount();
                    reduceAmount+= tradeAmount*100/discount-tradeAmount;
                }
            }
            map.put("reduceAmount",reduceAmount);
            responseMessage.setData(map);
        }else{
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return responseMessage;
    }

    @Override
    public  ResponseMessage<MemberCardRef> queryByRefId(Integer id) {
        ResponseMessage responseMessage= ResponseMessageFactory.newInstance();
        MemberCardRef memberCardRef =memberCardRefMapper.selectByPrimaryKey(id);
        responseMessage.setData(memberCardRef);
        return responseMessage;
    }


    @Override
    public ResponseMessage queryMemberNewestCard(Integer memberId) {
        ResponseMessage res=ResponseMessageFactory.newInstance();
        MemberCardRef map=memberCardRefMapper.queryMemberNewestCard(memberId);
        if(map!=null){
            res.setData(map);
        }else{
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage insertBuyCardRecord(MemberCardTradeRecode memberCardTradeRecode) {
            MemberCardRef memberCardRef=new MemberCardRef();
            memberCardRef.setMemberId(memberCardTradeRecode.getMemberId());
            memberCardRef.setCardId(memberCardTradeRecode.getMemberCardId());
            Member member=memberMapper.selectByPrimaryKey(memberCardTradeRecode.getMemberId());
            if(member!=null){
                memberCardRef.setMemberName(member.getMemberName());
                memberCardRef.setMemberMobile(member.getRegisterPhone());
            }
            memberCardRef.setTotalBalance(memberCardTradeRecode.getTradeAmount());
            memberCardRef.setUseableBalance(memberCardTradeRecode.getTradeAmount());
            memberCardRefMapper.insertSelective(memberCardRef);
            //查询用户最新购卡记录
            Integer refId=memberCardRef.getId();
            log.info("用户最新购卡ID为:"+refId);
            memberCardTradeRecode.setMemberCardRefId(refId);
            log.info("会员交易对象为:"+memberCardTradeRecode.toString());
            memberCardTradeRecodeMapper.updateByPrimaryKeySelective(memberCardTradeRecode);
        return ResponseMessageFactory.newInstance();
    }


    @Override
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage updateMemberCardBalance(MemberCardTradeRecode memberCardTradeRecode) {
        memberCardRefMapper.rechargeMemberCard(AssembleModel.getRechargeMemberCardMap(memberCardTradeRecode));
        return ResponseMessageFactory.newInstance();
    }
}