package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.store.mapper.StoreFollowerMapper;
import com.union.aimei.store.service.StoreFollowerService;

import java.util.List;
import javax.annotation.Resource;

import com.union.aimei.common.vo.store.app.StoreByMemberIdLongitudeLatitudeResultVo;
import com.union.aimei.common.vo.store.app.StoreByMemberIdLongitudeLatitudeVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/4/11 14:40
 */
@Service("storeFollowerService")
public class StoreFollowerServiceImpl implements StoreFollowerService {
    @Resource
    private StoreFollowerMapper storeFollowerMapper;

    /**
     * 前端分页查询店铺粉丝表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeFollower 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreFollower> findByPageForFront(Integer pageNo, Integer pageSize, StoreFollower storeFollower) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreFollower> list = this.storeFollowerMapper.selectListByConditions(storeFollower);
        PageInfo<StoreFollower> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加店铺粉丝表
     *
     * @param storeFollower
     * @return
     */
    @Override
    public int addObj(StoreFollower t) {
        return this.storeFollowerMapper.insertSelective(t);
    }

    /**
     * 删除店铺粉丝表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeFollowerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺粉丝表
     *
     * @param storeFollower
     * @return
     */
    @Override
    public int modifyObj(StoreFollower t) {
        return this.storeFollowerMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreFollower
     */
    @Override
    public StoreFollower queryObjById(int id) {
        StoreFollower model = this.storeFollowerMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<PageInfo<StoreByMemberIdLongitudeLatitudeResultVo>> selectListPageByMemberIdAndLongitudeLatitude(Integer pageNo, Integer pageSize, StoreByMemberIdLongitudeLatitudeVo storeByMemberIdLongitudeLatitudeVo) {
        ResponseMessage responseMessage = new ResponseMessage ();
        PageHelper.startPage (pageNo, pageSize);
        List<StoreByMemberIdLongitudeLatitudeResultVo> list = this.storeFollowerMapper.selectListPageByMemberIdAndLongitudeLatitude (storeByMemberIdLongitudeLatitudeVo);
        PageInfo<StoreByMemberIdLongitudeLatitudeResultVo> page = new PageInfo<> (list);
        responseMessage.setData (page);
        return responseMessage;
    }
}