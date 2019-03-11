package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/3,15:07
*/
public interface MemberCardUseProductMapper extends BaseMapper<MemberCardUseProduct> {
    /**
     * 批量添加
     * @param list
     */
    void insertCardUseProductBatch(List<MemberCardUseProduct> list);

    /**
     * 通过会员卡ID查询可用服务集合ID
     * @param cardId
     * @return
     */
    List<Integer> queryListByCardId(Integer cardId);
}