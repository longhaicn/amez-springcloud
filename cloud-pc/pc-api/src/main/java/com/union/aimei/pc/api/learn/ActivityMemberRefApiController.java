package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.ActivityMemberRefFeign;
import com.union.aimei.common.model.learn.ActivityMemberRef;
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
 */
@Api(tags="用户活动表")
@RestController
@RequestMapping(value="activityMemberRef")
public class ActivityMemberRefApiController {
       @Resource
       private ActivityMemberRefFeign activityMemberRefFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param activityMemberRef 查询条件
     * @return ResponseMessage<ActivityMemberRef>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询用户活动表")
       @PostMapping("/1.1.0/front/findByPageV110")
       public ResponseMessage<ActivityMemberRef> findByPageForFrontV110(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody ActivityMemberRef activityMemberRef) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<ActivityMemberRef> page=activityMemberRefFeign.findByPageForFront(pageNo, pageSize,activityMemberRef);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加ActivityMemberRef
        * @param activityMemberRef
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加用户活动表")
       @PostMapping("/1.1.0/insertV110")
       public ResponseMessage insertV110(@RequestBody ActivityMemberRef activityMemberRef) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.activityMemberRefFeign.insert(activityMemberRef);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除ActivityMemberRef
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除用户活动表")
       @DeleteMapping("/1.1.0/deleteById/{id}")
       public ResponseMessage deleteByIdV110(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.activityMemberRefFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改ActivityMemberRef
        * @param activityMemberRef
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑用户活动表")
       @PutMapping("/1.1.0/editV110")
       public ResponseMessage editV110(@RequestBody ActivityMemberRef activityMemberRef) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.activityMemberRefFeign.edit(activityMemberRef);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询ActivityMemberRef
        * @param id
        * @returnactivityMemberRef
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询用户活动表")
       @GetMapping("/1.1.0/queryById/{id}")
       public ResponseMessage<ActivityMemberRef> queryByIdV110(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              ActivityMemberRef model=this.activityMemberRefFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }
}