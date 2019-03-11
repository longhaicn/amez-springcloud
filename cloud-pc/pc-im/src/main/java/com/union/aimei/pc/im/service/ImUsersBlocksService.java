package com.union.aimei.pc.im.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsersBlocks;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * IM用户黑名单
 *
 * @author liurenkai
 * @time 2017/12/25 18:53
 */
public interface ImUsersBlocksService extends SpringCloudBaseService<ImUsersBlocks> {
    /**
     * 前端分页查询IM用户黑名单
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param imUsersBlocks 查询条件
     * @return
     */
    PageInfo<ImUsersBlocks> findByPageForFront(Integer pageNo, Integer pageSize, ImUsersBlocks imUsersBlocks);
}