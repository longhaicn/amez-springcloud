package com.union.aimei.member.mapper;


import com.union.aimei.common.model.member.MemberCardRef;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,10:45
*/
public interface MemberCardRefMapper extends BaseMapper<MemberCardRef> {

    /**
     * 充值用户会员卡
     * @param map
     */
    void rechargeMemberCard(Map<String, Object> map);

    /**
     * 根据会员ID和会员卡ID查询
     * @param map
     * @return
     */
    MemberCardRef queryByIdAndCardId(Map<String, Object> map);

    /**
     * 根据会员ID查询我的会员卡列表信息
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> queryByMemberId(Map<String,Object> mapParam);

    /**
     * 提交订单查询我可以使用的会员卡
     * @param mapParam
     * @return
     */
    List<Map<String,Object>> queryUserdByMemberId(Map<String,Object> mapParam);


    /**
     * 用户会员卡消费
     * @param map
     * @return
     */
    void updateMemberCardAmount(Map<String, Object> map);

    /**
     * 查询我的会员卡数量
     * @param memberId
     * @return
     */
    int getMyCardCount(Integer memberId);


    /**
     * 查询用户购卡数量
     * @param map
     * @return
     */
    int countMemberBuyCard(Map<String,Object> map);

    /**
     * 根据memberCardRefId查询我的会员卡信息
     * @param id
     * @return
     */
    Map<String,Object> queryMyCardInfoByRefId(Integer id);

    /**
     * 查询用户最新购买的会员卡信息
     * @param memberId
     * @return
     */
    MemberCardRef queryMemberNewestCard(Integer memberId);
}