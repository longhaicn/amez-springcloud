package com.union.aimei.common.feign.app.im.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.im.ImChatGroupsUsersFeign;
import com.union.aimei.common.model.im.ImChatGroupsUsers;
import org.springframework.stereotype.Component;

/**
 * IM群组用户
 *
 * @author liurenkai
 * @time 2017/12/25 19:19
 */
@Component(value = "app-ImChatGroupsUsersFeign")
public class ImChatGroupsUsersApiHystrix implements ImChatGroupsUsersFeign {

    /**
     * 前端分页查询IM群组用户
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param imChatGroupsUsers 查询条件
     * @return
     */
    @Override
    public PageInfo<ImChatGroupsUsers> findByPageForFront(Integer pageNo, Integer pageSize, ImChatGroupsUsers imChatGroupsUsers) {
        return null;
    }

    /**
     * 添加IM群组用户
     *
     * @param imChatGroupsUsers
     * @return
     */
    @Override
    public int insert(ImChatGroupsUsers imChatGroupsUsers) {
        return 0;
    }

    /**
     * 删除IM群组用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改IM群组用户
     *
     * @param imChatGroupsUsers
     * @return
     */
    @Override
    public int edit(ImChatGroupsUsers imChatGroupsUsers) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimChatGroupsUsers
     */
    @Override
    public ImChatGroupsUsers queryById(int id) {
        return null;
    }
}