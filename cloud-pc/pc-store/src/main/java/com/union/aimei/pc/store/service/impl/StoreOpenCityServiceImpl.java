package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreOpenCity;
import com.union.aimei.pc.store.mapper.StoreOpenCityMapper;
import com.union.aimei.pc.store.service.StoreOpenCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店开通城市
 *
 * @author liurenkai
 * @time 2018/1/12 19:02
 */
@Service("storeOpenCityService")
public class StoreOpenCityServiceImpl implements StoreOpenCityService {
    @Resource
    private StoreOpenCityMapper storeOpenCityMapper;

    /**
     * 前端分页查询门店开通城市
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeOpenCity 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreOpenCity> findByPageForFront(Integer pageNo, Integer pageSize, StoreOpenCity storeOpenCity) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreOpenCity> list = this.storeOpenCityMapper.selectListByConditions(storeOpenCity);
        PageInfo<StoreOpenCity> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @Override
    public int addObj(StoreOpenCity storeOpenCity) {
        return this.storeOpenCityMapper.insertSelective(storeOpenCity);
    }

    /**
     * 删除门店开通城市
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeOpenCityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改门店开通城市
     *
     * @param storeOpenCity
     * @return
     */
    @Override
    public int modifyObj(StoreOpenCity storeOpenCity) {
        return this.storeOpenCityMapper.updateByPrimaryKeySelective(storeOpenCity);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreOpenCity
     */
    @Override
    public StoreOpenCity queryObjById(int id) {
        StoreOpenCity model = this.storeOpenCityMapper.selectByPrimaryKey(id);
        return model;
    }
}