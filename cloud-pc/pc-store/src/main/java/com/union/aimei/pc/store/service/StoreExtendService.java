package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreExtend;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 店铺扩展
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
public interface StoreExtendService extends SpringCloudBaseService<StoreExtend> {
    /**
     * 前端分页查询店铺扩展
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param storeExtend 查询条件
     * @return
     */
    PageInfo<StoreExtend> findByPageForFront(Integer pageNo, Integer pageSize, StoreExtend storeExtend);
}