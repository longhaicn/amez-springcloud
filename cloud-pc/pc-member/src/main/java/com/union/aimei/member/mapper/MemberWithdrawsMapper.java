package com.union.aimei.member.mapper;

import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.aimei.common.vo.member.MemberWithdrawsVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberWithdrawsMapper extends BaseMapper<MemberWithdraws> {
    /**
     * 会员提款申请管理列表
     *
     * @param memberWithdrawsVo
     * @return
     */
    List<MemberWithdraws> selectListForManager(MemberWithdrawsVo memberWithdrawsVo);

    /**
     * 批量更新
     * @param list
     */
    void updateBatch(List<MemberWithdraws> list);

    /**
     * 根据美容师流水id更新数据
     *
     * @param memberWithdraws
     */
    void updateByTradeDetailId(MemberWithdraws memberWithdraws);
}