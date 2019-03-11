package com.union.aimei.common.feign.pc.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.hystrix.ActivityApiHystrix;
import com.union.aimei.common.model.learn.Activity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@FeignClient(serviceId="PC-LEARN-SERVICE",fallback=ActivityApiHystrix.class)
public interface ActivityFeign {
       /**
        * 添加活动表
        * @param activity
        * @return
        */
       @PostMapping(value="/activity/insert")
       int insert(@RequestBody Activity activity);

       /**
        * 删除活动表
        * @param id
        * @return
        */
       @DeleteMapping(value="/activity/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改活动表
        * @param activity
        * @return
        */
       @PutMapping(value="/activity/edit")
       int edit(@RequestBody Activity activity);

       /**
        * 根据ID查询
        * @param id
        * @returnactivity
        */
       @GetMapping(value="/activity/queryById/{id}")
       Activity queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询活动表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param activity 查询条件
     * @return
     */
       @PostMapping(value="/activity/front/findByPage")
       PageInfo<Activity> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                     Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                     Integer pageSize, @RequestBody Activity activity);


       /**
        * 活动结束时间到了，自动修改活动结束状态
        */
       @GetMapping(value="/activity/updateActivityStopStatus")
       void updateActivityStopStatus();

       /**
        * 活动开始前一天推送消息给美容师或者店长
        */
       @PostMapping(value="/activity/pushMsgForEnterActivityMember")
       void pushMsgForEnterActivityMember();
}