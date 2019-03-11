package com.union.aimei.member.mapper;


import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.BuyMemberCardVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;


/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,10:43
*/
public interface MemberCardMapper extends BaseMapper<MemberCard> {

    /**
     * 查询最新添加的会员卡ID
     * @param memberCard
     * @return
     */
    Integer queryNewestSaveId(MemberCard memberCard);

    /**
     * 根据会员ID和会员卡ID查询会员卡详情
     * @param map
     * @return
     */
    Map<String,Object> queryDetailsByMemAndCardId(Map<String,Object> map);

    /**
     * 查询购卡列表
     * @param map
     * @return
     */
    List<BuyMemberCardVo> queryBuyCardPage(Map<String,Object> map);

    /**
     * 查询会员卡可用门店数量
     * @param cardId
     * @return
     */
    int queryUseAbleNum(Integer cardId);

}