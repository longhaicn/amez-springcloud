package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberLevelUpgrade;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:45
*/
public interface MemberLevelUpgradeService extends SpringCloudBaseService<MemberLevelUpgrade> {
       /**
        * 前端分页查询会员成长值规则设置
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberLevelUpgrade 查询条件
        * @return 
        */
       PageInfo<MemberLevelUpgrade> findByPageForFront(Integer pageNo, Integer pageSize, MemberLevelUpgrade memberLevelUpgrade);
}