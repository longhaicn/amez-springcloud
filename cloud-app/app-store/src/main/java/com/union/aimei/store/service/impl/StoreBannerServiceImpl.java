package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBanner;
import com.union.aimei.store.mapper.StoreBannerMapper;
import com.union.aimei.store.service.StoreBannerService;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 店铺图片
 *
 * @author liurenkai
 * @time 2018/4/11 14:39
 */
@Service("storeBannerService")
public class StoreBannerServiceImpl implements StoreBannerService {
    @Resource
    private StoreBannerMapper storeBannerMapper;

    /**
     * 前端分页查询店铺图片表
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param storeBanner 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreBanner> findByPageForFront(Integer pageNo, Integer pageSize, StoreBanner storeBanner) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreBanner> list = this.storeBannerMapper.selectListByConditions(storeBanner);
        PageInfo<StoreBanner> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加店铺图片表
     *
     * @param storeBanner
     * @return
     */
    @Override
    public int addObj(StoreBanner t) {
        return this.storeBannerMapper.insertSelective(t);
    }

    /**
     * 删除店铺图片表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeBannerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺图片表
     *
     * @param storeBanner
     * @return
     */
    @Override
    public int modifyObj(StoreBanner t) {
        return this.storeBannerMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBanner
     */
    @Override
    public StoreBanner queryObjById(int id) {
        StoreBanner model = this.storeBannerMapper.selectByPrimaryKey(id);
        return model;
    }
}