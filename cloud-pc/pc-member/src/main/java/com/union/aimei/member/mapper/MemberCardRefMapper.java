package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberCardRef;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:38
*/
public interface MemberCardRefMapper extends BaseMapper<MemberCardRef> {

    /**
     * 查询当前时间大于我的会员卡过期时间
     * @param ref
     * @return
     */
    List<Integer> cardUnEffective(MemberCardRef ref);

    /**
     * 批量修改我的过期会员卡
     * @param list
     */
    void updateBatch(List<Integer> list);
}