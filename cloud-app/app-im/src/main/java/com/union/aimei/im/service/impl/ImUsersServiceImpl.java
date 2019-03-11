package com.union.aimei.im.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.im.mapper.ImUsersMapper;
import com.union.aimei.im.service.ImUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM用户
 *
 * @author liurenkai
 * @time 2017/12/25 19:02
 */
@Service("imUsersService")
public class ImUsersServiceImpl implements ImUsersService {
    @Resource
    private ImUsersMapper imUsersMapper;

    /**
     * 前端分页查询IM用户
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param imUsers  查询条件
     * @return
     */
    @Override
    public PageInfo<ImUsers> findByPageForFront(Integer pageNo, Integer pageSize, ImUsers imUsers) {
        PageHelper.startPage(pageNo, pageSize);
        List<ImUsers> list = this.imUsersMapper.selectListByConditions(imUsers);
        PageInfo<ImUsers> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加IM用户
     *
     * @param imUsers
     * @return
     */
    @Override
    public int addObj(ImUsers imUsers) {
        return this.imUsersMapper.insertSelective(imUsers);
    }

    /**
     * 删除IM用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.imUsersMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改IM用户
     *
     * @param imUsers
     * @return
     */
    @Override
    public int modifyObj(ImUsers imUsers) {
        return this.imUsersMapper.updateByPrimaryKeySelective(imUsers);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsers
     */
    @Override
    public ImUsers queryObjById(int id) {
        ImUsers model = this.imUsersMapper.selectByPrimaryKey(id);
        return model;
    }
}