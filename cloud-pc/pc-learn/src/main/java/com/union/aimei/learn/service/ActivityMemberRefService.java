package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface ActivityMemberRefService extends SpringCloudBaseService<ActivityMemberRef> {
       /**
        * 前端分页查询用户活动表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param activityMemberRef 查询条件
        * @return 
        */
       PageInfo<ActivityMemberRef> findByPageForFront(Integer pageNo, Integer pageSize, ActivityMemberRef activityMemberRef);

       /**
        * 根据活动id来查询会员报名信息
        * @param activityMemberRef
        * @return
        */
       ResponseMessage findMemberByActivityId(ActivityMemberRef activityMemberRef);
}