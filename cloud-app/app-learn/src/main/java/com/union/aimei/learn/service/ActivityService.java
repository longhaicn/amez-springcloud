package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.vo.learn.app.ActivityTopVo;
import com.union.common.utils.ResponseMessage;
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
        * 根据美容师id和活动Id查询详情
        * @param id
        * @param beauticianId
        * @return
        */
       public ResponseMessage<Activity> queryByActivityId( Integer id , Integer beauticianId);

       /**
        * 查询置顶帖子
        * @param activityTopVo
        * @return
        */
       public ResponseMessage<ActivityTopVo> selectTopActivityList(ActivityTopVo activityTopVo);

}