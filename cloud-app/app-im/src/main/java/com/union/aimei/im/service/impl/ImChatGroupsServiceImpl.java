package com.union.aimei.im.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImChatGroups;
import com.union.aimei.im.mapper.ImChatGroupsMapper;
import com.union.aimei.im.service.ImChatGroupsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2017/12/25 18:55
 */
@Service("imChatGroupsService")
public class ImChatGroupsServiceImpl implements ImChatGroupsService {
    @Resource
    private ImChatGroupsMapper imChatGroupsMapper;

    /**
     * 前端分页查询IM群组
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param imChatGroups 查询条件
     * @return
     */
    @Override
    public PageInfo<ImChatGroups> findByPageForFront(Integer pageNo, Integer pageSize, ImChatGroups imChatGroups) {
        PageHelper.startPage(pageNo, pageSize);
        List<ImChatGroups> list = this.imChatGroupsMapper.selectListByConditions(imChatGroups);
        PageInfo<ImChatGroups> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加IM群组
     *
     * @param imChatGroups
     * @return
     */
    @Override
    public int addObj(ImChatGroups imChatGroups) {
        return this.imChatGroupsMapper.insertSelective(imChatGroups);
    }

    /**
     * 删除IM群组
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.imChatGroupsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改IM群组
     *
     * @param imChatGroups
     * @return
     */
    @Override
    public int modifyObj(ImChatGroups imChatGroups) {
        return this.imChatGroupsMapper.updateByPrimaryKeySelective(imChatGroups);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimChatGroups
     */
    @Override
    public ImChatGroups queryObjById(int id) {
        ImChatGroups model = this.imChatGroupsMapper.selectByPrimaryKey(id);
        return model;
    }
}