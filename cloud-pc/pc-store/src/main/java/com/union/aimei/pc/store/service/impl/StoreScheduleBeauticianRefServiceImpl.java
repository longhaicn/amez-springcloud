package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.aimei.pc.store.mapper.StoreScheduleBeauticianRefMapper;
import com.union.aimei.pc.store.service.StoreScheduleBeauticianRefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
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

    /**
     * 添加店铺排班-美容师-关联
     *
     * @param storeScheduleBeauticianRef
     * @return
     */
    @Override
    public int addObj(StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return this.storeScheduleBeauticianRefMapper.insertSelective(storeScheduleBeauticianRef);
    }

    /**
     * 删除店铺排班-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeScheduleBeauticianRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺排班-美容师-关联
     *
     * @param storeScheduleBeauticianRef
     * @return
     */
    @Override
    public int modifyObj(StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return this.storeScheduleBeauticianRefMapper.updateByPrimaryKeySelective(storeScheduleBeauticianRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreScheduleBeauticianRef
     */
    @Override
    public StoreScheduleBeauticianRef queryObjById(int id) {
        StoreScheduleBeauticianRef model = this.storeScheduleBeauticianRefMapper.selectByPrimaryKey(id);
        return model;
    }
}