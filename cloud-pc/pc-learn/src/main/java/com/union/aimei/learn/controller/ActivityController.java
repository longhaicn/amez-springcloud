package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.learn.service.ActivityService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="活动表")
@RestController
@RequestMapping(value="activity")
public class ActivityController {
       @Resource
       private ActivityService activityService;

       @PostMapping("/front/findByPage")
       public PageInfo<Activity> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody Activity activity) {
              return this.activityService.findByPageForFront(pageNo,pageSize,activity);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody Activity activity) {
              return this.activityService.addObj(activity);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.activityService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody Activity activity) {
              return this.activityService.modifyObj(activity);
       }

       @GetMapping("/queryById/{id}")
       public Activity queryById(@PathVariable (value="id") int id) {
              return this.activityService.queryObjById(id);
       }


       @PostMapping("/pushMsgForEnterActivityMember")
       void  pushMsgForEnterActivityMember(){
              this.activityService.pushMsgForEnterActivityMember();
       }

       /**
        * 修改活动结束状态
        */
       @GetMapping(value="/updateActivityStopStatus")
       void updateActivityStopStatus(){
              this.activityService.updateActivityStopStatus();
       }
}