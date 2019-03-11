package com.union.aimei.common.feign.pc.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.ActivityMemberRefFeign;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Component(value = "pc-ActivityMemberRefFeign")
public class ActivityMemberRefApiHystrix implements ActivityMemberRefFeign {

       /**
        * 前端分页查询用户活动表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param activityMemberRef 查询条件
        * @return 
        */
       @Override
       public PageInfo<ActivityMemberRef> findByPageForFront(Integer pageNo, Integer pageSize, ActivityMemberRef activityMemberRef) {
              return null;
       }

       @Override
       public ResponseMessage findMemberByActivityId(ActivityMemberRef activityMemberRef) {
              return null;
       }

       /**
        * 添加用户活动表
        * @param activityMemberRef
        * @return
        */
       @Override
       public int insert(ActivityMemberRef activityMemberRef) {
              return 0;
       }

       /**
        * 删除用户活动表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改用户活动表
        * @param activityMemberRef
        * @return
        */
       @Override
       public int edit(ActivityMemberRef activityMemberRef) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnactivityMemberRef
        */
       @Override
       public ActivityMemberRef queryById(int id) {
              return null;
       }
}