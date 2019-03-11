package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
public interface StoreFollowerService extends SpringCloudBaseService<StoreFollower> {
    /**
     * 前端分页查询店铺粉丝
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeFollower 查询条件
     * @return
     */
    PageInfo<StoreFollower> findByPageForFront(Integer pageNo, Integer pageSize, StoreFollower storeFollower);



}