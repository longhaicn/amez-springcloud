package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:43
*/
public interface MemberCardRefService extends SpringCloudBaseService<MemberCardRef> {
       /**
        * 前端分页查询用户会员卡表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardRef 查询条件
        * @return 
        */
       PageInfo<MemberCardRef> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardRef memberCardRef);

       /**
        * 设置会员卡失效
        */
       void setMemberCardUnEffective();
}