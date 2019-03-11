package com.union.aimei.pc.im.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImChatGroupsUsers;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * IM群组用户
 *
 * @author liurenkai
 * @time 2017/12/25 18:50
 */
public interface ImChatGroupsUsersService extends SpringCloudBaseService<ImChatGroupsUsers> {
    /**
     * 前端分页查询IM群组用户
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param imChatGroupsUsers 查询条件
     * @return
     */
    PageInfo<ImChatGroupsUsers> findByPageForFront(Integer pageNo, Integer pageSize, ImChatGroupsUsers imChatGroupsUsers);
}