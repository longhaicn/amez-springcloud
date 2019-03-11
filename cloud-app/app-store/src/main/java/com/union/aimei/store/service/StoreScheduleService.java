package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreSchedule;
import com.union.aimei.common.vo.store.app.StoreScheduleVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2017/12/25 10:53
 */
public interface StoreScheduleService {
    /**
     * 前端分页查询店铺排班
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeSchedule 查询条件
     * @return
     */
    PageInfo<StoreSchedule> findByPageForFront(Integer pageNo, Integer pageSize, StoreSchedule storeSchedule);

    /**
     * 新增店铺排班
     *
     * @param storeScheduleVo 店铺排班vo
     * @return
     */
    ResponseMessage add(StoreScheduleVo storeScheduleVo);

    /**
     * 修改店铺排班
     *
     * @param storeScheduleVo 店铺排班vo
     * @return
     */
    ResponseMessage modify(StoreScheduleVo storeScheduleVo);

    /**
     * 更新店铺排班软删除标记
     *
     * @param id        店铺排班ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    ResponseMessage isEnabled(int id, int isEnabled);

    /**
     * 根据店铺ID查询店铺排班
     *
     * @param storeId 店铺ID
     * @return
     */
    ResponseMessage<List<StoreScheduleVo>> findListByStoreId(int storeId);

}