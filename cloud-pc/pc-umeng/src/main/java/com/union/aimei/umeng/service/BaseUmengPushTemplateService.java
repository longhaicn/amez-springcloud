package com.union.aimei.umeng.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseUmengPushTemplate;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface BaseUmengPushTemplateService extends SpringCloudBaseService<BaseUmengPushTemplate> {
       /**
        * 前端分页查询U盟第三方推送记录表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param baseUmengPushTemplate 查询条件
        * @return 
        */
       PageInfo<BaseUmengPushTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BaseUmengPushTemplate baseUmengPushTemplate);

       /**
        * ios美容师端测试
        * @param baseUmengPushTemplate
        */
       public void testIOSBeautician(BaseUmengPushTemplate baseUmengPushTemplate);


       /**
        * umeng推送消息
        * @param baseUmengPushTemplate
        */
       public void sendMessage(BaseUmengPushTemplate baseUmengPushTemplate);
       /**
        * umeng推送消息
        * @param baseUmengPushTemplate
        */
       void sendMessageBatch(BaseUmengPushTemplate baseUmengPushTemplate);

       /**
        * 不同类型的用户批量推送
        * @param list
        */
       void sendMessageDiffBatch(List<BaseUmengPushTemplate> list);

}