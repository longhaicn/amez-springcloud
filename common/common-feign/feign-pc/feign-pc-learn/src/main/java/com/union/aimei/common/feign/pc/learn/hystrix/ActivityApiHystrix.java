package com.union.aimei.common.feign.pc.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.ActivityFeign;
import com.union.aimei.common.model.learn.Activity;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Component(value = "pc-ActivityFeign")
public class ActivityApiHystrix implements ActivityFeign {

       /**
        * 前端分页查询活动表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param activity 查询条件
        * @return 
        */
       @Override
       public PageInfo<Activity> findByPageForFront(Integer pageNo, Integer pageSize, Activity activity) {
              return null;
       }


       @Override
       public void updateActivityStopStatus() {

       }

       @Override
       public void pushMsgForEnterActivityMember() {

       }

       /**
        * 添加活动表
        * @param activity
        * @return
        */
       @Override
       public int insert(Activity activity) {
              return 0;
       }

       /**
        * 删除活动表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改活动表
        * @param activity
        * @return
        */
       @Override
       public int edit(Activity activity) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnactivity
        */
       @Override
       public Activity queryById(int id) {
              return null;
       }
}