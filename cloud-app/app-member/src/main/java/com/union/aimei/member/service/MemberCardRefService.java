package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.Map;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,10:47
*/
public interface MemberCardRefService extends SpringCloudBaseService<MemberCardRef> {
       /**
        * 前端分页查询用户会员卡表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardRef 查询条件
        * @return 
        */
       PageInfo<MemberCardRef> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardRef memberCardRef);

       /**
        * 查询用户会员卡信息
        * @param map
        * @return
        */
       ResponseMessage<MemberCardRef> queryByIdAndCardId(Map<String, Object> map);

       /**
        * 根据会员id查询数据
        * @param pageNo
        * @param pageSize
        * @param memberId
        * @param isEnabled
        * @return
        */
       ResponseMessage<PageInfo<Map<String,Object>>> queryByMemberId(Integer pageNo, Integer pageSize, Integer memberId,Byte isEnabled);

       /**
        * 提交订单查询我可以是用的会员卡
        * @param pageNo
        * @param pageSize
        * @param memberId
        * @param productId
        * @return
        */
       ResponseMessage<PageInfo<Map<String,Object>>> queryUserdByMemberId(Integer pageNo, Integer pageSize, Integer memberId,Integer productId);


       /**
        * 用户会员卡消费
        * @param amount
        * @param memberId
        * @param memberCardId
        * @return
        */
       ResponseMessage memberCardConsume(Integer amount, Integer memberId, Integer memberCardId);

       /**
        * 根据会员ID查询会员卡数量
        * @param memberId
        * @return
        */
       ResponseMessage getMyCardCount(Integer memberId);

       /**
        * 查询我的会员卡信息与累计节省金额
        * @param id(中间表ID)
        * @return
        */
       ResponseMessage queryMyCardInfo(Integer id);

       /**
        * 查询我的会员卡信息
        * @param id(中间表ID)
        * @return
        */
       ResponseMessage<MemberCardRef> queryByRefId(Integer id);

       /**
        * 通过会员ID查询用户最新购买的会员卡信息
        * @param memberId
        * @return
        */
       ResponseMessage queryMemberNewestCard(Integer memberId);


        /**
         * 添加会员购卡记录
         * @param memberCardTradeRecode
         * @return
         */
       ResponseMessage insertBuyCardRecord(MemberCardTradeRecode memberCardTradeRecode);


        /**
         * 更新会员卡余额
         * @param memberCardTradeRecode
         * @return
         */
       ResponseMessage updateMemberCardBalance(MemberCardTradeRecode memberCardTradeRecode);
}