package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
public interface StoreCouponsReceivedService extends SpringCloudBaseService<StoreCouponsReceived> {
    /**
     * 前端分页查询店铺优惠券领取
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeCouponsReceived 查询条件
     * @return
     */
    PageInfo<StoreCouponsReceived> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsReceived storeCouponsReceived);
}