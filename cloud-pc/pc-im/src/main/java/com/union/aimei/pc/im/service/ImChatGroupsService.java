package com.union.aimei.pc.im.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImChatGroups;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2017/12/25 18:50
 */
public interface ImChatGroupsService extends SpringCloudBaseService<ImChatGroups> {
    /**
     * 前端分页查询IM群组
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param imChatGroups 查询条件
     * @return
     */
    PageInfo<ImChatGroups> findByPageForFront(Integer pageNo, Integer pageSize, ImChatGroups imChatGroups);
}