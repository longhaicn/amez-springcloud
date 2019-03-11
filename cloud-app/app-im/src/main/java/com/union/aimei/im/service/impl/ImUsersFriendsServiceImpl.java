package com.union.aimei.im.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsersFriends;
import com.union.aimei.im.mapper.ImUsersFriendsMapper;
import com.union.aimei.im.service.ImUsersFriendsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM用户好友
 *
 * @author liurenkai
 * @time 2017/12/25 19:02
 */
@Service("imUsersFriendsService")
public class ImUsersFriendsServiceImpl implements ImUsersFriendsService {
    @Resource
    private ImUsersFriendsMapper imUsersFriendsMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<ImUsersFriends> list = this.imUsersFriendsMapper.selectListByConditions(imUsersFriends);
        PageInfo<ImUsersFriends> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加IM用户好友
     *
     * @param imUsersFriends
     * @return
     */
    @Override
    public int addObj(ImUsersFriends imUsersFriends) {
        return this.imUsersFriendsMapper.insertSelective(imUsersFriends);
    }

    /**
     * 删除IM用户好友
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.imUsersFriendsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改IM用户好友
     *
     * @param imUsersFriends
     * @return
     */
    @Override
    public int modifyObj(ImUsersFriends imUsersFriends) {
        return this.imUsersFriendsMapper.updateByPrimaryKeySelective(imUsersFriends);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsersFriends
     */
    @Override
    public ImUsersFriends queryObjById(int id) {
        ImUsersFriends model = this.imUsersFriendsMapper.selectByPrimaryKey(id);
        return model;
    }
}