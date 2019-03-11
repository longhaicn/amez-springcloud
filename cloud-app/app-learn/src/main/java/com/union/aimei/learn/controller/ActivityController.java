package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.vo.learn.app.ActivityTopVo;
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

       @GetMapping("/queryById/{id}/{beauticianId}")
       public ResponseMessage<Activity> queryByActivityId(
               @PathVariable(value = "id") int id ,
               @PathVariable(value = "beauticianId") int beauticianId){
              return this.activityService.queryByActivityId(id,beauticianId);
       }

       /**
        * 查询置顶活动(活动轮播图)
        * @param activityTopVo
        * @return
        */
       @PostMapping("/front/selectTopActivityList")
       public ResponseMessage selectTopActivityList( @ApiParam(value="查询条件") @RequestBody ActivityTopVo activityTopVo) {
              return this.activityService.selectTopActivityList(activityTopVo);
       }
}