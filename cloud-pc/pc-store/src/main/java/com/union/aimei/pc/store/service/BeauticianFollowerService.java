package com.union.aimei.pc.store.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public interface BeauticianFollowerService extends SpringCloudBaseService<BeauticianFollower> {
    /**
     * 前端分页查询美容师粉丝
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param beauticianFollower 查询条件
     * @return
     */
    PageInfo<BeauticianFollower> findByPageForFront(Integer pageNo, Integer pageSize, BeauticianFollower beauticianFollower);
}