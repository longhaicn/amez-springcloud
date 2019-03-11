package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreScheduleBeauticianRefFeign;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import org.springframework.stereotype.Component;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Component(value = "pc-StoreScheduleBeauticianRefFeign")
public class StoreScheduleBeauticianRefApiHystrix implements StoreScheduleBeauticianRefFeign {

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
        return null;
    }

    /**
     * 添加店铺排班-美容师-关联
     *
     * @param storeScheduleBeauticianRef
     * @return
     */
    @Override
    public int insert(StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return 0;
    }

    /**
     * 删除店铺排班-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺排班-美容师-关联
     *
     * @param storeScheduleBeauticianRef
     * @return
     */
    @Override
    public int edit(StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreScheduleBeauticianRef
     */
    @Override
    public StoreScheduleBeauticianRef queryById(int id) {
        return null;
    }
}