package com.union.aimei.umeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseUmengPushHistory;
import com.union.aimei.umeng.mapper.BaseUmengPushHistoryMapper;
import com.union.aimei.umeng.service.BaseUmengPushHistoryService;
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
              PageHelper.startPage(pageNo,pageSize);
              List<BaseUmengPushHistory> list = this.baseUmengPushHistoryMapper.selectListByConditions(baseUmengPushHistory);
              PageInfo<BaseUmengPushHistory> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加友盟消息推送记录
        * @param baseUmengPushHistory
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
        * @param baseUmengPushHistory
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