package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreExtend;
import com.union.aimei.pc.store.mapper.StoreExtendMapper;
import com.union.aimei.pc.store.service.StoreExtendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺扩展
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Service("storeExtendService")
public class StoreExtendServiceImpl implements StoreExtendService {
    @Resource
    private StoreExtendMapper storeExtendMapper;

    /**
     * 前端分页查询店铺扩展
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param storeExtend 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreExtend> findByPageForFront(Integer pageNo, Integer pageSize, StoreExtend storeExtend) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreExtend> list = this.storeExtendMapper.selectListByConditions(storeExtend);
        PageInfo<StoreExtend> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加店铺扩展
     *
     * @param storeExtend
     * @return
     */
    @Override
    public int addObj(StoreExtend storeExtend) {
        return this.storeExtendMapper.insertSelective(storeExtend);
    }

    /**
     * 删除店铺扩展
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeExtendMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺扩展
     *
     * @param storeExtend
     * @return
     */
    @Override
    public int modifyObj(StoreExtend storeExtend) {
        return this.storeExtendMapper.updateByPrimaryKeySelective(storeExtend);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreExtend
     */
    @Override
    public StoreExtend queryObjById(int id) {
        StoreExtend model = this.storeExtendMapper.selectByPrimaryKey(id);
        return model;
    }
}