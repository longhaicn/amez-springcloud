package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreFollowerFeign;
import com.union.aimei.common.model.store.StoreByMemberIdLongitudeLatitude;
import com.union.aimei.common.model.store.StoreByMemberIdLongitudeLatitudeResult;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/4/11 14:25
 */
@Component(value = "app-StoreFollowerFeign")
public class StoreFollowerApiHystrix implements StoreFollowerFeign {

    /**
     * 前端分页查询店铺粉丝表
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

    @Override
    public ResponseMessage<PageInfo<StoreByMemberIdLongitudeLatitudeResult>> selectListPageByMemberIdAndLongitudeLatitude(Integer pageNo, Integer pageSize, StoreByMemberIdLongitudeLatitude storeByMemberIdLongitudeLatitude) {
        return null;
    }

    /**
     * 添加店铺粉丝表
     *
     * @param storeFollower
     * @return
     */
    @Override
    public int insert(StoreFollower storeFollower) {
        return 0;
    }

    /**
     * 删除店铺粉丝表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺粉丝表
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