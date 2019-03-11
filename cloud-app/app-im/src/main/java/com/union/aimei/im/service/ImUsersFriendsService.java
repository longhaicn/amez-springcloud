package com.union.aimei.im.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsersFriends;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * IM用户好友
 *
 * @author liurenkai
 * @time 2017/12/25 18:54
 */
public interface ImUsersFriendsService extends SpringCloudBaseService<ImUsersFriends> {
    /**
     * 前端分页查询IM用户好友
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param imUsersFriends 查询条件
     * @return
     */
    PageInfo<ImUsersFriends> findByPageForFront(Integer pageNo, Integer pageSize, ImUsersFriends imUsersFriends);
}