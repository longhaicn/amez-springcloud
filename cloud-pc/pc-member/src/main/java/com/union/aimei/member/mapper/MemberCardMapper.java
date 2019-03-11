package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.NewProductGroundVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:31
*/
public interface MemberCardMapper extends BaseMapper<MemberCard> {

    /**
     * 查询最新添加的会员卡ID
     * @param memberCard
     * @return
     */
    Integer queryNewestSaveId(MemberCard memberCard);

    /**
     * 查询会员和会员卡新增统计
     * @param memberAndMemberCardVo
     * @return
     */
    Integer queryMemberCardCount(MemberAndMemberCardVo memberAndMemberCardVo);

    /**
     * 根据门店id查询品牌会员卡
     * @param map
     * @return
     */
    List<Integer> queryByStoreId(Map<String,Object> map);
}