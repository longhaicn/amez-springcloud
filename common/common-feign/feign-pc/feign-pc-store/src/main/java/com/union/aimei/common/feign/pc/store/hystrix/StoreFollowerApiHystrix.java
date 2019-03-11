package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreFollowerFeign;
import com.union.aimei.common.model.store.StoreFollower;
import org.springframework.stereotype.Component;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Component(value = "pc-StoreFollowerFeign")
public class StoreFollowerApiHystrix implements StoreFollowerFeign {

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
        return null;
    }

    /**
     * 添加店铺粉丝
     *
     * @param storeFollower
     * @return
     */
    @Override
    public int insert(StoreFollower storeFollower) {
        return 0;
    }

    /**
     * 删除店铺粉丝
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺粉丝
     *
     * @param storeFollower
     * @return
     */
    @Override
    public int edit(StoreFollower storeFollower) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreFollower
     */
    @Override
    public StoreFollower queryById(int id) {
        return null;
    }
}