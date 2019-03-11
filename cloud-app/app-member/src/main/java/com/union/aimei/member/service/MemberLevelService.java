package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberLevel;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberLevelService extends SpringCloudBaseService<MemberLevel> {
       /**
        * 前端分页查询会员级别
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberLevel 查询条件
        * @return 
        */
       PageInfo<MemberLevel> findByPageForFront(Integer pageNo, Integer pageSize, MemberLevel memberLevel);
}