package com.union.aimei.learn.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefDetailsVo;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefVo;
import com.union.aimei.common.vo.learn.app.CheckRepeatActivityVo;
import com.union.aimei.learn.service.ActivityMemberRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Api(tags="用户活动表")
@RestController
@RequestMapping(value="activityMemberRef")
public class ActivityMemberRefController {
       @Resource
       private ActivityMemberRefService activityMemberRefService;

       @PostMapping("/front/findByPage")
       public PageInfo<ActivityMemberRef> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody ActivityMemberRef activityMemberRef) {
              return this.activityMemberRefService.findByPageForFront(pageNo,pageSize,activityMemberRef);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody ActivityMemberRef activityMemberRef) {
              return this.activityMemberRefService.addObj(activityMemberRef);
       }

       /**
        * 批量添加用户活动表
        * @param activityMemberRefList
        * @return
        */
       @PostMapping(value="/insertBatch")
       void insertBatch(@RequestBody List<ActivityMemberRef> activityMemberRefList){
              this.activityMemberRefService.insertBatch(activityMemberRefList);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.activityMemberRefService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody ActivityMemberRef activityMemberRef) {
              return this.activityMemberRefService.modifyObj(activityMemberRef);
       }

       @GetMapping("/queryById/{id}")
       public ActivityMemberRef queryById(@PathVariable (value="id") int id) {
              return this.activityMemberRefService.queryObjById(id);
       }

       /**
        * 判断美容师或者门店活动报名是否重复
        *
        */
       @PostMapping(value="/checkRepeatActivity")
       ResponseMessage checkRepeatActivity(@RequestBody CheckRepeatActivityVo checkRepeatActivityVo){
              return this.activityMemberRefService.checkRepeatActivity(checkRepeatActivityVo);
       }


       /**
        * 根据会员memberId批量判断会员是否重复报名
        * @param activityMemberRefVo
        * @return
        */
       @PostMapping(value="/selectRepeatBeauticianIdBatch")
       ResponseMessage selectRepeatBeauticianIdBatch(@RequestBody ActivityMemberRefVo activityMemberRefVo){
              return this.activityMemberRefService.selectRepeatBeauticianIdBatch(activityMemberRefVo);
       }

       /**
        * 门店(美容师)查询活动报名详情
        * @param activityMemberRefDetailsVo
        * @return
        */
       @PostMapping("/queryActivityMemberRefDetail")
       public ResponseMessage<ActivityMemberRefDetailsVo> queryActivityMemberRefDetail(@RequestBody ActivityMemberRefDetailsVo activityMemberRefDetailsVo) {
              return this.activityMemberRefService.queryActivityMemberRefDetail(activityMemberRefDetailsVo);
       }
}