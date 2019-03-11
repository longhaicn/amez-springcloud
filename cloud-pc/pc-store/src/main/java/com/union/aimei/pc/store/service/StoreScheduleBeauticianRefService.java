package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
public interface StoreScheduleBeauticianRefService extends SpringCloudBaseService<StoreScheduleBeauticianRef> {
    /**
     * 前端分页查询店铺排班-美容师-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param storeScheduleBeauticianRef 查询条件
     * @return
     */
    PageInfo<StoreScheduleBeauticianRef> findByPageForFront(Integer pageNo, Integer pageSize, StoreScheduleBeauticianRef storeScheduleBeauticianRef);
}