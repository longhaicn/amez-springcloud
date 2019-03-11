package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreOpenCity;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 门店开通城市r
 *
 * @author liurenkai
 * @time 2018/1/12 19:02
 */
public interface StoreOpenCityService extends SpringCloudBaseService<StoreOpenCity> {
    /**
     * 前端分页查询门店开通城市
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeOpenCity 查询条件
     * @return
     */
    PageInfo<StoreOpenCity> findByPageForFront(Integer pageNo, Integer pageSize, StoreOpenCity storeOpenCity);
}