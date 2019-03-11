package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBannerFeign;
import com.union.aimei.common.model.store.StoreBanner;
import org.springframework.stereotype.Component;

/**
 * 店铺图片
 *
 * @author liurenkai
 * @time 2018/4/11 14:26
 */
@Component(value = "app-StoreBannerFeign")
public class StoreBannerApiHystrix implements StoreBannerFeign {

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
        return null;
    }

    /**
     * 添加店铺图片表
     *
     * @param storeBanner
     * @return
     */
    @Override
    public int insert(StoreBanner storeBanner) {
        return 0;
    }

    /**
     * 删除店铺图片表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺图片表
     *
     * @param storeBanner
     * @return
     */
    @Override
    public int edit(StoreBanner storeBanner) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBanner
     */
    @Override
    public StoreBanner queryById(int id) {
        return null;
    }
}