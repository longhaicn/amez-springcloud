package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreSchedule;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
public interface StoreScheduleService extends SpringCloudBaseService<StoreSchedule> {
    /**
     * 前端分页查询店铺排班
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeSchedule 查询条件
     * @return
     */
    PageInfo<StoreSchedule> findByPageForFront(Integer pageNo, Integer pageSize, StoreSchedule storeSchedule);
}