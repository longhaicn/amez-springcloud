package com.union.aimei.common.feign.app.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.hystrix.ActivityApiHystrix;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.vo.learn.app.ActivityTopVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@FeignClient(serviceId="APP-LEARN-SERVICE",fallback=ActivityApiHystrix.class)
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
       PageInfo<Activity> findByPageForFront(
               @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
               @RequestBody Activity activity);

       /**
        * 根据活动id和美容师id查询活动详情
        * @param id
        * @param beauticianId
        * @return
        */
       @GetMapping("/activity/queryById/{id}/{beauticianId}")
       public ResponseMessage<Activity> queryByActivityId(
               @PathVariable(value = "id") int id,
               @PathVariable(value = "beauticianId") int beauticianId);


       /**
        * 查询活动置顶图片
        * @param activityTopVo
        * @return
        */
       @PostMapping(value="/activity/front/selectTopActivityList")
       ResponseMessage selectTopActivityList(@RequestBody ActivityTopVo activityTopVo);

}