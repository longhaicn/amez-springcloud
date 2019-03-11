package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.pc.store.mapper.StoreFollowerMapper;
import com.union.aimei.pc.store.service.StoreFollowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Service("storeFollowerService")
public class StoreFollowerServiceImpl implements StoreFollowerService {
    @Resource
    private StoreFollowerMapper storeFollowerMapper;

    /**
     * 前端分页查询店铺粉丝
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeFollower 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreFollower> findByPageForFront(Integer pageNo, Integer pageSize, StoreFollower storeFollower) {
        PageHelper.startPage (pageNo, pageSize);
        List<StoreFollower> list = this.storeFollowerMapper.selectListByConditions (storeFollower);
        PageInfo<StoreFollower> page = new PageInfo<> (list);
        return page;
    }


    /**
     * 添加店铺粉丝
     *
     * @param storeFollower
     * @return
     */
    @Override
    public int addObj(StoreFollower storeFollower) {
        return this.storeFollowerMapper.insertSelective (storeFollower);
    }

    /**
     * 删除店铺粉丝
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeFollowerMapper.deleteByPrimaryKey (id);
    }

    /**
     * 修改店铺粉丝
     *
     * @param storeFollower
     * @return
     */
    @Override
    public int modifyObj(StoreFollower storeFollower) {
        return this.storeFollowerMapper.updateByPrimaryKeySelective (storeFollower);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreFollower
     */
    @Override
    public StoreFollower queryObjById(int id) {
        StoreFollower model = this.storeFollowerMapper.selectByPrimaryKey (id);
        return model;
    }



}