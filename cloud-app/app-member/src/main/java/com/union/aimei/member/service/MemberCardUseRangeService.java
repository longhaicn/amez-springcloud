package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,10:50
*/
public interface MemberCardUseRangeService extends SpringCloudBaseService<MemberCardUseRange> {
       /**
        * 前端分页查询会员卡使用范围
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardUseRange 查询条件
        * @return 
        */
       PageInfo<MemberCardUseRange> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardUseRange memberCardUseRange);


}