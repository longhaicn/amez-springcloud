package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreSchedule;
import com.union.aimei.pc.store.mapper.StoreScheduleMapper;
import com.union.aimei.pc.store.service.StoreScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Service("storeScheduleService")
public class StoreScheduleServiceImpl implements StoreScheduleService {
    @Resource
    private StoreScheduleMapper storeScheduleMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<StoreSchedule> list = this.storeScheduleMapper.selectListByConditions(storeSchedule);
        PageInfo<StoreSchedule> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加店铺排班
     *
     * @param storeSchedule
     * @return
     */
    @Override
    public int addObj(StoreSchedule storeSchedule) {
        return this.storeScheduleMapper.insertSelective(storeSchedule);
    }

    /**
     * 删除店铺排班
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeScheduleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺排班
     *
     * @param storeSchedule
     * @return
     */
    @Override
    public int modifyObj(StoreSchedule storeSchedule) {
        return this.storeScheduleMapper.updateByPrimaryKeySelective(storeSchedule);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreSchedule
     */
    @Override
    public StoreSchedule queryObjById(int id) {
        StoreSchedule model = this.storeScheduleMapper.selectByPrimaryKey(id);
        return model;
    }
}