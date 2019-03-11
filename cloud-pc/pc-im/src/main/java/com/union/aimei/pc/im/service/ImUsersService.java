package com.union.aimei.pc.im.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsers;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * IM用户
 *
 * @author liurenkai
 * @time 2017/12/25 18:54
 */
public interface ImUsersService extends SpringCloudBaseService<ImUsers> {
    /**
     * 前端分页查询IM用户
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param imUsers  查询条件
     * @return
     */
    PageInfo<ImUsers> findByPageForFront(Integer pageNo, Integer pageSize, ImUsers imUsers);
}