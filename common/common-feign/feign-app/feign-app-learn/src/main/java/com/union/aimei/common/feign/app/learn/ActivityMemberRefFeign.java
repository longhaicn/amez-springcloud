package com.union.aimei.common.feign.app.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.hystrix.ActivityMemberRefApiHystrix;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefDetailsVo;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefVo;
import com.union.aimei.common.vo.learn.app.CheckRepeatActivityVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@FeignClient(serviceId="APP-LEARN-SERVICE",fallback=ActivityMemberRefApiHystrix.class)
public interface ActivityMemberRefFeign {
       /**
        * 添加用户活动表
        * @param activityMemberRef
        * @return
        */
       @PostMapping(value="/activityMemberRef/insert")
       int insert(@RequestBody ActivityMemberRef activityMemberRef);

       /**
        * 批量添加用户活动表
        * @param activityMemberRefList
        * @return
        */
       @PostMapping(value="/activityMemberRef/insertBatch")
       void insertBatch(@RequestBody List<ActivityMemberRef> activityMemberRefList);


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
        * 判断美容师或者门店活动报名是否重复
        * @param checkRepeatActivityVo
        * @return
        */
       @PostMapping(value="/activityMemberRef/checkRepeatActivity")
       ResponseMessage checkRepeatActivity(@RequestBody CheckRepeatActivityVo checkRepeatActivityVo);

       /**
        * 根据美容师beauticianId批量判断美容师是否重复报名
        * @param activityMemberRefVo
        * @return
        */
       @PostMapping(value="/activityMemberRef/selectRepeatBeauticianIdBatch")
       ResponseMessage selectRepeatBeauticianIdBatch(@RequestBody ActivityMemberRefVo activityMemberRefVo);

       /**
        * 门店(美容师)查询活动报名详情
        * @param activityMemberRefDetailsVo
        * @return
        */
       @PostMapping("/activityMemberRef/queryActivityMemberRefDetail")
       ResponseMessage queryActivityMemberRefDetail(@RequestBody ActivityMemberRefDetailsVo activityMemberRefDetailsVo);
}