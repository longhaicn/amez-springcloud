package com.union.aimei.umeng.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseUmengPushHistory;
import com.union.aimei.common.vo.umeng.UmengPushCategory;
import com.union.aimei.umeng.mapper.BaseUmengPushHistoryMapper;
import com.union.aimei.umeng.service.BaseUmengPushHistoryService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("baseUmengPushHistoryService")
public class BaseUmengPushHistoryServiceImpl implements BaseUmengPushHistoryService {
       @Resource
       private BaseUmengPushHistoryMapper baseUmengPushHistoryMapper;

       /**
        * 前端分页查询友盟消息推送记录
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param baseUmengPushHistory 查询条件
        * @return 
        */
       @Override
       public PageInfo<BaseUmengPushHistory> findByPageForFront(Integer pageNo, Integer pageSize, BaseUmengPushHistory baseUmengPushHistory) {
              this.baseUmengPushHistoryMapper.updateReadStatus(baseUmengPushHistory);
              PageHelper.startPage(pageNo,pageSize);
              List<BaseUmengPushHistory> list = this.baseUmengPushHistoryMapper.selectListByConditions(baseUmengPushHistory);
              PageInfo<BaseUmengPushHistory> page = new PageInfo<>(list);
              return page;
       }

       @Override
       public ResponseMessage findCategoryList(UmengPushCategory umengPushCategory) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              if(CollectionUtils.isEmpty(umengPushCategory.getList())){
                    result.setCode(ResponseContants.QUERY_EMPTY);
                    result.setMessage("查询list参数为空");
              }else{
                     JSONObject res = new JSONObject();
                     for (String code : umengPushCategory.getList()) {
                            JSONObject every = new JSONObject();
                            BaseUmengPushHistory baseUmengPushHistory = new BaseUmengPushHistory();
                            baseUmengPushHistory.setMsgCode(code);
                            baseUmengPushHistory.setDeviceToken(umengPushCategory.getDeviceToken());
                            baseUmengPushHistory.setReadStatus(umengPushCategory.getStatus());
                            baseUmengPushHistory.setMemberId(umengPushCategory.getMemberId());
                            List<BaseUmengPushHistory> dataList = this.baseUmengPushHistoryMapper.selectListByConditions(baseUmengPushHistory);
                            if (dataList.size() > 0) {
                                   if(umengPushCategory.getNeedDetail() == 1){
                                          every.put("data", dataList.get(0));
                                   }
                                   every.put("size", dataList.size());
                            }else{
                                   BaseUmengPushHistory noData = new BaseUmengPushHistory();
                                   noData.setMsgCode(code);
                                   noData.setDeviceToken(umengPushCategory.getDeviceToken());
                                   noData.setMemberId(umengPushCategory.getMemberId());
                                   dataList = this.baseUmengPushHistoryMapper.selectListByConditions(noData);
                                   if(!CollectionUtils.isEmpty(dataList)){
                                          every.put("data",dataList.get(0));
                                   }
                                   every.put("size", 0);
                            }
                            res.put(code,every);
                     }
                     result.setData(res);
              }
              return result;
       }

       /**
        * 添加友盟消息推送记录
        * @param t
        * @return
        */
       @Override
       public int addObj(BaseUmengPushHistory t) {
              return this.baseUmengPushHistoryMapper.insertSelective(t);
       }

       /**
        * 删除友盟消息推送记录
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.baseUmengPushHistoryMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改友盟消息推送记录
        * @param t
        * @return
        */
       @Override
       public int modifyObj(BaseUmengPushHistory t) {
              return this.baseUmengPushHistoryMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnbaseUmengPushHistory
        */
       @Override
       public BaseUmengPushHistory queryObjById(int id) {
              BaseUmengPushHistory model=this.baseUmengPushHistoryMapper.selectByPrimaryKey(id);
              return model;
       }
}