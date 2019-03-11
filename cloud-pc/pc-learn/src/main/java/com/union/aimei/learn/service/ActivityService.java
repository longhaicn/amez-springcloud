package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Activity;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface ActivityService extends SpringCloudBaseService<Activity> {
       /**
        * 前端分页查询活动表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param activity 查询条件
        * @return 
        */
       PageInfo<Activity> findByPageForFront(Integer pageNo, Integer pageSize, Activity activity);


       /**
        * 推送消息给已经报名参加活动美容师和店长
        */
       void pushMsgForEnterActivityMember();


       /**
        * 活动结束更新活动状态
        * @return
        */
       void updateActivityStopStatus();
}