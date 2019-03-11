package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberBankCard;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberBankCardService extends SpringCloudBaseService<MemberBankCard> {
       /**
        * 前端分页查询会员银行卡表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberBankCard 查询条件
        * @return 
        */
       PageInfo<MemberBankCard> findByPageForFront(Integer pageNo, Integer pageSize, MemberBankCard memberBankCard);
}