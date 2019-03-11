package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.BeauticianFollower;
import com.union.aimei.pc.store.mapper.BeauticianFollowerMapper;
import com.union.aimei.pc.store.service.BeauticianFollowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Service("beauticianFollowerService")
public class BeauticianFollowerServiceImpl implements BeauticianFollowerService {
    @Resource
    private BeauticianFollowerMapper beauticianFollowerMapper;

    /**
     * 前端分页查询美容师粉丝
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param beauticianFollower 查询条件
     * @return
     */
    @Override
    public PageInfo<BeauticianFollower> findByPageForFront(Integer pageNo, Integer pageSize, BeauticianFollower beauticianFollower) {
        PageHelper.startPage(pageNo, pageSize);
        List<BeauticianFollower> list = this.beauticianFollowerMapper.selectListByConditions(beauticianFollower);
        PageInfo<BeauticianFollower> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加美容师粉丝
     *
     * @param beauticianFollower
     * @return
     */
    @Override
    public int addObj(BeauticianFollower t) {
        return this.beauticianFollowerMapper.insertSelective(t);
    }

    /**
     * 删除美容师粉丝
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.beauticianFollowerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改美容师粉丝
     *
     * @param beauticianFollower
     * @return
     */
    @Override
    public int modifyObj(BeauticianFollower t) {
        return this.beauticianFollowerMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbeauticianFollower
     */
    @Override
    public BeauticianFollower queryObjById(int id) {
        BeauticianFollower model = this.beauticianFollowerMapper.selectByPrimaryKey(id);
        return model;
    }
}