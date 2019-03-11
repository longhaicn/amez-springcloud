package com.union.aimei.common.feign.app.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.ActivityMemberRefFeign;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefDetailsVo;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefVo;
import com.union.aimei.common.vo.learn.app.CheckRepeatActivityVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Component(value = "app-ActivityMemberRefFeign")
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

       /**
        * 添加用户活动表
        * @param activityMemberRef
        * @return
        */
       @Override
       public int insert(ActivityMemberRef activityMemberRef) {
              return 0;
       }

       @Override
       public void insertBatch(List<ActivityMemberRef> activityMemberRef) {

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

       /**
        * 判断美容师或者门店活动报名是否重复
        * @param checkRepeatActivityVo
        * @return
        */
       @Override
       public ResponseMessage checkRepeatActivity(CheckRepeatActivityVo checkRepeatActivityVo) {
              return null;
       }

       /**
        * 根据会员memberId批量判断会员是否重复报名
        * @param activityMemberRefVo
        * @return
        */
       @Override
       public ResponseMessage selectRepeatBeauticianIdBatch(ActivityMemberRefVo activityMemberRefVo) {
              return null;
       }

       @Override
       public ResponseMessage<ActivityMemberRefDetailsVo> queryActivityMemberRefDetail(ActivityMemberRefDetailsVo activityMemberRefDetailsVo) {
              return null;
       }

}