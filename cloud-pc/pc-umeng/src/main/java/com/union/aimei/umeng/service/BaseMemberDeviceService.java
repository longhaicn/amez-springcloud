package com.union.aimei.umeng.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseMemberDevice;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface BaseMemberDeviceService extends SpringCloudBaseService<BaseMemberDevice> {
       /**
        * 前端分页查询会员设备码表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param baseMemberDevice 查询条件
        * @return 
        */
       PageInfo<BaseMemberDevice> findByPageForFront(Integer pageNo, Integer pageSize, BaseMemberDevice baseMemberDevice);

       /**
        * 根据memberId来查询会员设备信息
        * @param memberId
        * @return
        */
       BaseMemberDevice queryByMemberId(Integer memberId);

       /**
        * 根据memberId来查询会员deviceToken
        * @param memberId
        * @return
        */
       String queryDeviceTokenByMemberId(Integer memberId);

       /**
        * 根据设备参数查询设备信息
        * @param baseMemberDevice
        * @return
        */
       ResponseMessage queryByInfo(BaseMemberDevice baseMemberDevice);
}