package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreExtendOperationLog;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 店铺扩展操作日志
 *
 * @author liurenkai
 * @time 2018/4/11 14:39
 */
public interface StoreExtendOperationLogService extends SpringCloudBaseService<StoreExtendOperationLog> {
    /**
     * 前端分页查询店铺扩展操作日志
     *
     * @param pageNo                  分页索引
     * @param pageSize                每页显示数量
     * @param storeExtendOperationLog 查询条件
     * @return
     */
    PageInfo<StoreExtendOperationLog> findByPageForFront(Integer pageNo, Integer pageSize, StoreExtendOperationLog storeExtendOperationLog);
}