package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberAddress;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:40
*/
public interface MemberAddressService extends SpringCloudBaseService<MemberAddress> {
       /**
        * 前端分页查询会员地址
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberAddress 查询条件
        * @return 
        */
       PageInfo<MemberAddress> findByPageForFront(Integer pageNo, Integer pageSize, MemberAddress memberAddress);
}