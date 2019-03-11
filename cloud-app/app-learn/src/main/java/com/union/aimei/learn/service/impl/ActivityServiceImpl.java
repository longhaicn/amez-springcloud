package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.Activity;
import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.vo.learn.app.ActivityTopVo;
import com.union.aimei.learn.mapper.ActivityMapper;
import com.union.aimei.learn.mapper.LearnImgMapper;
import com.union.aimei.learn.service.ActivityService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
       public ResponseMessage<Activity> queryByActivityId(Integer id, Integer beauticianId) {
              ResponseMessage responseMessage = new ResponseMessage ();
              Activity activity = this.activityMapper.selectByPrimaryKey(id);
              Map<String,Integer> map = new HashMap<>(2);
              map.put("id",id);
              map.put("memberId",beauticianId);
              Integer resId = this.activityMapper.queryIdByActivityIdAndMemberId(map);
              if(resId !=null){
                     activity.setApptype(1);
              }else{
                     activity.setApptype(0);
              }
              LearnImg learnImg = new LearnImg();
              learnImg.setSourceType(0);
              learnImg.setSourceId(id);
              List<String> imgURLList = this.learnImgMapper.queryListByLearnImg(learnImg);
              activity.setImgURLList(imgURLList);
              responseMessage.setData(activity);
              return responseMessage;
       }

       @Override
       public ResponseMessage<ActivityTopVo> selectTopActivityList(ActivityTopVo activityTopVo) {
              ResponseMessage res = new ResponseMessage ();
              List<ActivityTopVo> activityList =  this.activityMapper.selectTopActivityList(activityTopVo);
              if(CollectionUtils.isEmpty(activityList)){
                     res.setCode(3001);
                     res.setMessage("查询数据为空");
              }else{
                     res.setData(activityList);
              }
              return res;
       }

       /**
        * 添加活动表
        * @param t
        * @return
        */
       @Override
       public int addObj(Activity t) {
              return this.activityMapper.insertSelective(t);
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
              return this.activityMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnactivity
        */
       @Override
       public Activity queryObjById(int id) {
              Activity model=this.activityMapper.selectByPrimaryKey(id);
              //设置活动地址拼接
              String address = model.getAddress();
              model.setAddress(null);
              StringBuffer sb = new StringBuffer();
              model.setAddress(sb.append(model.getProvinceName()).append(model.getCityName()).append(model.getDistrictName()).append(address).toString());
              //查询活动的图片
              LearnImg learnImg = new LearnImg();
              learnImg.setSourceId(model.getId());
              learnImg.setSourceType(0);
              List<String> imglist = this.learnImgMapper.queryListByLearnImg(learnImg);
              model.setImgURLList(imglist);
              return model;
       }


}