package com.union.aimei.im.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsersBlocks;
import com.union.aimei.im.mapper.ImUsersBlocksMapper;
import com.union.aimei.im.service.ImUsersBlocksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM用户黑名单
 *
 * @author liurenkai
 * @time 2017/12/25 19:01
 */
@Service("imUsersBlocksService")
public class ImUsersBlocksServiceImpl implements ImUsersBlocksService {
    @Resource
    private ImUsersBlocksMapper imUsersBlocksMapper;

    /**
     * 前端分页查询IM用户黑名单
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param imUsersBlocks 查询条件
     * @return
     */
    @Override
    public PageInfo<ImUsersBlocks> findByPageForFront(Integer pageNo, Integer pageSize, ImUsersBlocks imUsersBlocks) {
        PageHelper.startPage(pageNo, pageSize);
        List<ImUsersBlocks> list = this.imUsersBlocksMapper.selectListByConditions(imUsersBlocks);
        PageInfo<ImUsersBlocks> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加IM用户黑名单
     *
     * @param imUsersBlocks
     * @return
     */
    @Override
    public int addObj(ImUsersBlocks imUsersBlocks) {
        return this.imUsersBlocksMapper.insertSelective(imUsersBlocks);
    }

    /**
     * 删除IM用户黑名单
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.imUsersBlocksMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改IM用户黑名单
     *
     * @param imUsersBlocks
     * @return
     */
    @Override
    public int modifyObj(ImUsersBlocks imUsersBlocks) {
        return this.imUsersBlocksMapper.updateByPrimaryKeySelective(imUsersBlocks);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsersBlocks
     */
    @Override
    public ImUsersBlocks queryObjById(int id) {
        ImUsersBlocks model = this.imUsersBlocksMapper.selectByPrimaryKey(id);
        return model;
    }
}