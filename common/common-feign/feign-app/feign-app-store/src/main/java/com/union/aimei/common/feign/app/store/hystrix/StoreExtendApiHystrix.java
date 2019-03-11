package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreExtendFeign;
import com.union.aimei.common.model.store.StoreExtend;
import org.springframework.stereotype.Component;

/**
 * 店铺扩展
 *
 * @author liurenkai
 * @time 2018/4/11 14:30
 */
@Component(value = "app-StoreExtendFeign")
public class StoreExtendApiHystrix implements StoreExtendFeign {

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
        return null;
    }

    /**
     * 添加店铺扩展
     *
     * @param storeExtend
     * @return
     */
    @Override
    public int insert(StoreExtend storeExtend) {
        return 0;
    }

    /**
     * 删除店铺扩展
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺扩展
     *
     * @param storeExtend
     * @return
     */
    @Override
    public int edit(StoreExtend storeExtend) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreExtend
     */
    @Override
    public StoreExtend queryById(int id) {
        return null;
    }
}