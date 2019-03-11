package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2017/12/25 10:53
 */
public interface StoreScheduleBeauticianRefService {
    /**
     * 前端分页查询店铺排班-美容师-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param storeScheduleBeauticianRef 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺排班-美容师-关联")
    @PostMapping("/storeScheduleBeauticianRef/front/findByPage")
    PageInfo<StoreScheduleBeauticianRef> findByPageForFront(Integer pageNo, Integer pageSize, StoreScheduleBeauticianRef storeScheduleBeauticianRef);
}