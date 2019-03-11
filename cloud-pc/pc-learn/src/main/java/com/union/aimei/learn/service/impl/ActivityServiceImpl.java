package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.vo.learn.pc.ActivityPushMemberVo;
import com.union.aimei.learn.async.OneDayNotifyTask;
import com.union.aimei.learn.mapper.ActivityMapper;
import com.union.aimei.learn.mapper.ActivityMemberRefMapper;
import com.union.aimei.learn.mapper.LearnConditionMapper;
import com.union.aimei.learn.mapper.LearnImgMapper;
import com.union.aimei.learn.service.ActivityService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.date.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
       @Resource
       private ActivityMapper activityMapper;
       @Resource
       private LearnImgMapper learnImgMapper;
       @Resource
       private LearnConditionMapper learnConditionMapper;
       @Resource
       private ActivityMemberRefMapper activityMemberRefMapper;

       @Resource
       private OneDayNotifyTask oneDayNotifyTask;
       /**
        * 前端分页查询活动表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param activity 查询条件
        * @return 
        */
       @Override
       public PageInfo<Activity> findByPageForFront(Integer pageNo, Integer pageSize, Activity activity) {
              PageHelper.startPage(pageNo,pageSize);
              List<Activity> list = this.activityMapper.selectListByConditions(activity);
              PageInfo<Activity> page = new PageInfo<>(list);
              return page;
       }


       @Override
       public void pushMsgForEnterActivityMember() {
              //24小时制
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              Map<String,Object> map = new HashMap<>(2);
              map.put("startTime",sdf.format(DateUtil.todayFirstDate()));
              map.put("endTime",sdf.format(DateUtil.todayLastDate()));
              //查询参加将要开始的活动参加的会员信息
              List<ActivityPushMemberVo> list =  this.activityMapper.selectWillStartActivity(map);
              List<ActivityPushMemberVo> storeList = new ArrayList<>(10);
               for(ActivityPushMemberVo vo:list){
                   oneDayNotifyTask.sendMsg(vo);
                   if(vo.getStoreId() != null){
                          storeList.add(vo);
                   }else{
                          oneDayNotifyTask.pushMsg(vo);
                   }
               }
               if(!CollectionUtils.isEmpty(storeList)){
                      oneDayNotifyTask.handle(storeList);
               }
       }

       @Override
       public void updateActivityStopStatus() {
              //查询现在需要结束活动的id
              List<Integer> idList = this.activityMapper.selectIdListWillStop();
              if(!CollectionUtils.isEmpty(idList)){
                     //根据id来修改已经报名人员的活动已经完成
                     activityMemberRefMapper.updateBatchByActivityIdList(idList);
              }
              this.activityMapper.updateActivityStopStatus();
       }

       public static void main(String[] args) {
              System.out.println(DateUtil.todayFirstDate());
       }


       /**
        * 添加活动表
        * @param t
        * @return
        */
       @Override
       public int addObj(Activity t) {
              int result = 0;
              //计算活动结束时间
              Date date = null;
              if(t.getDayLength() != null){
                     date = getSomeDay(t.getStartTime(),t.getDayLength());
                     if(t.getHourLength() != null){
                            date = getSomeHour(date,t.getHourLength());
                     }
              }else{
                     date = getSomeHour(t.getStartTime(),t.getHourLength());
              }
              t.setEndTime(date);

              int res =  this.activityMapper.insertSelective(t);
              if(res > 0){
                     result = t.getId();
              }else{
                     result = -1;
              }
              //门槛
              List<LearnCondition> learnConditionList = t.getLearnConditionList ();
              if (null != learnConditionList && learnConditionList.size () > 0) {
                     for (LearnCondition learnCondition : learnConditionList) {
                            learnCondition.setSourceId (result);
                            if(t.getType() == 0){
                                   learnCondition.setSourceType ((byte)1);
                            }else if(t.getType() == 1){
                                   learnCondition.setSourceType ((byte)2);
                            }
                     }
                     learnConditionMapper.addBatch (learnConditionList);
              }
              return result;
       }

       public static Date getSomeDay(Date date, int day){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, day);
            return calendar.getTime();
       }
       public static Date getSomeHour(Date date, int hours){
              Calendar calendar = Calendar.getInstance();
              calendar.setTime(date);
              calendar.add(Calendar.HOUR, hours);
              return calendar.getTime();
       }


       /**
        * 删除活动表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.activityMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改活动表
        * @param t
        * @return
        */
       @Override
       public int modifyObj(Activity t) {
              //计算活动结束时间
              Date date = null;
              if(t.getDayLength() != null){
                     date = getSomeDay(t.getStartTime(),t.getDayLength());
                     if(t.getHourLength() != null){
                            date = getSomeHour(date,t.getHourLength());
                     }
              }else if(t.getHourLength() !=null){
                     date = getSomeHour(t.getStartTime(),t.getHourLength());
              }
              t.setEndTime(date);
              int result = this.activityMapper.updateByPrimaryKeySelective(t);
              if(t.getImgList() != null){
                     //修改活动时候，删除原来的图片，添加新的图片
                     this.learnImgMapper.deleteBySourceId(t.getId());
                     Map<String, Object> map = new HashMap<>(3);
                     map.put("sourceType",0);
                     map.put("sourceId",t.getId());
                     map.put("imgUrlList",t.getImgList());
                     this.learnImgMapper.insertBatch(map);
              }

              if(t.getLearnConditionList() != null){
                     //修改活动时候删除原来的门槛集合列表
                     //1.查询出所有的id集合
                     List<Integer> conditionIdList = this.learnConditionMapper.queryIdListBySourceId(t.getId());
                     if(!CollectionUtils.isEmpty(conditionIdList)){
                            this.learnConditionMapper.deleteByPrimaryKeyList(conditionIdList);
                     }
                     //2.重新添加活动门槛记录
                     List<LearnCondition> learnConditionList = t.getLearnConditionList ();
                     if (null != learnConditionList && learnConditionList.size () > 0) {
                            for (LearnCondition learnCondition : learnConditionList) {
                                   learnCondition.setSourceId (t.getId());
                                   if(t.getType() == 0){
                                          learnCondition.setSourceType (LearnCondition.SOURCE_TYPE_ACTIVE);
                                   }else if(t.getType() == 1){
                                          learnCondition.setSourceType (LearnCondition.SOURCE_TYPE_ACTIVE_STOCK);
                                   }
                            }
                            learnConditionMapper.addBatch (learnConditionList);
                     }
              }
              return result;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnactivity
        */
       @Override
       public Activity queryObjById(int id) {
              Activity model=this.activityMapper.selectByPrimaryKey(id);
              return model;
       }
}