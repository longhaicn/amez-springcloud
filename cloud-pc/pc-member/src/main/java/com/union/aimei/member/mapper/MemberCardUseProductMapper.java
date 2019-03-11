package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.common.vo.member.NewProductGroundVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:36
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

    /**
     * 根据会员卡ID删除记录
     * @param cardId
     */
    void deleteRecordByCardId(Integer cardId);

    /**
     * 批量添加会员卡
     * @param map
     */
    void insertBatch(Map<String,Object> map);
}