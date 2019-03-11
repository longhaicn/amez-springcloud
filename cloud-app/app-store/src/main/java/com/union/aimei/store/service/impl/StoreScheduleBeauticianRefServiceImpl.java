package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.aimei.store.mapper.StoreScheduleBeauticianRefMapper;
import com.union.aimei.store.service.StoreScheduleBeauticianRefService;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2017/12/25 10:53
 */
@Service("storeScheduleBeauticianRefService")
public class StoreScheduleBeauticianRefServiceImpl implements StoreScheduleBeauticianRefService {
    @Resource
    private StoreScheduleBeauticianRefMapper storeScheduleBeauticianRefMapper;

    /**
     * 前端分页查询店铺排班-美容师-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param storeScheduleBeauticianRef 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreScheduleBeauticianRef> findByPageForFront(Integer pageNo, Integer pageSize, StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreScheduleBeauticianRef> list = this.storeScheduleBeauticianRefMapper.selectListByConditions(storeScheduleBeauticianRef);
        PageInfo<StoreScheduleBeauticianRef> page = new PageInfo<>(list);
        return page;
    }
}