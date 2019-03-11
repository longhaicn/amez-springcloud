package com.union.aimei.common.vo.member;


import com.union.aimei.common.model.member.MemberCardTradeRecode;

import java.util.HashMap;
import java.util.Map;

/**
*@author GaoWei
*descrption: 组装对象
*time  2017/12/16 20:16
*/
public class AssembleModel {
    /**
     * 获取充值用户会员卡参数Map
     * @param
     * @return
     */
    public static Map<String,Object> getRechargeMemberCardMap(MemberCardTradeRecode memberCardTradeRecode){
        Map<String,Object> memberCardMap=new HashMap<>(2);
        memberCardMap.put("id",memberCardTradeRecode.getMemberCardRefId());
        memberCardMap.put("amount",memberCardTradeRecode.getTradeAmount());
        return memberCardMap;
    }

    /**
     * 获取添加会员卡交易记录
     * @param
     * @return
     */
    public static MemberCardTradeRecode getAddMemberCardTradeRecode(MemberCardTrade memberCardTrade){
        MemberCardTradeRecode memberCardTradeRecode=new MemberCardTradeRecode();
        memberCardTradeRecode.setMemberCardId(memberCardTrade.getMemberCardId());
        memberCardTradeRecode.setStoreId(memberCardTrade.getStoreId());
        memberCardTradeRecode.setStoreName(memberCardTrade.getStoreName());
        memberCardTradeRecode.setTradeAmount(memberCardTrade.getAmount());
        memberCardTradeRecode.setUseType(memberCardTrade.getUseType());
        memberCardTradeRecode.setOrderNo(memberCardTrade.getMemberCardTradeOrderNo());
        memberCardTradeRecode.setOrderNo(memberCardTrade.getOutTradeNo());
        memberCardTradeRecode.setPayType(memberCardTrade.getPayType());
        return memberCardTradeRecode;
    }
}
