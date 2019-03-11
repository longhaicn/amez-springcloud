package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBanner;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 店铺图片
 *
 * @author liurenkai
 * @time 2018/4/11 14:39
 */
public interface StoreBannerService extends SpringCloudBaseService<StoreBanner> {
    /**
     * 前端分页查询店铺图片表
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param storeBanner 查询条件
     * @return
     */
    PageInfo<StoreBanner> findByPageForFront(Integer pageNo, Integer pageSize, StoreBanner storeBanner);
}