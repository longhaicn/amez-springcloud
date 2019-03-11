package com.union.aimei.learn.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefDetailsVo;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefVo;
import com.union.aimei.common.vo.learn.app.CheckRepeatActivityVo;
import com.union.aimei.learn.mapper.ActivityMemberRefMapper;
import com.union.aimei.learn.service.ActivityMemberRefService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

       /**
        * 添加用户活动表
        * @param t
        * @return
        */
       @Override
       public int addObj(ActivityMemberRef t) {
              int result = 0;
              int res =  this.activityMemberRefMapper.insertSelective(t);
              if(res > 0){
                     result =  t.getId();
              }else{
                     result = -1;
              }
              return result;
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

       /**
        * 根据会员id和门店的id来判断是否重复报名
        * @param checkRepeatActivityVo
        * @return
        */
       @Override
       public ResponseMessage checkRepeatActivity(CheckRepeatActivityVo checkRepeatActivityVo) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res =this.activityMemberRefMapper.checkRepeatActivity(checkRepeatActivityVo);
              if(res > 0){
                  result.setCode(2003);
                  result.setMessage("该活动用户已经报名");
              }
              return result;
       }

       /**
        * 根据会员memberId批量判断会员是否重复报名
        * @param activityMemberRefVo
        * @return
        */
       @Override
       public ResponseMessage selectRepeatBeauticianIdBatch(ActivityMemberRefVo activityMemberRefVo) {
              ResponseMessage res = new ResponseMessage();
              List<ActivityMemberRef> list =  this.activityMemberRefMapper.selectRepeatBeauticianIdBatch(activityMemberRefVo);
              if(list.size() > 0){
                     res.setData(list);
              }else{
                    res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
                    res.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
             return res;
       }

       @Override
       @TxTransaction
       @Transactional(rollbackFor = Exception.class)
       public void insertBatch(List<ActivityMemberRef> activityMemberRefList) {
              this.activityMemberRefMapper.insertBatch(activityMemberRefList);
       }

       @Override
       public ResponseMessage<ActivityMemberRefDetailsVo> queryActivityMemberRefDetail(ActivityMemberRefDetailsVo activityMemberRefDetailsVo) {
              ResponseMessage res = new ResponseMessage();
              List<ActivityMemberRefDetailsVo> list = this.activityMemberRefMapper.queryActivityMemberRefDetail(activityMemberRefDetailsVo);
              if(list.size() > 0 ){
                     res.setData(list);
              }else{
                     res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
                     res.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return res;
       }


}