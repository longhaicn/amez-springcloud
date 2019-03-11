package com.union.aimei.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.common.vo.store.app.StoreByMemberIdLongitudeLatitudeResultVo;
import com.union.aimei.common.vo.store.app.StoreByMemberIdLongitudeLatitudeVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/4/11 14:38
 */
public interface StoreFollowerService extends SpringCloudBaseService<StoreFollower> {
    /**
     * 前端分页查询店铺粉丝表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeFollower 查询条件
     * @return
     */
    PageInfo<StoreFollower> findByPageForFront(Integer pageNo, Integer pageSize, StoreFollower storeFollower);

    /**
     * 根据用户id和经纬度查询收藏的店铺
     * @param pageNo                                分页索引
     * @param pageSize                              每页显示数量
     * @param storeByMemberIdLongitudeLatitudeVo    查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreByMemberIdLongitudeLatitudeResultVo>> selectListPageByMemberIdAndLongitudeLatitude(Integer pageNo, Integer pageSize, StoreByMemberIdLongitudeLatitudeVo storeByMemberIdLongitudeLatitudeVo);
}