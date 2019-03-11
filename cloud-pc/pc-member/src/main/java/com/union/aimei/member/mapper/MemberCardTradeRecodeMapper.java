package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.MemberCardSaleRecodeVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberCardTradeRecodeMapper extends BaseMapper<MemberCardTradeRecode> {
    /**
     * 根据条件查询会员卡销售记录
     * @param memberCardSaleRecodeVo
     * @return
     */
    public List<MemberCardSaleRecodeVo> queryListCardSaleRecode(MemberCardSaleRecodeVo memberCardSaleRecodeVo);

    /**
     * 查询售卡记录详情
     * @param id
     * @return
     */
    public MemberCardSaleRecodeVo queryCardSaleDetailById(Integer id);

    /**
     * 查询销售看的数量
     * @param memberAndMemberCardVo
     * @return
     */
    public Integer queryRechargeAndSaleCardCount(MemberAndMemberCardVo memberAndMemberCardVo);
}