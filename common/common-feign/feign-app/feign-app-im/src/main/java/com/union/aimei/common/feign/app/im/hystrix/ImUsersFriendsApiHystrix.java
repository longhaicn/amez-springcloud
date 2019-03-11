package com.union.aimei.common.feign.app.im.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.im.ImUsersFriendsFeign;
import com.union.aimei.common.model.im.ImUsersFriends;
import org.springframework.stereotype.Component;

/**
 * IM用户好友
 *
 * @author liurenkai
 * @time 2017/12/25 19:24
 */
@Component(value = "app-ImUsersFriendsFeign")
public class ImUsersFriendsApiHystrix implements ImUsersFriendsFeign {

    /**
     * 前端分页查询IM用户好友
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param imUsersFriends 查询条件
     * @return
     */
    @Override
    public PageInfo<ImUsersFriends> findByPageForFront(Integer pageNo, Integer pageSize, ImUsersFriends imUsersFriends) {
        return null;
    }

    /**
     * 添加IM用户好友
     *
     * @param imUsersFriends
     * @return
     */
    @Override
    public int insert(ImUsersFriends imUsersFriends) {
        return 0;
    }

    /**
     * 删除IM用户好友
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改IM用户好友
     *
     * @param imUsersFriends
     * @return
     */
    @Override
    public int edit(ImUsersFriends imUsersFriends) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsersFriends
     */
    @Override
    public ImUsersFriends queryById(int id) {
        return null;
    }
}