package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,10:44
 */
public interface MemberCardUseRangeMapper extends BaseMapper<MemberCardUseRange> {

    /**
     * 批量添加会员卡门店使用范围
     *
     * @param list
     */
    void insertMemberCardUseStoreBatch(List<MemberCardUseRange> list);

    /**
     * 通过会员卡ID查询门店使用ID集合
     *
     * @param cardId
     * @return
     */
    List<Integer> queryListByCardId(Integer cardId);

    /**
     * 根据门店id修改会员卡的冻结状态
     * @param condMap
     * @return
     */
    int updateCardStatusByStoreId(Map<String, Object> condMap);
}