package com.union.aimei.pc.api.learn;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.learn.ActivityFeign;
import com.union.aimei.common.feign.pc.learn.LearnConditionFeign;
import com.union.aimei.common.feign.pc.learn.LearnImgFeign;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.vo.learn.pc.LearnImgInsertBatchVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author houji
 */
@Api(tags="活动表")
@RestController
@RequestMapping(value="activity")
public class ActivityApiController {

       @Resource
       private ActivityFeign activityFeign;
       @Resource
       private LearnImgFeign learnImgFeign;
       @Resource
       private LearnConditionFeign learnConditionFeign;

       /**
     * 分页查询(1.1.0)
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
              PageInfo<Activity> page = activityFeign.findByPageForFront(pageNo, pageSize, activity);
              if (page != null) {
                     result.setData(page);
              } else {
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加Activity(1.1.0)
        * @param activity
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加活动表")
       @PostMapping("/1.1.0/insertV110")
       public ResponseMessage insertV110(@RequestBody Activity activity) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              //门槛数据设置
              activity.setLearnConditionList(this.learnConditionFeign.setLearnConditionListV110(activity.getLearnConditionVoList()).getData());
              int res = this.activityFeign.insert(activity);
              if (res > 0) {
                     LearnImgInsertBatchVo learnImgInsertBatchVo = new LearnImgInsertBatchVo();
                     learnImgInsertBatchVo.setSourceId(res);
                     learnImgInsertBatchVo.setSourceType(0);
                     learnImgInsertBatchVo.setImgUrlList(activity.getImgList());
                     this.learnImgFeign.insertBatch(learnImgInsertBatchVo);
              }
              AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
              return result;
       }

       /**
        * 删除Activity(1.1.0)
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除活动表")
       @DeleteMapping("/1.1.0/deleteById/{id}")
       public ResponseMessage deleteByIdV110(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res = this.activityFeign.deleteById(id);
              AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改Activity(1.1.0)
        * @param activity
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑活动表")
       @PutMapping("/1.1.0/editV110")
       public ResponseMessage editV110(@RequestBody Activity activity) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              //门槛数据设置
              activity.setLearnConditionList(this.learnConditionFeign.setLearnConditionListV110(activity.getLearnConditionVoList()).getData());
              int res = this.activityFeign.edit(activity);
              AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询Activity(1.1.0)
        * @param id
        * @returnactivity
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询活动表")
       @GetMapping("/1.1.0/queryById/{id}")
       public ResponseMessage<Activity> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              Activity model = this.activityFeign.queryById(id);
              //当model不为空的情况下，活动主图查询出来
              if (model != null) {
                     //插入活动主图
                     LearnImg learnImg = new LearnImg();
                     learnImg.setSourceId(id);
                     learnImg.setSourceType(0);
                     List<String> mainImgList = this.learnImgFeign.queryImgListByLearnImg(learnImg);
                     if (!CollectionUtils.isEmpty(mainImgList)) {
                            model.setImgList(mainImgList);
                     }
                     //插入门槛集合
                     LearnCondition learnCondition = new LearnCondition();
                     learnCondition.setSourceId(id);
                     if (model.getType() == 0) {
                            learnCondition.setSourceType((byte) 1);
                     } else if (model.getType() == 1) {
                            learnCondition.setSourceType((byte) 2);
                     }
                     learnCondition.setIsEnabled(true);
                     List<LearnCondition> conditionList = this.learnConditionFeign.queryListByLearnCondition(learnCondition);
                     if (!CollectionUtils.isEmpty(conditionList)) {
                            model.setLearnConditionVoList(this.learnConditionFeign.setLearnConditionVoListV110(conditionList).getData());
                     }
              }

              AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }


       /**
        * 测试活动前一天参加报名的人发送信息
        * @return
        */
       @ApiOperation(httpMethod="POST", value="测试活动前一天参加报名的人发送信息")
       @PostMapping("/1.1.0/front/pushMsgForEnterActivityMember")
       public void pushMsgForEnterActivityMember() {
              activityFeign.pushMsgForEnterActivityMember();
       }

}