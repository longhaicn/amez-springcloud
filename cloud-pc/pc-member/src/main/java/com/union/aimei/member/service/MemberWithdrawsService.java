package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.aimei.common.vo.member.MemberWithdrawsVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberWithdrawsService extends SpringCloudBaseService<MemberWithdraws> {
    /**
     * 前端分页查询会员提现申请表
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param memberWithdraws 查询条件
     * @return
     */
    PageInfo<MemberWithdraws> findByPageForFront(Integer pageNo, Integer pageSize, MemberWithdraws memberWithdraws);

    /**
     * pc端后台查询搜索会员提现管理列表
     *
     * @param pageNo
     * @param pageSize
     * @param memberWithdrawsVo
     * @return
     */
    PageInfo<MemberWithdraws> findByPageForManager(Integer pageNo, Integer pageSize, MemberWithdrawsVo memberWithdrawsVo);

    /**
     * 批量更新
     * @param id
     */
    void updateBatch(List<Integer> id);

    /**
     * 批量更新申请状态
     * @param ids
     * @return
     */
    ResponseMessage batchMoney(String ids);

}