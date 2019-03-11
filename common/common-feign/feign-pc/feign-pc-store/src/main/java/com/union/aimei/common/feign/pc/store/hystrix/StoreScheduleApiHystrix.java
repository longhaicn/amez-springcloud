package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreScheduleFeign;
import com.union.aimei.common.model.store.StoreSchedule;
import org.springframework.stereotype.Component;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Component(value = "pc-StoreScheduleFeign")
public class StoreScheduleApiHystrix implements StoreScheduleFeign {

    /**
     * 前端分页查询店铺排班
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeSchedule 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreSchedule> findByPageForFront(Integer pageNo, Integer pageSize, StoreSchedule storeSchedule) {
        return null;
    }

    /**
     * 添加店铺排班
     *
     * @param storeSchedule
     * @return
     */
    @Override
    public int insert(StoreSchedule storeSchedule) {
        return 0;
    }

    /**
     * 删除店铺排班
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺排班
     *
     * @param storeSchedule
     * @return
     */
    @Override
    public int edit(StoreSchedule storeSchedule) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreSchedule
     */
    @Override
    public StoreSchedule queryById(int id) {
        return null;
    }
}