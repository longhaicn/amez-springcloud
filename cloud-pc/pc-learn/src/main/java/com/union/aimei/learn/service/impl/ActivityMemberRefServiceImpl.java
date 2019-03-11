package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.aimei.learn.mapper.ActivityMemberRefMapper;
import com.union.aimei.learn.service.ActivityMemberRefService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("activityMemberRefService")
public class ActivityMemberRefServiceImpl implements ActivityMemberRefService {
       @Resource
       private ActivityMemberRefMapper activityMemberRefMapper;

       /**
        * 前端分页查询用户活动表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param activityMemberRef 查询条件
        * @return 
        */
       @Override
       public PageInfo<ActivityMemberRef> findByPageForFront(Integer pageNo, Integer pageSize, ActivityMemberRef activityMemberRef) {
              PageHelper.startPage(pageNo,pageSize);
              List<ActivityMemberRef> list = this.activityMemberRefMapper.selectListByConditions(activityMemberRef);
              PageInfo<ActivityMemberRef> page = new PageInfo<>(list);
              return page;
       }

       @Override
       public ResponseMessage findMemberByActivityId(ActivityMemberRef activityMemberRef) {
              ResponseMessage res = new ResponseMessage();
              List<ActivityMemberRef> list = this.activityMemberRefMapper.selectListByConditions(activityMemberRef);
              if(!CollectionUtils.isEmpty(list)){
                     res.setData(list);
              }else{
                     res.setCode(5001);
                     res.setMessage("查询数据为空");
              }
              return res;
       }

       /**
        * 添加用户活动表
        * @param t
        * @return
        */
       @Override
       public int addObj(ActivityMemberRef t) {
              return this.activityMemberRefMapper.insertSelective(t);
       }

       /**
        * 删除用户活动表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.activityMemberRefMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改用户活动表
        * @param t
        * @return
        */
       @Override
       public int modifyObj(ActivityMemberRef t) {
              return this.activityMemberRefMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnactivityMemberRef
        */
       @Override
       public ActivityMemberRef queryObjById(int id) {
              ActivityMemberRef model=this.activityMemberRefMapper.selectByPrimaryKey(id);
              return model;
       }
}