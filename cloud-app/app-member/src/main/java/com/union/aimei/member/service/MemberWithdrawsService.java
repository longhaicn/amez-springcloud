package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberWithdrawsService extends SpringCloudBaseService<MemberWithdraws> {
       /**
        * 前端分页查询会员提现申请表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberWithdraws 查询条件
        * @return 
        */
       PageInfo<MemberWithdraws> findByPageForFront(Integer pageNo, Integer pageSize, MemberWithdraws memberWithdraws);

       /**
        * 添加会员提现
        * @param memberWithdraws
        * @return
        */
       ResponseMessage<MemberWithdraws> insertRecord(MemberWithdraws memberWithdraws);

}