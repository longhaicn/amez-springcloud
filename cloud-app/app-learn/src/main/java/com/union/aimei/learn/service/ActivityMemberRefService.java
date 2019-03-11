package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefDetailsVo;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefVo;
import com.union.aimei.common.vo.learn.app.CheckRepeatActivityVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;
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
        * 判断美容师或者门店活动报名是否重复
        * @param checkRepeatActivityVo
        * @return
        */
       ResponseMessage checkRepeatActivity(CheckRepeatActivityVo checkRepeatActivityVo);

       /**
        * 根根据会员memberId批量判断会员是否重复报名
        * @param activityMemberRefVo
        * @return
        */
       ResponseMessage selectRepeatBeauticianIdBatch(ActivityMemberRefVo activityMemberRefVo);

       /**
        * 批量添加活动报名人员
        * @param activityMemberRefList
        */
       void insertBatch(List<ActivityMemberRef> activityMemberRefList);


       /**
        * 门店(美容师)查询活动报名详情
        * @param activityMemberRefDetailsVo
        * @return
        */
       ResponseMessage<ActivityMemberRefDetailsVo> queryActivityMemberRefDetail(ActivityMemberRefDetailsVo activityMemberRefDetailsVo);
}