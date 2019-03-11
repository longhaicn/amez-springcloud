package com.union.aimei.app.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.ActivityFeign;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.vo.learn.app.ActivityTopVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
public class ActivityApiController {
       @Resource
       private ActivityFeign activityFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引 
     * @param pageSize  每页显示数量
     * @param activity 查询条件
     * @return ResponseMessage<Activity>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询活动表")
       @PostMapping("/1.1.0/front/findByPageV110")
       public ResponseMessage<Activity> findByPageForFrontV110(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody Activity activity) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<Activity> page=activityFeign.findByPageForFront(pageNo, pageSize,activity);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加Activity
        * @param activity
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加活动表")
       @PostMapping("/1.1.0/insertV110")
       public ResponseMessage insertV110(@RequestBody Activity activity) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.activityFeign.insert(activity);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除Activity
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除活动表")
       @DeleteMapping("/1.1.0/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.activityFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改Activity
        * @param activity
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑活动表")
       @PutMapping("/1.1.0/editV110")
       public ResponseMessage editV110(@RequestBody Activity activity) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.activityFeign.edit(activity);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询Activity
        * @param id
        * @returnactivity
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询活动表")
       @GetMapping("/1.1.0/queryById/{id}")
       public ResponseMessage<Activity> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              Activity model=this.activityFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 根据ID查询Activity
        * @param id
        * @returnactivity
        */
       @ApiOperation(httpMethod="GET", value="通过活动id和memberId查询活动详情并且是否可以报名")
       @GetMapping("/1.1.0/queryById/{id}/{memberId}")
       public ResponseMessage<Activity> queryByActivityId(
               @PathVariable(value = "id") int id ,
               @PathVariable(value = "memberId") int memberId) {
              return this.activityFeign.queryByActivityId(id,memberId);
       }

       /**
        * 查询置顶活动(活动轮播图)
        * @param activityTopVo
        * @return
        */
       @ApiOperation(httpMethod="POST", value="查询置顶活动(活动轮播图)")
       @PostMapping("/1.1.0/front/selectTopActivityList")
       public ResponseMessage selectTopActivityList( @ApiParam(value="查询条件") @RequestBody ActivityTopVo activityTopVo) {
              return this.activityFeign.selectTopActivityList(activityTopVo);
       }

}