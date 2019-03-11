package com.union.aimei.common.feign.pc.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.hystrix.ActivityMemberRefApiHystrix;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@FeignClient(serviceId="PC-LEARN-SERVICE",fallback=ActivityMemberRefApiHystrix.class)
public interface ActivityMemberRefFeign {
       /**
        * 添加用户活动表
        * @param activityMemberRef
        * @return
        */
       @PostMapping(value="/activityMemberRef/insert")
       int insert(@RequestBody ActivityMemberRef activityMemberRef);

       /**
        * 删除用户活动表
        * @param id
        * @return
        */
       @DeleteMapping(value="/activityMemberRef/deleteById/{id}")
       int deleteById(@PathVariable(value = "id") int id);

       /** 
        * 修改用户活动表
        * @param activityMemberRef
        * @return
        */
       @PutMapping(value="/activityMemberRef/edit")
       int edit(@RequestBody ActivityMemberRef activityMemberRef);

       /**
        * 根据ID查询
        * @param id
        * @returnactivityMemberRef
        */
       @GetMapping(value="/activityMemberRef/queryById/{id}")
       ActivityMemberRef queryById(@PathVariable(value = "id") int id);

       /**
     * 前端分页查询用户活动表
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param activityMemberRef 查询条件
     * @return
     */
       @PostMapping(value="/activityMemberRef/front/findByPage")
       PageInfo<ActivityMemberRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                              Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                              Integer pageSize, @RequestBody ActivityMemberRef activityMemberRef);

       /**
        * 根据活动id来查询报名的会员
        * @param activityMemberRef
        * @return
        */
       @PostMapping(value="/activityMemberRef/findMemberByActivityId")
       ResponseMessage findMemberByActivityId(@RequestBody ActivityMemberRef activityMemberRef);
}