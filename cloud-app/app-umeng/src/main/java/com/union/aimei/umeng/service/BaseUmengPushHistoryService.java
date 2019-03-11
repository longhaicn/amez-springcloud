package com.union.aimei.umeng.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.umeng.BaseUmengPushHistory;
import com.union.aimei.common.vo.umeng.UmengPushCategory;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface BaseUmengPushHistoryService extends SpringCloudBaseService<BaseUmengPushHistory> {
       /**
        * 前端分页查询友盟消息推送记录
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param baseUmengPushHistory 查询条件
        * @return 
        */
       PageInfo<BaseUmengPushHistory> findByPageForFront(Integer pageNo, Integer pageSize, BaseUmengPushHistory baseUmengPushHistory);

       /**
        * 查询用户所有的未读的推送消息
        * @param umengPushCategory
        * @return
        */
       ResponseMessage findCategoryList(UmengPushCategory umengPushCategory);
}