package com.union.aimei.pc.im.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImChatGroupsUsers;
import com.union.aimei.pc.im.mapper.ImChatGroupsUsersMapper;
import com.union.aimei.pc.im.service.ImChatGroupsUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM群组用户
 *
 * @author liurenkai
 * @time 2017/12/25 18:55
 */
@Service("imChatGroupsUsersService")
public class ImChatGroupsUsersServiceImpl implements ImChatGroupsUsersService {
    @Resource
    private ImChatGroupsUsersMapper imChatGroupsUsersMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<ImChatGroupsUsers> list = this.imChatGroupsUsersMapper.selectListByConditions(imChatGroupsUsers);
        PageInfo<ImChatGroupsUsers> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加IM群组用户
     *
     * @param imChatGroupsUsers
     * @return
     */
    @Override
    public int addObj(ImChatGroupsUsers imChatGroupsUsers) {
        return this.imChatGroupsUsersMapper.insertSelective(imChatGroupsUsers);
    }

    /**
     * 删除IM群组用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.imChatGroupsUsersMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改IM群组用户
     *
     * @param imChatGroupsUsers
     * @return
     */
    @Override
    public int modifyObj(ImChatGroupsUsers imChatGroupsUsers) {
        return this.imChatGroupsUsersMapper.updateByPrimaryKeySelective(imChatGroupsUsers);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimChatGroupsUsers
     */
    @Override
    public ImChatGroupsUsers queryObjById(int id) {
        ImChatGroupsUsers model = this.imChatGroupsUsersMapper.selectByPrimaryKey(id);
        return model;
    }
}